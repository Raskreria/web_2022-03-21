package chapter06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ch06_Ex06", urlPatterns = { "/chapter06/session/add" })
public class Ex06 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String clientIP = request.getRemoteAddr();
		//클라이언트의 IP주소 가져오는 메서드
		
		session.setAttribute("clientIP", clientIP);
		//세션에 클라이언트의 정보 저장하기
//					매개변수 : String타입의 이름, Object타입의 데이터
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
