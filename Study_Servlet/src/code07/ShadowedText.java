package code07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.author.ServletUtilities;

@WebServlet("/shadowed.do")
public class ShadowedText extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wantsList = request.getParameter("showList");
		if(wantsList != null){
			showFontList(response);
		} else {
			String message = request.getParameter("message");
			if(message == null || (message.length() == 0)){
				message = "Missing 'message' parameter";
			}
			String fontName = request.getParameter("fontName");
		    if ((fontName == null) || (fontName.length() == 0)) {
		        fontName = "Serif";
		    }
		    String fontSizeString = request.getParameter("fontSize");
		    int fontSize;
		    try {
		        fontSize = Integer.parseInt(fontSizeString);
		    } catch(NumberFormatException nfe) {
		        fontSize = 90;
		    }
		    response.setContentType("image/jpeg");
		    MessageImage.writeJPEG(
		    		MessageImage.makeMessageImage(message, fontName, fontSize), 
		    		response.getOutputStream());
		}
	}
	
	private void showFontList(HttpServletResponse response) throws IOException{
		/*
		 * 1. response.setCharacterEncoding("UTF-8");需要写在PrintWriter out = response.getWriter();的前面。拿到字符流后再设置编码是没有用的。
		 * 2. response.setHeader("content-type", "text/html;charset=UTF-8");有一种更为简单的写法response.setContentType("text/html;charset=UTF-8");。
         * 3.response.setContentType("text/html;charset=UTF-8");这句代码其实有两个作用：通知response以UTF-8输出和浏览器以UTF-8打开。
         *   即等价于response.setHeader("content-type", "text/html;charset=UTF-8");和response.setCharacterEncoding("UTF-8");两句代码。
		 */
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(ServletUtilities.headWithTitle("Fonts Available on Server")+
				"<body style=\"color:#00F\"><h1 style=\"text-align:center;\">Fonts Available on Server</h1>"+
				"<br><br>"+"<UL>");
		String[] fontNames = MessageImage.getFontNames();
		for(int i=0;i<fontNames.length;i++){
			out.println("  <LI>" + fontNames[i]);
			System.out.println(fontNames[i]);
		}
		out.println("</UL>\n" + "</BODY></HTML>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
}
