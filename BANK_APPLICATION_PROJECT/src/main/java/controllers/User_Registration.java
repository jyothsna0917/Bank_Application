package controllers;

import java.io.IOException;     

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import data_transfer_object.User_dto;
import data_access_object.User_dao;

@MultipartConfig(maxFileSize = 1000000000)
@WebServlet("/RegisterServle")
public class User_Registration extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname=req.getParameter("firstname");
		String lname=req.getParameter("lastname");
		String address=req.getParameter("address");
		String gender=req.getParameter("gender");
		String email=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		String ag=req.getParameter("ag");
		int age=Integer.parseInt(ag);
		String pho=req.getParameter("phone");
		long phone=Long.parseLong(pho);
		Part p=req.getPart("ima");
		String image_path=null;
		if(p!=null&& p.getSize() > 0)
		{
			String up=getServletContext().getRealPath("/uploads/");
			image_path="uploads/"+p.getSubmittedFileName();
			p.write(up + p.getSubmittedFileName());
		}
		User_dto udto=new User_dto(fname, lname, email, pwd, gender, address, image_path, age,phone);
		User_dao udao=new User_dao();
		try {
			int a=udao.register(udto);
			if(a>0)
			{
				RequestDispatcher rd=req.getRequestDispatcher("success_registration_message.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			
			String s="Email already exists please try with another";
			req.setAttribute("s", s);
			RequestDispatcher rd=req.getRequestDispatcher("user_registration.jsp");
			rd.include(req, resp);
		}
	}

}
