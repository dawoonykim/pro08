package sec03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("여기는 FirstServlet");

		// HttpServletRequest
		// HTTP 서블릿에 대한 요청 정보를 제공하기 위해 ServletRequest 인터페이스를 확장한다.
		// 서블릿 컨테이너는 HttpServletRequest 객체를 생성하고, 이를 서블릿의 서비스 메소드(doGet, doPost 등)에 인수로
		// 전달한다.

		// dispatch: 보내다
		// RequestDispatcher
		// 클라이언트로부터 요청을 수신하고 이를 서버의 리소스(예: 서블릿, HTML 파일 또는 JSP 파일)로 보내는 객체를 생성한다.
		
		// 여기서는 request 한 번
		RequestDispatcher dispatcher = request.getRequestDispatcher("second");
		dispatcher.forward(request, response);

	}

}
