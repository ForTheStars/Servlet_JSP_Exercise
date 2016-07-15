package code03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 构建一个10个整数的数组，由于这些数字来至于复杂的计算。不希望每次请求重复这些计算
 * 因此在 doGet方法中查找 init 中计算出的值
 * servlet是输出是不会改变的(除非服务器重启)，程序中init还存在一个页面修改日期，
 * 由getLastModified()方法使用，返回修改时间
 */
public class LotteryNumbers extends HttpServlet {
	private long modTime;
	private int[] numbers = new int[10];
	
	@Override
	public void init() throws ServletException {
		modTime = System.currentTimeMillis()/1000*1000;
		for(int i=0;i < numbers.length;i++){
			numbers[i] = randomNum();
		}
		ServletConfig config = getServletConfig();
		/*
		 * init test
		 */
		String test = config.getInitParameter("test");
		System.out.println(test);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = 
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 4.0 Transitional//EN>\n";
		out.println(docType+
				"<html>\n"+
				"<head><title>Study Servlet</title></head>"+
				"<body style=\"color:#00F\">"+
				"<br/><br/>"
				);
		for(int i=0;i<numbers.length;i++){
			out.println("<h1>"+(i+1)+": "+numbers[i]+"</h1><br/>");
		}
		out.println("</body></html>");
	}
	@Override
	protected long getLastModified(HttpServletRequest request) {
		return modTime;
	}
	
	private int randomNum(){
		return (int)(Math.random()*100);
	}
}
