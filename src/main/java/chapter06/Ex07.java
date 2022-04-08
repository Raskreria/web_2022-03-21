package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ch06_Ex07", urlPatterns = { "/chapter06/session/get" })
public class Ex07 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String clientIP = (String)session.getAttribute("clientIP");
		//object타입으로 형변환해서 저장되었으니 언박싱해줘야함.
		
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter output = response.getWriter();
		output.print("<h1>당신의 IP는 <span style=\"color:red;\">"+clientIP+"</span>입니다.</h1>");
		
		session.removeAttribute("");
		//세션을 삭제하기
		output.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
