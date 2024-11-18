package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data_transfer_object.Bank_dto;
import data_transfer_object.User_dto;
import data_access_object.Bank_dao;
@WebServlet("/balances")
public class Balance_enquiry extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession();
		User_dto  udto1=(User_dto)hs.getAttribute("udto");
		String email=udto1.getEmail();
		Bank_dao bdao=new Bank_dao();
		String pi=req.getParameter("pin");
		int pin=Integer.parseInt(pi);
		Bank_dto bdto=new Bank_dto(email, null, null, null, 0, 0, pin, 0, 0, 0, null);
		try {	
			double bal=bdao.showbalance(bdto);
			if(bal>=0)
			{
				req.setAttribute("bal", bal);
				RequestDispatcher rd=req.getRequestDispatcher("show_balances.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
