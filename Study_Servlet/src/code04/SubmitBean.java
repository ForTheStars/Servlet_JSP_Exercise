package code04;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import code.author.ServletUtilities;

@WebServlet(name="SubmitBean",urlPatterns={"/bean.do"})
public class SubmitBean extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BeanModel bean = new BeanModel();
		try {
			BeanUtils.populate(bean, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(ServletUtilities.headWithTitle("bean的使用")+
				"<body style=\"color:#00F\">"+
				"用户id:"+bean.getId()+"<br/>"+
				"用户名:"+bean.getUsername()+"<br/>"+
				"用户密码:"+bean.getPassword()+"<br/>"+
				"是否成年:"+bean.isAdult()+"<br/>"+
				"</body></html>"
				);
	}
}
