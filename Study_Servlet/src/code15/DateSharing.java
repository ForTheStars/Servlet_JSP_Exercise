package code15;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/data")
public class DateSharing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//基于请求的数据共享
		DateBean dateBean1 = new DateBean("HttpServletRequest", "request");
		request.setAttribute("dateBean1", dateBean1);
		//基于会话的数据共享
		DateBean dateBean2 = new DateBean("HttpSession", "session");
		HttpSession session = request.getSession();
		session.setAttribute("dateBean2", dateBean2);
		//基于应用的数据共享
		DateBean dateBean3 = new DateBean("ServletContext", "application");
		ServletContext context = this.getServletContext();
		context.setAttribute("dateBean3", dateBean3);
		//服务器端跳转
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/code15/dataSharing.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
