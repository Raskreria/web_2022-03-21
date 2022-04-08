package jquery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "jquery_Json", urlPatterns = { "/jquery/json" })
public class Json extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
//		그냥 보내도 잘 작동하지만
//		가끔 javascript가 json데이터를 문자열로 인식할 수도 있다.
//		따라서 표기해주는게 좋다.
		
		out.print("{ "
				+ "\"name\" : \"김철수\","
				+ "\"age\" : 27,"
				+ "\"height\" : 175.3,"
				+ "\"addr\" : \"부산광역시\","
				+ "\"university\" : {"
				+ 	"\"name\" : \"인천대학교\","
				+ 	"\"major\" : \"컴퓨터공학과\","
				+ 	"\"number\" : 200901454,"
				+ 	"\"admission\" : 2009,"
				+	"\"graduation\" : 2016"
				+ "},"
				+ "\"school_name\": [\"샛별초\" ,\"거창중\", \"거창대성고\", \"서경대\"]"
				+ "}"
				);
//		JSON데이터는 JavaScript니까 자바에서는 
//		{ "name" : "김철수"} 이렇게 보내면 안된다
//		"{\"name\" : \"김철수\"}" 이렇게 보내줘야한다.
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
