package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class joinSuccess
 */
@WebServlet(name = "ch06_joinSuccess", urlPatterns = { "/servlet/member/joinSuccess" })
public class joinSuccess extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		try {
		for(Cookie cookie : cookies) {
			String name = cookie.getName();
			//쿠키 가져오기
			if(name.equals("isJoin")) {
				//isJoin 쿠키이면 value true인지 확인 
				String value = cookie.getValue();
				if(value.equals("true")) {
					//true일때만
					response.setContentType("text/html;charset=utf-8");
					PrintWriter output = response.getWriter();
					
					output.print("<h1>회원 가입 완료</h1>");
					output.print("<a href=\"/member/main/\">메인 페이지로 이동</a>");
					
					output.close();
				}
			}
		}
		}
		catch(NullPointerException e) {
			//true일때만
			response.setContentType("text/html;charset=utf-8");
			PrintWriter output = response.getWriter();
			
			output.print("<h1>접근 권한이 없습니다.</h1>");
			output.print("<a href=\"/member/join/join.html\">화원가입 페이지로 이동</a>");
			output.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
