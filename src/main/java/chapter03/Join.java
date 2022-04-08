package chapter03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ch03_join", urlPatterns = { "/ch03_join" })
public class Join extends HttpServlet {
//	private List<String> idList = new ArrayList<>();
//	private List<String> pwList = new ArrayList<>();
	
	//데이터 베이스 대신 회원정보를 저장할 수 있는 리스트를 일단 만들어 볼까?
	// 그치만 저렇게 하면 아이디와 비밀번호가 따로 저장되니까 문제다.
	// -> 클래스로 만들자 MemberInfo 클래스 만들자.
	
	/**
	 * 
	 */


	public static List<MemberInfo> memberInfoList = new ArrayList<>();
	
	public boolean checkParameter(String id, String pw, HttpServletResponse response) throws IOException {
		boolean pass = true;
		//파라미터가 올바른지 여부.
		if( id.length()==0 || pw.length()==0 ) {
			//아이디 비밀번호 입력 여부
			pass = false;
			response.sendRedirect("/joinFail.html");
		}else if( id.indexOf(" ") != -1   || pw.indexOf(" ") != -1) {
			//아이디 비밀번호 공백 포함 여부
			pass = false;
			response.sendRedirect("/joinFail.html");
		}else if( !(id.length()>=4 &&id.length()<=10) || !(pw.length()>=6 && pw.length()<=16) ) {
			//아이디 비밀번호 길이 체크.
			pass = false;
			response.sendRedirect("/joinFail.html");
		}
		// ++ 그 외 추가로 아이디 비밀번호 허가 특수문자 포함.ㅣ
		return pass;
	}
	
	public boolean usedId(String id) {
			
		// 아이디 중복 여부 체크
		boolean exist = false; // 중복되면 true
		for(int i = 0 ; i<memberInfoList.size() ; i++) {
			MemberInfo m = memberInfoList.get(i);
			if(m.getId().equals(id)) {
				//아이디 중복 표시
				exist = true;
				break;
			}
		}
		return exist;
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");	
		MemberInfo memberInfo = new MemberInfo(id,pw);
		boolean exist = usedId(id); 	//아이디 중복 체크 / 중복 = true
		
		
		
		boolean pass = checkParameter(id,pw,response);
//		파라미터가 올바른지 여부를 확인
//		올바르지 않다면 클라이언트가 리다이렉트 해야할 경로를 지정해줬으므로
//		올바르지 않을 때는 리다이렉트 해야할 경로로 이동하도록 이 서블릿이 그대로 끝날 수 있게 if문을 구성
		if (!pass) {
			return;
		}
		
		
		if(exist) {	//아이디 중복
			response.sendRedirect("/joinFail.html");
		}
		else {
			memberInfoList.add(memberInfo);
			response.sendRedirect("/joinSuccess.html");
			//회원가입
			//회원가입 완료 페이지로 이동.
		}	
	}



}
