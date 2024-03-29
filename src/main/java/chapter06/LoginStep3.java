package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//로그인 step3
//비밀번호 확인 & 로그인 처리 서블릿
//step2에서 검색한 사용자의 비밀번화와
//로그인 화면에서 사용자가 입력한 비밀번호를 대조해
//같다면 로그인 성공 처리
//다르다면 로그인 실패 처리

@WebServlet("/chapter06/login/step3")
public class LoginStep3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String step2Pass = (String)request.getAttribute("step2");
		if(step2Pass==null) {
			//step2을 통과하지 않고 직접 URL을 통해서 Step3로 접근했음.
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h1>접근권한이 없습니다!.</h1>");
			out.close();
			return;
		}//여기까지 추가
		String pw = request.getParameter("pw");
		MemberInfo memberInfo = (MemberInfo)request.getAttribute("memberInfo");
		//step2로 붙어 넘겨받은 특정아이디의 memberInfo
		String memberPW = memberInfo.getPw();
	
		boolean isSame = memberPW.equals(pw); 
		if(isSame) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", "true");
			response.sendRedirect("/member/login/loginSuccess.html");
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h1>비밀번호가 일치하지 않습니다.</h1>");
			out.close();
		}
		
		//id 로 조회한 사용자의 pw와 
		//사용자가 입력한 pw를 대조
		//대조했을 때 일치한다면 로그인 성공 처리(세션에 isLogin의 값을 true로 기록)
		//일치하지 않는다면 로그인 실패 처리(비밀번호를 확인하세요 등 문구 출력)
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

