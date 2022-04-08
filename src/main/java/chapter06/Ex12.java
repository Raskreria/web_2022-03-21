package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex12
 */
@WebServlet(name = "ch06_Ex12", urlPatterns = { "/ch06_Ex12" })
public class Ex12 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		response.setContentType("text/html;chatset=utf-8");
		out.print("! ch06_Ex12 Servlet !");
			
		RequestDispatcher rd = request.getRequestDispatcher("/ch06_Ex11");
		
		request.setAttribute("name1", "value1");
		rd.include(request,response);
		//제어가 include한 쪽으로 넘어감. 인자로는 요청정보와 응답정보를 보낸다.
		//제어가 잠깐 넘어갔다가 돌아옴.
		
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
