package code08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.author.CookieUtilities;
import code.author.ServletUtilities;
/*
 * 记录用户的访问次数
 */
@WebServlet("/count.do")
public class ClientAccessCounts extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countString = CookieUtilities.getCookieValue(request, "accessCount", "0");
		int count;
		try {
			count = Integer.parseInt(countString);
		} catch (NumberFormatException e) {
			count = 0;
		}
		LongLivedCookie cookie = new LongLivedCookie("accessCount", String.valueOf(++count));
		response.addCookie(cookie);
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println(ServletUtilities.headWithTitle("RepeatVisitor")+
				"<body style=\"color:#00F\"><h1 style=\"text-align:center;\">Access Count Servlet</h1>"+
				"This is visit number " +count+
				"<br><br>"+
				"</body></html>");
	}
}
