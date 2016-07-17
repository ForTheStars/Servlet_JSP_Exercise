package code05;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.author.ServletUtilities;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;

@WebServlet(name="ShowCGIVariables",urlPatterns={"/CGI.do"})
public class ShowCGIVariables extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String[][] variables={
				{ "AUTH_TYPE", request.getAuthType() },
		        { "CONTENT_LENGTH",String.valueOf(request.getContentLength()) },
		        { "CONTENT_TYPE", request.getContentType() },
		        { "DOCUMENT_ROOT",getServletContext().getRealPath("/") },
		        { "PATH_INFO", request.getPathInfo() },
		        { "PATH_TRANSLATED", request.getPathTranslated() },
		        { "QUERY_STRING", request.getQueryString() },
		        { "REMOTE_ADDR", request.getRemoteAddr() },
		        { "REMOTE_HOST", request.getRemoteHost() },
		        { "REMOTE_USER", request.getRemoteUser() },
		        { "REQUEST_METHOD", request.getMethod() },
		        { "SCRIPT_NAME", request.getServletPath() },
		        { "SERVER_NAME", request.getServerName() },
		        { "SERVER_PORT",String.valueOf(request.getServerPort()) },
		        { "SERVER_PROTOCOL", request.getProtocol() },
		        { "SERVER_SOFTWARE",getServletContext().getServerInfo() }
		};
		out.println(ServletUtilities.headWithTitle("ShowCGIVariables")+
				"<body style=\"color:#00F\"><h1 style=\"text-align:center;\">ShowCGIVariables</h1>"+
				"<br><br>"+
				"<table boread=1 align=\"center\">\n"+
				"<tr bgcolor=\"#FFAD00\">\n" +
                "<th>CGI Variable Name<th>Value");
		for(int i=0;i<variables.length;i++){
			String varName = variables[i][0];
			String varValue = variables[i][1];
			if(varValue == null){
				 varValue = "<I>Not specified</I>";
			}
			out.println("<tr><td>"+varName+"</td>");
			out.println("<td>"+varValue+"</td></tr>");
		}
		out.println("</table></body></html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
