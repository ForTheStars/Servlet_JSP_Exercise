package code09;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/teachBooks")
public class TechBooksPage extends CatalogPage {
	@Override
	public void init() throws ServletException {
		String[] ids = { "hall001", "hall002" };
	    setItems(ids);
	    setTitle("All-Time Best Computer Books");
	}
}
