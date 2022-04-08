package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch06_Ex11", urlPatterns = { "/ch06_Ex11" })
public class Ex11 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String value1 = (String)request.getAttribute("name1");
		//setAttribute로 담았던 데이터를 꺼내는 것.
		//어떤 서블릿이 담았던 데이터를 꺼내는 것.
		//오브젝트로 저장하고 오브젝트로 꺼내오기 때문에 형변환
		
		String value2 = request.getParameter("name2");
		//파라미터로 전달한 값을 꺼내올 때
		//클라이언트가 전달한 값을 꺼내올 떄
		
		response.setContentType("text/html;chatset=utf-8");
		out.print("! ch06_Ex11 Servlet !");
		out.print("<h1>name1 = " + value1 + "</h1>");
		out.print("<h1>name2 = " + value2 + "</h1>");
		
		
		
		out.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
