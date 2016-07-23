package code09;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/kidsBooks")
public class KidsBooksPage extends CatalogPage {
	@Override
	public void init() throws ServletException {
		String[] ids = { "lewis001", "alexander001", "rowling001" };
	    setItems(ids);
	    setTitle("All-Time Best Children's Fantasy Books");
	}
}
