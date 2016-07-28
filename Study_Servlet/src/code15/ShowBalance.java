package code15;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/balance.do")
public class ShowBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BankCustomer customer = BankCustomer.getCustomer(id);
		String address;
		if(customer == null){
			address = "/WEB-INF/code15/UnknownCustomer.jsp";
		} else if(customer.getBalance() < 0){
			address = "/WEB-INF/code15/NegativeBalance.jsp";
			request.setAttribute("badCustomer", customer);
		} else if(customer.getBalance() < 10000){
			address = "/WEB-INF/code15/NormalBalance.jsp";
			request.setAttribute("regularCustomer", customer);
		} else {
			address = "/WEB-INF/code15/HighBalance.jsp";
			request.setAttribute("eliteCustomer", customer);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
