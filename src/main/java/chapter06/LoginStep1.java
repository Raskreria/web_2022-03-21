package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//로그인 step1
//파라미터 확인 서블릿
//로그인을 하기 위해 필요한 파라미터를 전달했는지 확인하는 서블릿
@WebServlet("/chapter06/login/step1")
public class LoginStep1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id"); //
		String pw = request.getParameter("pw"); // 클라이언트가 보낸 id,pw 파라미터

		if ((id == null || pw == null) || (id.length() == 0 || pw.length() == 0)) {
			// 로그인에 필요한 파라미터중 하나이상 전달받지 못했다.
			// sendRedirect로 페이지로 보내주거나
			// 아니면 직접 html출력을 해도 되겠지?
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h1>아이디 또는 비밀번호를 입력하세요</h1>");
			out.close();
		} else {
			request.setAttribute("step1", "pass");	//여기
			// 아이디와 비밀번호를 잘 전달 받았다면 다음 서블릿으로 이동
			RequestDispatcher rd = request.getRequestDispatcher("/chapter06/login/step2");
			// requestDispatcher의 인자는 경로 항상 /부터 시작
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
