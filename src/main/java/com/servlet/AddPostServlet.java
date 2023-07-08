package com.servlet;

import java.io.IOException;
import com.entity.*;
import com.DB.DBConnect;
import com.dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add_jobs")
public class AddPostServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String title = req.getParameter("title");
			String location = req.getParameter("location");
			String category = req.getParameter("category");
			String status = req.getParameter("status");
			String desc = req.getParameter("desc");
			
			Job j =  new Job();
			j.setTitle(title);
			j.setCategory(category);
			j.setDescription(desc);
			j.setLocation(location);
			j.setStatus(status);
			
			
			HttpSession session = req.getSession();
			
			JobDAO dao = new JobDAO(DBConnect.getConn());
			boolean f = dao.addJobs(j);
			if(f) {
				session.setAttribute("succMsg","Job Post Sucessful ... ");
				resp.sendRedirect("add_jobs.jsp");
				
			}else {
				session.setAttribute("succMsg","Something Went Wrong try again ... ");
				resp.sendRedirect("add_jobs.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
