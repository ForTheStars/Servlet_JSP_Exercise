package code04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.author.ServletUtilities;

public class SpecialCode extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = 
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 4.0 Transitional//EN>\n";
		out.println(docType+
				"<html>\n"+
				"<head><title>Study Servlet</title></head>"+
				"<body style=\"color:#00F\">"+
//				request.getParameter("code")+
				getCode(request)+    //特殊字符使用
				"</body></html>"
				);
	}
	protected String getCode(HttpServletRequest request){
		/*
		 * 对有特殊字符可进行处理
		 * 对获取的字符串进行遍历，查找特殊字符进行替换
		 * ServletUtilities 为作者自己写的工具类
		 */
		return ServletUtilities.filter(request.getParameter("code"));
	}
}
