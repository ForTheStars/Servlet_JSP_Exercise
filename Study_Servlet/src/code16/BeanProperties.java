package code16;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BeanProperties")
public class BeanProperties extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NameBean nameBean = new NameBean("Marty", "Hall");
		CompanyBean companyBean = new CompanyBean("coreservlets.com", "J2EE Training and Consulting");
		EmployeeBean employeeBean = new EmployeeBean(nameBean, companyBean);
		request.setAttribute("employee", employeeBean);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/code16/bean-properties.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
