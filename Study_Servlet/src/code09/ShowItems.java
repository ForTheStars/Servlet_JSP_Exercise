package code09;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import code.author.ServletUtilities;


@WebServlet("/ShowItems")
public class ShowItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<String> previousItems = (ArrayList<String>)session.getAttribute("previousItems");
		if(previousItems == null){
			previousItems = new ArrayList<>();
			session.setAttribute("previousItems", previousItems);
		}
		String newItem = request.getParameter("newItem");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(ServletUtilities.headWithTitle("Session")+
				"<body style=\"color:#00F\"><h1 style=\"text-align:center;\">Items Purchased</h1>"+
				"<br><br>");
		synchronized (previousItems) {
			if(newItem != null && !(newItem.trim().equals(""))){
				previousItems.add(newItem);
			}
			if(previousItems.size() == 0){
				out.println("<I>No items</I>");
			} else {
				out.println("<ul>");
				for(int i=0;i<previousItems.size();i++){
					out.println("<li>"+previousItems.get(i)+"</li>");
				}
				out.println("</ul>");
			}
		}
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
