package code04;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.author.BeanUtilities;

import javax.servlet.annotation.*;

@WebServlet(name="ControlServlet",urlPatterns={"/control.do"})
public class ControlServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("method");
		if(str == null || str.trim().equals("loginInput")){
			loginInput(request, response);
		}else if(str.trim().equals("login")){
			login(request, response);
		}
	}
	
	protected void loginInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/code04/bean.jsp").forward(request, response);
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errors = new HashMap<>();
		boolean isEmp = false;
		BeanModel bean = new BeanModel();
		BeanUtilities.populateBean(bean, request);
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String str = parameterNames.nextElement();
			if(isEmpty(request.getParameter(str))){
				isEmp=true;
				errors.put(str, str+"不能为空");
			}
		}
		if(isEmp){
			request.setAttribute("errors", errors);
			request.setAttribute("bean", bean);
			loginInput(request, response);
			return;
		}		
		response.getWriter().println("ok!!!");
	}
	private boolean isEmpty(String str){
		if((str == null) || str.trim().equals("")){
			return true;
		}
		return false;
	}
}
