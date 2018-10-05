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
 * Servlet implementation class UpdateSudentServlest
 */
@WebServlet("/UpdateSudentServlest")
public class UpdateSudentServlest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UpdateSudentServlest() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Update Student</h1>");
		String studentid = request.getParameter("id");
		
		int id = Integer.parseInt(studentid);
		
		Student std = StudentSQL.ReadOneStudent(id);
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<form action=\"StudentSveUpdateServlest\" method=\"post\"> ");
		writer.println("<div class=\"form-group\">\r\n" + 
				"			    <label for=\"id\">Name:</label>\r\n" + 
				"			    <input type=\"text\" class=\"form-control\"  name=\"id\"  value=\""+std.getId()+"\">\r\n"  + 
				"		  </div>");
		writer.println("<div class=\"form-group\">\r\n" + 
				"			    <label for=\"name\">Name:</label>\r\n" + 
				"			    <input type=\"text\" class=\"form-control\"  name=\"name\" value=\""+std.getName()+"\">\r\n"  + 
				"		  </div>");
		writer.println("<div class=\"form-group\">\r\n" + 
				"		    <label for=\"pwd\">Password:</label>\r\n" + 
				"		    <input type=\"password\" class=\"form-control\"  name=\"pwd\" value=\""+std.getPassword()+"\">\r\n" + 
				"		  </div>");
		writer.println("<div class=\"form-group\">\r\n" + 
				"		    <label for=\"email\">Email address:</label>\r\n" +  
				"		    <input type=\"email\" class=\"form-control\"  name=\"email\" value=\""+std.getEmail()+"\">\r\n" + 
				"		  </div>");
		writer.println("<div class=\"form-group\">\r\n" + 
				"		    <label for=\"country\">Country:</label>\r\n" + 
				"		    <input type=\"text\" class=\"form-control\" name=\"country\" value=\" " + std.getCountry() +  "\">\r\n" + 
				"		  </div>");
		writer.println("<button type=\"submit\" class=\"btn btn-default\">Update</button>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
