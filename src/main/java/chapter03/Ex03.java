package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name  = "/ch03_Ex03", urlPatterns = {"/ch03_ex03"})
public class Ex03 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setStatus(301);
		// 상태코드를 설정해주는 메서드.
		response.setHeader("Location", "http://localhost/ch03_ex02");
		// 경로 지정
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		

		out.append("ex03으로 접근하셨습니다! append  ");
		out.print("print나 append나 같습니다. print");
		
		out.close();
	}


}
