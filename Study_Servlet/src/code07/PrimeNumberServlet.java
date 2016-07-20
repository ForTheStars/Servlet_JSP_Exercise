package code07;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.author.ServletUtilities;


@WebServlet("/prime.do")
public class PrimeNumberServlet extends HttpServlet {
	private ArrayList<PrimeList> primeListCollection = new ArrayList<>();
	private int maxPrimeLists = 30;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numPrimes = ServletUtilities.getIntParameter(request,"numPrimes", 50);
		int numDigits = ServletUtilities.getIntParameter(request,"numDigits", 120);
		PrimeList primeList = findPrimeList(primeListCollection, numPrimes, numDigits);
		if(primeList == null){
			primeList = new PrimeList(numPrimes, numDigits, true);
			synchronized (primeListCollection) {
				if(primeListCollection.size() >= maxPrimeLists){
					primeListCollection.remove(0);
				}
				primeListCollection.add(primeList);
			}
		}
		ArrayList<BigInteger> currentPrimes = primeList.getPrimesFound();
		int numCurrentPrimes = currentPrimes.size();
		int numPrimesRemaining = (numPrimes - numCurrentPrimes);
		boolean isLastResult = (numPrimesRemaining == 0);
		if(!isLastResult){
			response.setIntHeader("Refresh", 3);
		}
		/*
		 * PrimeNumber.jsp 连接，但是怎么跳转都不会自动刷新，原来Refresh单词错了
		 * 尝试中碰到有以下几点错误
		 * response.sendRedirect("prime.do?numPrimes="+numPrimes+"&numDigits="+numDigits); 这个重定向了
		 * response.sendRedirect("code07/PrimeNumber.jsp"); 这个需要把数据存在session(request.getSession)
		 */
		request.setAttribute("numDigits", numDigits);
		request.setAttribute("numCurrentPrimes", numCurrentPrimes);
		request.setAttribute("isLastResult", isLastResult);
		request.setAttribute("numPrimesRemaining", numPrimesRemaining);
		request.setAttribute("currentPrimes", currentPrimes);
		request.getRequestDispatcher("/code07/PrimeNumber.jsp").forward(request, response);

/*
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    String title = "Some " + numDigits + "-Digit Prime Numbers";
		    out.println(ServletUtilities.headWithTitle(title) +
		                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		                "<H2 ALIGN=CENTER>" + title + "</H2>\n" +
		                "<H3>Primes found with " + numDigits +
		                " or more digits: " + numCurrentPrimes +
		                ".</H3>");
		    if (isLastResult)
		      out.println("<B>Done searching.</B>");
		    else
		      out.println("<B>Still looking for " + numPrimesRemaining +
		                  " more<BLINK>...</BLINK></B>");
		    out.println("<OL>");
		    for(int i=0; i<numCurrentPrimes; i++) {
		      out.println("  <LI>" + currentPrimes.get(i));
		    }
		    out.println("</OL>");
		    out.println("</BODY></HTML>");
		*/
	}
	
	private PrimeList findPrimeList(ArrayList primeListCollection, int numPrimes,int numDigits){
		for(int i=0;i < primeListCollection.size();i++){
			PrimeList primes = (PrimeList)primeListCollection.get(i);
			if (numPrimes == primes.getNumPrimes() &&numDigits == primes.getNumDigits()){
		          return(primes);
		    }
		}
		return null;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
