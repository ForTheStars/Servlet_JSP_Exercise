package code16;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/collections")
public class Collections extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] firstNames = { "Bill", "Scott", "Larry" };
		ArrayList<String> lastNames = new ArrayList<>();
		lastNames.add("Ellison");
	    lastNames.add("Gates");
	    lastNames.add("McNealy");
	    HashMap<String, String> companyNames = new HashMap<>();
	    companyNames.put("Ellison", "Sun");
	    companyNames.put("Gates", "Oracle");
	    companyNames.put("McNealy", "Microsoft");
	    request.setAttribute("first", firstNames); 
	    request.setAttribute("last", lastNames);
	    request.setAttribute("company", companyNames);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/code16/collections.jsp");
	    dispatcher.forward(request, response);
	}
}
