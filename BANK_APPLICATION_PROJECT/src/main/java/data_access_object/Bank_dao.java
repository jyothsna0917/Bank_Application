package data_access_object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import data_transfer_object.Bank_dto;

public class Bank_dao {
	
	public static Connection con() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project?createDatabaseIfNotExist=true","root","root");
		return con;
	}
	
	public static void createTable() throws Exception
	{
		Statement s=con().createStatement();
		s.execute("create table if not exists bank(email varchar(45) primary key,fname varchar(45),lname varchar(45),address varchar(45),age int(10),phone bigint(10),pin int(10),balance double,accno bigint(12),ifsc varchar(45),adhar bigint(12),acctype varchar(45))");
	}
	
	
    public int registerAccount(Bank_dto bdto) throws Exception {
        createTable();
        PreparedStatement ps=con().prepareStatement("insert into bank values(?,?,?,?,?,?,?,?,?,?,?,?)");    
            ps.setString(1, bdto.getEmail());
            ps.setString(2, bdto.getFirstName());
            ps.setString(3, bdto.getLastName());
            ps.setString(4, bdto.getAddress());
            ps.setInt(5, bdto.getAge());
            ps.setLong(6, bdto.getPhone());
            ps.setInt(7, bdto.getPin());
            ps.setDouble(8, bdto.getBalance());
            ps.setLong(9, bdto.getAccNo());
            ps.setString(10,"ADN123");
            ps.setLong(11, bdto.getAdhar());
            ps.setString(12, bdto.getAcctype());
            int a=ps.executeUpdate();
            return a;
        }
    
    public double showbalance(Bank_dto bdto) throws Exception
	{
		PreparedStatement ps=con().prepareStatement("select * from bank where email=?");
		ps.setString(1, bdto.getEmail());
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			int pin=rs.getInt("pin");
			if(pin==bdto.getPin())
			{

				double s=rs.getDouble("balance");
				return s;
			}
		}
		return 0;
		
	}
    
    public boolean transfer(Bank_dto bdto) throws Exception
    {
    	PreparedStatement ps=con().prepareStatement("select * from bank where email=?");
    	ps.setString(1, bdto.getEmail());
    	ResultSet rs=ps.executeQuery();
    	if(rs.next())
    	{
    		if(rs.getInt("pin")==bdto.getPin())
    		{
    			PreparedStatement ps1=con().prepareStatement("select * from bank where accno=?");
    			ps1.setLong(1, bdto.getAccNo());
    			ResultSet rs1=ps1.executeQuery();
    			if(rs1.next())
    			{
    				if(bdto.getBalance()<=rs.getDouble("balance"))
    				{
    					double d=bdto.getBalance();
    					double dd=rs.getDouble("balance");
    					double ddd=dd-d;
    					PreparedStatement ps2=con().prepareStatement("update bank set balance=? where email=?");
    					ps2.setDouble(1, ddd);
    					ps2.setString(2, bdto.getEmail());
    					ps2.execute();
    					double dddd=rs1.getDouble("balance");
    					double d5=dddd+d;
    					PreparedStatement ps3=con().prepareStatement("update bank set balance=? where accno=?");
    					ps3.setDouble(1, d5);
    					ps3.setLong(2, bdto.getAccNo());
    					ps3.execute();
    					return true;
    				}
    			}
    		}
    		
    	}
		return false;
    }


}
