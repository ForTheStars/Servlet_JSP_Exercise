package code08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.author.ServletUtilities;
/*
 * 设置6个cookie，3个没有明确时间(默认情况下为负值)，其他三个规定浏览器写入磁盘，保存一小时
 */
public class CookieTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(int i=0;i<3;i++){
			Cookie cookie = new Cookie("Session-Cookie-" + i, "Cookie-Value-S" + i);
			response.addCookie(cookie);
			cookie = new Cookie("Persistent-Cookie-" + i, "Cookie-Value-P" + i);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(ServletUtilities.headWithTitle("CookieTest")+
				"<body style=\"color:#00F\"><h1 style=\"text-align:center;\">Active Cookies</h1>"+
				"<br><br>"+
				"<table boread=1 align=\"center\">\n"+
				"<tr bgcolor=\"#FFAD00\">\n" +
                "<th>Cookie Name<th>Cookie Value");
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			out.println("<tr><td>"+cookie.getName()+"</td>");
			out.println("<td>"+cookie.getValue()+"</td></tr>");
		}
		out.println("</table></body></html>");
	}
}
