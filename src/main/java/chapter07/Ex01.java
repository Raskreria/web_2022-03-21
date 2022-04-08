package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch07_Ex01", urlPatterns = { "/chapter07/ex01" })
public class Ex01 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("<< Servlet1 호출 >>");
//		response.setContentType("text/html;charset=utf-8");
		//매 서블릿마다 써줘야하는 불편한 코드. MIME TYPE지정 코드
		PrintWriter out = response.getWriter();
		out.print("<h1>여기는 Servlet1 입니다</h1>");
		
//		out.close();
		//필터로 제어가 돌아가서 필터에서 close를 해주기 때문에 close를 써서는 안된다.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
