package chapter05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex01 extends HttpServlet{
	private int value;
	private String name;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 호출됨");
		//
		req.setCharacterEncoding("UTF-8");
		name = req.getParameter("name");
		//클라이언트가 보낸 데이터를 꺼내기 위한 설정
		//
		
		//
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 3초간 재우기.
		
		//
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.append("당신이 전달한 name 파라미터의 값은 ["+name+"] 입니다.");
		//클라이언트에게 전달할 데이터를 보내기위한 설정
		
		System.out.println("init-param태그로 전달 받은 value의 값 => " + value);
	}

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿 생성");
		
		String value = config.getInitParameter("value");
		
		System.out.println("value = " + value);
		
		//1번방법
		Integer valueInt = new Integer(value); 
		//2번방법
		valueInt = Integer.parseInt(value);
		
//		value 변수 안에는 숫자처럼 생긴 문자열이 들어있습니다.
//		value 변수 안에 들어있는 값을 정수로 바꿔 value 멤버 변수에 저장하세요
		this.value = valueInt; //오토언박싱
	}
	

}
