package com.servlet;

import java.io.IOException;

import com.DB.DBConnect;
import com.dao.JobDAO;
import com.entity.Job;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class updateJobServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			int id = Integer.parseInt(req.getParameter("id"));
			String title = req.getParameter("title");
			String location = req.getParameter("location");
			String category = req.getParameter("category");
			String status = req.getParameter("status");
			String desc = req.getParameter("desc");

			Job j = new Job();
			j.setId(id);
			j.setTitle(title);
			j.setDescription(desc);
			j.setLocation(location);
			j.setCategory(category);
			j.setStatus(status);

			HttpSession session = req.getSession();

			JobDAO dao = new JobDAO(DBConnect.getConn());
			boolean f = dao.updateJobs(j);
			if (f) {
				session.setAttribute("succMsg", "Job Updated Sucessful ... ");
				resp.sendRedirect("view_jobs.jsp");

			} else {
				session.setAttribute("succMsg", "Something Went Wrong try again ... ");
				resp.sendRedirect("view_jobs.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
