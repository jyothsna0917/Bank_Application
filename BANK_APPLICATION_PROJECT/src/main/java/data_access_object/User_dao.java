package data_access_object;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data_transfer_object.User_dto;

public class User_dao {
	public static Connection con() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project?createDatabaseIfNotExist=true","root","root");
		return con;
	}
	public static void createTable() throws Exception
	{
		Statement s=con().createStatement();
		s.execute("create table if not exists user(email varchar(45) primary key,fname varchar(45),lname varchar(45),pwd varchar(45),gender varchar(45),address varchar(45),age int(5),phone bigint(10),image varchar(45))");
	}
	
	public int register(User_dto udto) throws Exception
	{
		createTable();
		PreparedStatement ps=con().prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?)");
		ps.setString(1, udto.getEmail());
		ps.setString(2, udto.getFirstname());
		ps.setString(3, udto.getLastname());
		ps.setString(4, udto.getPwd());
		ps.setString(5, udto.getGender());
		ps.setString(6,udto.getAddress());
		ps.setInt(7, udto.getAge());
		ps.setLong(8, udto.getPhone());
		ps.setString(9, udto.getImage());
		int a=ps.executeUpdate();
		return a;
	}
	
	
	public String login(User_dto udto) throws Exception
	{
		PreparedStatement ps=con().prepareStatement("select email,pwd from user where email=?");
		ps.setString(1, udto.getEmail());
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			if(rs.getString("pwd").equals(udto.getPwd()))
			{
				return "success";
			}
			else
			{
				return "Invalid password";
			}
		}
		else
		{
			return "Invalid email";
		}
	}
	
	
	public User_dto profile(String email2) throws Exception
	{
		PreparedStatement ps=con().prepareStatement("select * from user where email=?");
//		ps.setString(1, udto.getEmail()); i will add after
		ps.setString(1, email2);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			String fname=rs.getString("fname");
			String lname=rs.getString("lname");
			String email=rs.getString("email");
			String gender=rs.getString("gender");
			String address=rs.getString("address");
			int age=rs.getInt("age");
			long phone=rs.getLong("phone");
			String path=rs.getString("image");
			String pwd=rs.getString("pwd");
			User_dto udto1=new User_dto(fname, lname, email, pwd, gender, address, path, age, phone);
			return udto1;
			
		}
		return null;
	}
	
	public User_dto updateProfile(User_dto udto) throws Exception
	{
		PreparedStatement ps=con().prepareStatement("update user set image=? where email=?");
		ps.setString(1, udto.getImage());
		ps.setString(2, udto.getEmail());
		ps.execute();
		
		PreparedStatement ps1=con().prepareStatement("select * from user where email=?");
		ps1.setString(1, udto.getEmail());
		ResultSet rs=ps1.executeQuery();
		if(rs.next())
		{
			User_dto udto1=new User_dto(rs.getString("fname"), rs.getString("lname"),rs.getString("email"), rs.getString("pwd"), rs.getString("gender"), rs.getString("address"), rs.getString("image"), rs.getInt("age"),rs.getLong("phone"));
			return udto1;
		}
		return null;
	}
	
	public int forgot(User_dto udto) throws Exception
	{
		PreparedStatement ps=con().prepareStatement("select * from user where email=?");
		ps.setString(1, udto.getEmail());
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			PreparedStatement ps1=con().prepareStatement("update  user set pwd=? where(email=?)");
			ps1.setString(1, udto.getPwd());
			ps1.setString(2, udto.getEmail());
			ps1.execute();
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public int update(User_dto udto) throws Exception
	{
		PreparedStatement ps=con().prepareStatement("update user set fname=?,lname=?,phone=?,age=?,gender=? where email=?");
		ps.setString(1, udto.getFirstname());
		ps.setString(2, udto.getLastname());
		ps.setLong(3, udto.getPhone());
		ps.setInt(4, udto.getAge());
		ps.setString(5, udto.getGender());
		ps.setString(6, udto.getEmail());
		int a=ps.executeUpdate();
		return a;
	}
	
	public int delete(User_dto udto) throws Exception
	{
		PreparedStatement ps=con().prepareStatement("delete from user where email=?");
		ps.setString(1, udto.getEmail());
		int a=ps.executeUpdate();
		return a;
	}


}
