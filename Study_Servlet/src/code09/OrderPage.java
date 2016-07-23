package code09;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import code.author.ServletUtilities;

@WebServlet("/order.do")
public class OrderPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShoppingCart cart;
		synchronized (session) {
			cart = (ShoppingCart)session.getAttribute("shoppingCart");
			if(cart == null){
				cart = new ShoppingCart();
				session.setAttribute("shoppingCart", cart);
			}
			String itemID = request.getParameter("itemID");
			if(itemID != null){
				 String numItemsString = request.getParameter("numItems");
				 if(numItemsString == null){
					 cart.addItem(itemID);
				 } else {
					 int numItems;
					 try {
						numItems = Integer.parseInt(numItemsString);
					} catch (NumberFormatException e) {
						numItems = 0;
					}
					 cart.setNumOrdered(itemID, numItems+1);
				 }
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(ServletUtilities.headWithTitle("Session")+
				"<body style=\"color:#00F\"><h1 style=\"text-align:center;\">Status of Your Order</h1>"+
				"<br><br>");
		synchronized (session) {
			List<ItemOrder> itemsOrdered = cart.getItemsOrdered();
			if(itemsOrdered.size() == 0){
				out.println("<H2><I>No items in your cart...</I></H2>");
			} else {
				out.println
		          ("<table border=1 align=\"CENTER\">\n" +
		           "<tr bgcolor=\"#FFAD00\">\n" +
		           "  <th>Item ID<th>Description\n" +
		           "  <th>Unit Cost<th>Number<th>Total Cost");
				ItemOrder order;
				NumberFormat formatter = NumberFormat.getCurrencyInstance();
				for(int i=0;i<itemsOrdered.size();i++){
					order = (ItemOrder)itemsOrdered.get(i);
					 out.println
			            ("<tr>\n" +
			             "  <td>" + order.getItemID() + "\n" +
			             "  <td>" + order.getShortDescription() + "\n" +
			             "  <td>" +formatter.format(order.getUnitCost())+ "\n" +
			             "  <td>" +
			             "<form>\n" +  // 提交到当前servlet
				             "<input type=\"HIDDEN\" name=\"itemID\"\n" +
				             "       value=\"" + order.getItemID() + "\">\n" +
				             "<input type=\"TEXT\" name=\"numItems\"\n" +
				             "       SIZE=3 value=\"" + order.getNumItems() + "\">\n" +
				             "<SMALL>\n" +
				             	"<input type=\"submit\"\n "+"value=\"Update Order\">\n" +
				             "</SMALL>\n" +
			             "</form>\n" +
			             "  <td>" +formatter.format(order.getTotalCost()));
				}
				String checkoutURL = "/study/code09/Checkout.html";
				//checkoutURL = response.encodeURL(checkoutURL);
			        out.println
			          ("</TABLE>\n" +
			           "<FORM ACTION=\"http://localhost:8080" + checkoutURL + "\">\n" +
			           "<BIG><CENTER>\n" +
			           "<INPUT TYPE=\"SUBMIT\"\n" +
			           "       VALUE=\"Proceed to Checkout\">\n" +
			           "</CENTER></BIG></FORM>");
			}
			out.println("</BODY></HTML>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
