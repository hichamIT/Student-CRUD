package com.hicham.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hicham.students.Student;
import com.hicham.students.StudentSQL;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		List<Student> list = StudentSQL.ReadAllStudent();
		
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<a href=\"index.html\" class=\"btn btn-info\" role=\"button\">View Students</a>");
		writer.println("<h1>Table Of Students</h1>");
		writer.println("<table class=\"table\">");
		writer.println("<thead>\r\n" + 
				"    <tr>\r\n" + 
				"      <th scope=\"col\">Id</th>\r\n" + 
				"      <th scope=\"col\">Name</th>\r\n" +
				"      <th scope=\"col\">Password</th>\r\n" +
				"      <th scope=\"col\">Email</th>\r\n" + 
				"      <th scope=\"col\">Country</th>\r\n" + 
				"      <th scope=\"col\">Edit</th>\r\n" + 
				"      <th scope=\"col\">Delete</th>\r\n" + 
				"    </tr>\r\n" + 
				"  </thead>\r\n" + 
				"  <tbody> " );
		
		for (Student student : list) {
			
			writer.println("<tr>\r\n" + 
					"      <th scope=\"row\">" + student.getId() + " </th>\r\n" + 
					"      <td> " + student.getName() + "</td>\r\n" + 
					"      <td> " + student.getPassword() + " </td>\r\n" + 
					"      <td> " + student.getEmail() + "</td>\r\n" + 
					"      <td> " + student.getCountry() + "</td>\r\n" +
					"      <td><a href=\"UpdateSudentServlest?id="+student.getId()+" \">Edit Student</a></td>\r\n" +
					"      <td><a href=\"StudentDeleteServlest?id="+ student.getId()+" \"> Delete Student</a></td>\r\n" +
					"    </tr>");

		
		}
		
		
		writer.println("<tbody>");
		writer.println("</table>");
		writer.println("</body>");
		writer.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
