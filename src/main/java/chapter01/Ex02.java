package chapter01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class Ex02 extends HttpServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("서비스 메서드 호출!");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("이닛 메서드 호출!");
	}

	
	
}
