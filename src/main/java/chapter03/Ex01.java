package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch03_Ex01", urlPatterns = { "/chapter03/Ex01" })
public class Ex01 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");		
//		response.setContentType("MIME TYPE;charset=UTF-8");
					//어떤형태의 데이터를; 어떤식으로 보정했다.
//		MIME TYPE : 어떤 형태의 데이터인지
//		MIME TYPE : 구글에 검색해서 해당 데이터의 마임타입을 확인해서 쓰자.
		
		PrintWriter outputstream = response.getWriter();
		outputstream.append("<html>");
		outputstream.append("	<head>");
		outputstream.append("		<title>Servlet Response Web Page</title>");
		outputstream.append("	</head>");
		outputstream.append("	<body>");
		outputstream.append("		<h1>Nice to meet you!</h1>");
		outputstream.append("		<h1>만나서 반갑습니다!</h1>");
		outputstream.append("	</body>");
		outputstream.append("</html>");
		
		outputstream.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
