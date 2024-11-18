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
@WebServlet("/dele")
public class Delete_profile extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession();
		User_dto  udto1=(User_dto)hs.getAttribute("udto");
		String email=udto1.getEmail();
		User_dao udao=new User_dao();
		User_dto udto=new User_dto(null, null, email,null, null, null, null, 0, 0);
		try {
			int a=udao.delete(udto);
			if(a>0)
			{
				RequestDispatcher rd=req.getRequestDispatcher("login_page.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
