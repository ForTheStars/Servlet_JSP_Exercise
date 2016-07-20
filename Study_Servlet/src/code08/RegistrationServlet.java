package code08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.author.CookieUtilities;
import code.author.ServletUtilities;
import code05.ShowCGIVariables;

@WebServlet("/reg.do")
public class RegistrationServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method == null){
			form(request, response);
		} else {
			show(request, response);
		}
	}
	
	protected void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName =CookieUtilities.getCookieValue(request, "firstName", "");
	    String lastName =CookieUtilities.getCookieValue(request, "lastName", "");
		String emailAddress =CookieUtilities.getCookieValue(request, "emailAddress","");
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		request.setAttribute("emailAddress", emailAddress);
		System.out.println("xx"+firstName+"xx");
		request.getRequestDispatcher("/code08/RegistrationForm.jsp").forward(request, response);
	}
		
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMissingValue = false;
		
		String firstName = request.getParameter("firstName");
		if(isMissing(firstName)){
			firstName = "";
			isMissingValue = true;
		}
		String lastName = request.getParameter("lastName");
		if(isMissing(lastName)){
			lastName = "";
			isMissingValue = true;
		}
		String emailAddress = request.getParameter("emailAddress");
		if(isMissing(emailAddress)){
			emailAddress = "";
			isMissingValue = true;
		}
		Cookie cookie1 = new LongLivedCookie("firstName", firstName);
		response.addCookie(cookie1);
		Cookie cookie2 = new LongLivedCookie("lastName", lastName);
		response.addCookie(cookie2);
		Cookie cookie3 = new LongLivedCookie("emailAddress", emailAddress);
		response.addCookie(cookie3);
		if(isMissingValue){
			//request.getRequestDispatcher("/reg.do").forward(request, response);
			response.sendRedirect("reg.do");
		} else {
			response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.println(ServletUtilities.headWithTitle("RegistrationServlet")+
					"<body style=\"color:#00F\"><h1 style=\"text-align:center;\">Thanks for Registering</h1>"+
					"<br><br>"+
					"<ul>"+
					"<li><b>firstName: </b>"+firstName+
					"<li><b>lastName: </b>"+lastName+
					"<li><b>emailAddress: </b>"+emailAddress+
					"</ul></body></html>");
		}
	}
	
	private boolean isMissing(String param){
		if(param == null || param.trim().equals("")){
			return true;
		}
		return false;
	}
}
