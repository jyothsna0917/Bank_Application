package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data_transfer_object.User_dto;
import data_access_object.User_dao;
@WebServlet("/UpdateServlet")
public class user_details_update extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String firstname=req.getParameter("firstName");
		String lastname=req.getParameter("lastName");
		String pho=req.getParameter("phno");
		long phone=Long.parseLong(pho);
		String ag=req.getParameter("age");
		int age=Integer.parseInt(ag);
		String gender=req.getParameter("gender");
		HttpSession hs=req.getSession();
		User_dto udto1=(User_dto) hs.getAttribute("udto");
		String email=udto1.getEmail();
		
		User_dao udao=new User_dao();
		User_dto udto=new User_dto(firstname, lastname, email, null, gender, null, null, age, phone);
		try {
			int a=udao.update(udto);
			if(a>0)
			{
				String s1="updated successfully";
				req.setAttribute("s1", s1);
				RequestDispatcher rd=req.getRequestDispatcher("user_profile_update.jsp");
				rd.include(req, resp);
			}
			else
			{
				String s2="Not completed please check your details";
				req.setAttribute("s2", s2);
				RequestDispatcher rd=req.getRequestDispatcher("user_profile_update.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
