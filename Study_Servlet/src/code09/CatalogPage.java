package code09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.author.ServletUtilities;

public abstract class CatalogPage extends HttpServlet {
	private CatalogItem[] items;
	private String[] itemIDs;
	private String title;
	
	protected void setItems(String[] itemIDs) {
		this.itemIDs = itemIDs;
		items = new CatalogItem[itemIDs.length];
		for (int i = 0; i < items.length; i++) {
			items[i] = Catalog.getItem(itemIDs[i]);
		}
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(items == null){
			response.sendError(response.SC_NOT_FOUND,"Missing Items.");
			return;
		}
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(ServletUtilities.headWithTitle("shopping")+
				"<body style=\"color:#00F\"><h1 style=\"text-align:center;\">"+title+"</h1>"+
				"<br>");
		CatalogItem item;
		for(int i=0;i<items.length;i++){
			out.println("<hr>");
		    item = items[i];
		    if (item == null) {
		        out.println("<font color=\"RED\">" +
		                    "Unknown item ID " + itemIDs[i] +
		                    "</font>");
		    } else {
		    	out.println();
		        String formURL =
		          "/study/order.do";
		        //formURL = response.encodeURL(formURL);
		        out.println
		          ("<form action=\"http://localhost:8080" + formURL + "\">\n" +
		           "<input type=\"hidden\" name=\"itemID\" " +
		           "       value=\"" + item.getItemID() + "\">\n" +
		           "<H2>" + item.getShortDescription() +
		           " ($" + item.getCost() + ")</H2>\n" +
		           item.getLongDescription() + "\n" +
		           "<P>\n<center>\n" +
		           "<input type=\"submit\" " +
		           "value=\"Add to Shopping Cart\">\n" +
		           "</center>\n<P>\n</form>");
		    }
		}
	}
	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
