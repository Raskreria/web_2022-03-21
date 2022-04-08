package chapter06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//로그인 step2
//회원정보 조회 서블릿
//사용자가 입력한 아이도로 회원정보 검색
@WebServlet("/chapter06/login/step2")
public class LoginStep2 extends HttpServlet {
	//DB역할을 할 회원정보 리스트
	public static List<MemberInfo> database;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		database = new ArrayList<>(); 
		//서버가 생성되면 데이터베이스 생성하기.
		MemberInfo memberInfo = new MemberInfo("id1","pw1","name1");
		database.add(memberInfo);
		//회원가입 역할을 하는 코드
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String step1Pass = (String)request.getAttribute("step1");
		if(step1Pass==null) {
			//step1을 통과하지 않고 직접 URL을 통해서 Step2로 접근했음.
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h1>접근권한이 없습니다!.</h1>");
			out.close();
			return;
		}//여기까지 추가
		String id = request.getParameter("id");
		//아이디를 사용해서 회원정보를 꺼내기만 할 서블릿.
		MemberInfo memberInfo = null; 
		for(MemberInfo nthMemberInfo : database) {
			String nthMemberId = nthMemberInfo.getId();
			if(nthMemberId.equals(id)) {
				memberInfo = nthMemberInfo;
			}
		}
		
		if(memberInfo == null) {
			//사용자가 입력한 아이디와 일치하는 회원정보 없음
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h1>일치하는 아이디가 없습니다.</h1>");
			out.close();
			
		}else {
			//
			request.setAttribute("step2", "pass");
			request.setAttribute("memberInfo", memberInfo);
			//아이디로 성공적으로 조회했을 때 회원정보를 다음 서블릿으로 넘겨주기
			
			//
			RequestDispatcher rd = request.getRequestDispatcher("/chapter06/login/step3");
			//requestDispatcher의 인자는 경로 항상 /부터 시작
			rd.forward(request, response);
			//step3로 이동해 비밀번호 대조 및 로그인 처리
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
