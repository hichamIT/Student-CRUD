package com.hicham.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hicham.students.StudentSQL;


@WebServlet("/StudentDeleteServlest")
public class StudentDeleteServlest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentDeleteServlest() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String studentid = request.getParameter("id");
		int id = Integer.parseInt(studentid);
		
		StudentSQL.DeleteStudent(id);
		
		response.sendRedirect("ViewServlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
