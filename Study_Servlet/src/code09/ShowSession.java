package code09;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import code.author.ServletUtilities;

@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String heading;
		Integer accessCount = (Integer)session.getAttribute("accessCount");
		if(accessCount == null){
			accessCount = new Integer(0);
			heading = "Welcome, Newcomer";
		} else {
			 heading = "Welcome Back";
			 accessCount = new Integer(accessCount.intValue()+1);
		}
		session.setAttribute("accessCount", accessCount);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(ServletUtilities.headWithTitle("Session Tracking Example")+
				"<body style=\"color:#00F\"><h1 style=\"text-align:center;\">"+heading+"</h1>"+
				"<h2 style=\"text-align:center;\">Information on Your Session:</h2>"+
				"<br><br>"+
				"<table boread=1 align=\"center\">\n"+
				"<tr bgcolor=\"#FFAD00\">\n" +
                "<th>Info Type<th>Value"+
				"<tr><td>ID</td><td>"+session.getId()+"</td>"+
				"<tr><td>Creation Time</td><td>"+new Date(session.getCreationTime())+"</td>"+
				"<tr><td>Time of Last Access</td><td>"+new Date(session.getLastAccessedTime())+"</td>"+
				"<tr><td>Number of Previous Accesses</td><td>"+accessCount+"</td>"
				);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
