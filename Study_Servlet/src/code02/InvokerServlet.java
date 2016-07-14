package code02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;

/*
 * 1.引入包javax.servlet.annotation.*，
 * 2.web.xml中web-app项的metadata-complete属性必须设为false(这个我没找到，没设置也ok，先记录下来)
 * 3.使用如下注解
 */
@WebServlet(name="InvokerServlet",urlPatterns={"/invoker.do","/inv.do"})
public class InvokerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String docType = 
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 4.0 Transitional//EN>\n";
		out.println(docType+
				"<html>\n"+
				"<head><title>Study Servlet</title></head>"+
				"<body style=\"color:#00F\"><h1>Tomcat 7/8 不支持 Invoker Servlet 的解决方法</h1>"+
				"</body></html>"
				);
	}
}
