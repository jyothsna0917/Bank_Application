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
@WebServlet("/login")
public class User_Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		User_dto udto=new User_dto(null, null,email, pwd, null, null, null, 0, 0);
		User_dao udao=new User_dao();
		
		try {
			String result=udao.login(udto);
			if(result.equals("success"))
			{
				HttpSession hs=req.getSession();
				User_dto udto1=udao.profile(email);
				hs.setAttribute("udto", udto1);
				RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
			}
			else
			{
				req.setAttribute("result", result);
				RequestDispatcher rd=req.getRequestDispatcher("login_page.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
