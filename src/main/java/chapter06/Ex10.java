package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch06_Ex10", urlPatterns = { "/ch06_Ex10" })
public class Ex10 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.print("! ch06_Ex10 Servlet !");
		
		//응답하고자하는 걸 다 응답해줬으면 close
		//응답이 다 나가기 전에 forward를 해줘야함.
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch06_Ex11");
		//forward or include할때만 사용.
		//forwarf 할거니까 인자로 forward할 서블릿의 URI를 입력해준다.
		
		request.setAttribute("name1", "value1");
		rd.forward(request,response);
		//제어가 foward한 쪽으로 넘어감. 인자로는 요청정보와 응답정보를 보낸다.
		
		//이제 제어를 넘겨받을 ch06_Ex11을 만들자.
		
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
