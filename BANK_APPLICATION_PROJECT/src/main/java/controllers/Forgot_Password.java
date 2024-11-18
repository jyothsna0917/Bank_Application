package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data_transfer_object.User_dto;
import data_access_object.User_dao;
@WebServlet("/processForgotPassword")
public class Forgot_Password extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		User_dto udto=new User_dto(null, null, email, pwd, null, null, null, 0,0);
		User_dao udao=new User_dao();
		try {
			int a=udao.forgot(udto);
			if(a>0)
			{
				RequestDispatcher rd=req.getRequestDispatcher("forgot_success_message.jsp");
				rd.forward(req, resp);
			}
			else
			{
				String s="invalid email";
				req.setAttribute("s", s);
				RequestDispatcher rd=req.getRequestDispatcher("forgot_password.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
