package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import data_transfer_object.User_dto;
import data_access_object.User_dao;

@MultipartConfig(maxFileSize = 1000000000)
@WebServlet("/updatepr")
public class Update_profile_Image extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part p=req.getPart("ima");
		String up=getServletContext().getRealPath("/uploads/");
		String image_path="uploads/"+p.getSubmittedFileName();
		p.write(up + p.getSubmittedFileName());
		HttpSession hs=req.getSession();
		User_dto udto1=(User_dto) hs.getAttribute("udto");
		String email=udto1.getEmail();
		
		User_dto udto=new User_dto(null, null, email, null, null, null, image_path,0,0);
		User_dao udao=new User_dao();
		try {
			User_dto a=(User_dto) udao.updateProfile(udto);
			
				req.setAttribute("udto1", a);
				RequestDispatcher rd=req.getRequestDispatcher("profile_showing.jsp");
				rd.include(req, resp);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
