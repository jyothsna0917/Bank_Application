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
import data_transfer_object.Account_Number;
import data_transfer_object.Bank_dto;
import data_transfer_object.User_dto;
@WebServlet("/bankregis")
public class Bank_Register extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname=req.getParameter("fname");
    	String lname=req.getParameter("lname");
    	String address=req.getParameter("address");
    	String atype=req.getParameter("type");
    	
    	String ada=req.getParameter("adhar");
    	long adhar=Long.parseLong(ada);
    	String pi=req.getParameter("pin");
    	int pin=Integer.parseInt(pi);
    	String amo=req.getParameter("amount");
    	double amount=Double.parseDouble(amo);
    	
    	
    	HttpSession hs=req.getSession();
		User_dto udto1=(User_dto) hs.getAttribute("udto");
		String email=udto1.getEmail();
		int age=udto1.getAge();
		long phone=udto1.getPhone();
		
		long accno=Account_Number.generateAccountNumber();
    	Bank_dao bdao=new Bank_dao();
    	Bank_dto bdto=new Bank_dto(email,fname,lname,address,age,phone,pin,adhar,amount,accno,atype);
    	try {
			int a=bdao.registerAccount(bdto);
			if(a>0)
			{
				req.setAttribute("no", accno);
				RequestDispatcher rd=req.getRequestDispatcher("bank_success_message.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	
    }

		

}
