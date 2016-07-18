package code06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchEngines
 */
@WebServlet("/search.do")
public class SearchEngines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchString = request.getParameter("searchString");
		if(searchString == null || searchString.trim().equals("")){
			reportProblem(response, "Missing search string");
		    return;
		}
		
		String searchEngineName = request.getParameter("searchEngine");
		if(searchEngineName == null || searchEngineName.trim().equals("")){
			reportProblem(response, "Unrecognized search engine");
		    return;
		}
		response.sendRedirect(SearchUtil.makeUrl(searchEngineName, searchString));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void reportProblem(HttpServletResponse response,String message) throws IOException{
		response.sendError(response.SC_NOT_FOUND, message);
	}
}
