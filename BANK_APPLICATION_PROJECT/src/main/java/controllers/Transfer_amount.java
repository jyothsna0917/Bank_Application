package controllers;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data_access_object.Bank_dao;
import data_transfer_object.Bank_dto;
import data_transfer_object.User_dto;

@WebServlet("/transferam")
public class Transfer_amount extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession();
		User_dto  udto1=(User_dto)hs.getAttribute("udto");
		String email=udto1.getEmail();
		Bank_dao bdao=new Bank_dao();
		
		String fac=req.getParameter("fromAccount");
		long fracc=Long.parseLong(fac);
		
		String tac=req.getParameter("toAccount");
		long toacc=Long.parseLong(tac);
		
		String pi=req.getParameter("pin");
		int pin=Integer.parseInt(pi);
		
		String mo=req.getParameter("amount");
		double amount=Double.parseDouble(mo);
		
		Bank_dto bdto=new Bank_dto(email, null, null, null, 0, 0, pin, 0, amount, toacc, null);
		try {
			boolean b=bdao.transfer(bdto);
			if(b==true)
			{
				String s="Transaction Successful";
				req.setAttribute("s", s);
				RequestDispatcher rd=req.getRequestDispatcher("transfer_amount.jsp");
				rd.include(req, resp);
			}
			else
			{
				String s="Transaction cancelled wrong details";
				req.setAttribute("w", s);
				RequestDispatcher rd=req.getRequestDispatcher("transfer.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
