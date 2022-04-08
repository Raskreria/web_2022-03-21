package jquery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "jquery_Ex01", urlPatterns = { "/jquery/ex01" })
public class Ex01 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		웹페이지에 보여줄 데이터를 조회하는 코드1
//		웹페이지에 보여줄 데이터를 조회하는 코드2
//		웹페이지에 보여줄 데이터를 조회하는 코드3
//		웹페이지에 보여줄 데이터를 조회하는 코드4
//		...
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		데이터를 불러오는 시간이 3초가 걸린다고 가정하기
		
//		조회한 데이터를 보여주는 페이지를 클라이언트에게 전달
		response.sendRedirect("/index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
