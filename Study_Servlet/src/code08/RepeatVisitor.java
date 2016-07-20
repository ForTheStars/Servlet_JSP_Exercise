package code08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.author.ServletUtilities;
/*
 * 使用cookie区分用户是第一次访问，还是再次访问网站
 * 页面输出 第一次：Welcome Aboard 再次：Welcome Back
 */
@WebServlet("/visitor.do")
public class RepeatVisitor extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean newbie = true;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("repeatVisitor") && cookie.getValue().equals("yes")){
					newbie = false;
					break;
				}
			}
		}
		String title;
		if(newbie){
			Cookie returnVisitorCookie = new Cookie("repeatVisitor", "yes");
			returnVisitorCookie.setMaxAge(60*60*24*365);
			response.addCookie(returnVisitorCookie);
			title = "Welcome Aboard";
		} else {
			title = "Welcome Back";
		}
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println(ServletUtilities.headWithTitle("RepeatVisitor")+
				"<body style=\"color:#00F\"><h1 style=\"text-align:center;\">"+
				title+
				"</h1><br><br>"+
				"</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
