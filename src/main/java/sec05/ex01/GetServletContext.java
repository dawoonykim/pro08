package sec05.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/cget")
public class GetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hi");

		ServletContext context = getServletContext();
		System.out.println(context);

//		System.out.println(context.getContextPath());
//		context.setAttribute("a", "apple");
//		String str = (String) context.getAttribute("a");
//		System.out.println(str);

		// 파라미터는 초기화해야 사용 가능
//		context.getInitParameter("haha");
		Enumeration<String> enu = context.getInitParameterNames();
		System.out.println(enu);
		while (enu.hasMoreElements()) {
			String element = enu.nextElement();
			System.out.println(element);
		}

		String value = context.getInitParameter("haha");
		System.out.println(value);
		
		String value2 = context.getInitParameter("haha2");
		System.out.println(value2);
	}

}
