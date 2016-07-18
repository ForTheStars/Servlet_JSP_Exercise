package code06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * User-Agent 报头指出具体浏览器(或移动电话，其他客户程序)
 * 大多数浏览器User-Agent报头包含Mozilla，但只有微软ie包含 MSIE
 * 根据用户浏览器产生相应的跳转
 */
@WebServlet(name="WrongDestination",urlPatterns={"/des.do"})
public class WrongDestination extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userAgent = request.getHeader("User-Agent");
		if(userAgent != null && userAgent.indexOf("MSIE") != -1){
			response.sendRedirect("http://www.microsoft.com/zh-cn");
		} else {
			response.sendRedirect("https://www.baidu.com/");
		}
	}
}
