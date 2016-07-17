package code04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.*;

@WebServlet(name="form",urlPatterns={"/form.do"})
public class form extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * post中文乱码解决方案
		 * setCharacterEncoding("UTF-8")
		 */
		request.setCharacterEncoding("UTF-8");
		//读取form表单元素值，区分大小写
		String username = request.getParameter("username"); 
		System.out.println(username);
		/*
		 * 参数缺失或异常时简单处理
		 */
		Map<String, String> errors = new HashMap<>();
		request.setAttribute("errors", errors);
		boolean isEmp = false;
		
		//根据获取form表单参数名得到参数值
		Enumeration<String> parameterNames = request.getParameterNames();//获取form表单参数名
		while(parameterNames.hasMoreElements()){
			String str = parameterNames.nextElement();
			if(isEmpty(request.getParameter(str))){
				isEmp=true;
				errors.put(str, str+"不能为空");
			}
		}
		/*
		 * 服务器端跳转：request.getRequestDispatcher("xxx.jsp").forward(request,response)
		 * 客户端跳转：response.sendRedirect("xxx.jsp")
		 */
		if(isEmp){
			request.getRequestDispatcher("/code04/form.jsp").forward(request,response);
		}
		PrintWriter out = response.getWriter();
		out.println("Login was successful,ok!!!");
	}
	private boolean isEmpty(String str){
		if((str == null) || str.trim().equals("")){
			return true;
		}
		return false;
	}
}
