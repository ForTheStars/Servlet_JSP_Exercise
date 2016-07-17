package code05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.author.ServletUtilities;

import javax.servlet.annotation.*;

@WebServlet(name="ShowRequestHeaders",urlPatterns={"/header.do"})
public class ShowRequestHeaders extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println(ServletUtilities.headWithTitle("ShowRequestHeaders")+
				"<body style=\"color:#00F\"><h1 style=\"text-align:center;\">ShowRequestHeaders</h1>"+
				"<B>Request Method: </B>"+request.getMethod()+"<br>"+
				"<B>Request URL: </B>"+request.getRequestURI()+"<br>"+
				"<B>Request Protocol: </B>"+request.getProtocol()+"<br><br>"+
				"<table boread=1 align=\"center\">\n"+
				"<tr bgcolor=\"#FFAD00\">\n" +
                "<th>Header Name<th>Header Value");
		Enumeration headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String headName = (String)headerNames.nextElement();
			out.println("<tr><td>"+headName+"</td>");
			out.println("<td>"+request.getHeader(headName)+"</td></tr>");
		}
		out.println("</table></body></html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
