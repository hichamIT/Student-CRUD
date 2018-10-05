package com.hicham.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hicham.students.Student;
import com.hicham.students.StudentSQL;

/**
 * Servlet implementation class StudentSveUpdateServlest
 */
@WebServlet("/StudentSveUpdateServlest")
public class StudentSveUpdateServlest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentSveUpdateServlest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String studentid = request.getParameter("id");
		int id = Integer.parseInt(studentid);
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Student std = new Student();
		
		std.setId(id);
		std.setName(name);
		std.setPassword(pwd);
		std.setEmail(email);
		std.setCountry(country);
		
		int num = StudentSQL.UpdateStudent(std);
		
		if (num > 0) {
			
			response.sendRedirect("ViewServlet");
			
		} else {
			
			writer.println("<h2>Sorry not updated</h2>");
		}
	}

}
