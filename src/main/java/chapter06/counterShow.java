package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch06_counterShow", urlPatterns = { "/ch06_counterShow" })
public class counterShow extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientIP = request.getRemoteAddr();
		int count = (int) getServletContext().getAttribute(clientIP);
		
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter output  =response.getWriter();
		
		output.print("<h1>아이피 : " + clientIP + "</h1>");
		output.print("<h1>이용 횟수 : " + count + "</h1>");
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
