package chapter03;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "ch03_Ex05", urlPatterns = { "/ch03_Ex05" })
public class Ex05 extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberInfo m = new MemberInfo(id,pw);
		boolean success = false;
		
		for(MemberInfo nthMemberInfo : Join.memberInfoList ) {
			if(nthMemberInfo.equals(m)) {
				success = true;
				break;
			}
		}
		
		if(success) {
			response.sendRedirect("loginSuccess.html");
		}
		else {
			response.sendRedirect("loginFail.html");
		}
		
//		#로그인 : 회원 정보 중 사용자가 입력한 아이디와 비밀번호가 일치하는 회원정보를 select 
//		회원 정보 DB와 처음부터 끝까지 접근해서
//		n번째 회원의 아이디와 비밀번호가 사용자가 입력한 아이디, 비밀번호와 일치한다면
//		로그인 성공
//		일치하지 않는다면
//		로그인 실패
		
		System.out.println("클라이언트가 전달한 id 값 => " + id);
		System.out.println("클라이언트가 전달한 pw 값 => " + pw);
		
		// http://아이피주소(192.168.10.15):포트번호(80)/ch03_Ex05/id= 1234 & pw = 1234
		// http://localhost/ch03_Ex05/id= & pw = 로 가져온다.
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
