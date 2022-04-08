package jquery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "jquery_second", urlPatterns = { "/jquery/second" })
public class second extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트가 보낸 데이터를 꺼내서 출력하세요
		String data1 = request.getParameter("name1");
		String data2 = request.getParameter("name2");
		
		System.out.println("ajax로 전달받은 데이터 name1 : "+ data1 + ", name2 : "+data2);
		
		//첫 번째 컨텐츠를 DB에서 불러옴 1초걸린다 가정
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//불러온 첫 번째 컨텐츠를 클라이언트에게 전달함.
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("두번째 컨텐츠");
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
