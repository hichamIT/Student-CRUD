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

@WebServlet("/SaveStudentServlet")
public class SaveStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SaveStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Student std = new Student();
		std.setName(name);
		std.setPassword(password);
		std.setEmail(email);
		std.setCountry(country);
		
		 int num = StudentSQL.SaveStudent(std);
		    
			if (num > 0) {
				
				writer.println("<h2>saved successflly</h2>");
				
				request.getRequestDispatcher("index.html").include(request, response);
				
			} else {
				
				writer.println("<h2>Sorry not saved</h2>");
			}
			
		} 
		
		
	}

