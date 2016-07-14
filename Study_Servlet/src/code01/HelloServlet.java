package code01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = 
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 4.0 Transitional//EN>\n";
		out.println(docType+
				"<html>\n"+
				"<head><title>Study Servlet</title></head>"+
				"<body style=\"color:#00F\"><h1>Hello Servlet</h1>"+
				"</body></html>"
				);
	}
}
