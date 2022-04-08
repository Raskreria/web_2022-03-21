package chapter04;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch04_ex01")
public class ch04_Ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String[] hobby = request.getParameterValues("hobby");
//		현재 hobby는 checkbox 타입으로 0개~여러개 선택할 수 있다.
//		이처럼 하나의 이름(name)에 여러개의 값(values)들이 온다면 getParameterValues()메서드 사용 
//		이 경우 URI에 ?hobby=sports&hobby=reading 이런식으로 넘어온다. 
		String gender = request.getParameter("gender");
		String religion = request.getParameter("religion");
		String intro = request.getParameter("intro");

		System.out.println("post 파라미터 출력");
		System.out.println("id = " + id);
		try {
			for (String str : hobby) {
				System.out.println(str + " ");
			}
		}catch(NullPointerException e) {
			System.out.println("hobby에 아무것도 입력되지 않았습니다");
		}
		
		
//		System.out.println("hobbys = " + Arrays.toString(hobby));
		System.out.println("gender = " + gender);
		System.out.println("intro = " + intro);
	}

}
