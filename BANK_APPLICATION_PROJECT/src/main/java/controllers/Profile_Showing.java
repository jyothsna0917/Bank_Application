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

@WebServlet("/profi")
public class Profile_Showing extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession();
		User_dto udto1=(User_dto) hs.getAttribute("udto");
		User_dao udao=new User_dao();
		String email=udto1.getEmail();
		try {
			User_dto udto2=udao.profile(email);
			req.setAttribute("udto1", udto2);
			RequestDispatcher rd=req.getRequestDispatcher("profile_showing.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			
		}
	}

}
