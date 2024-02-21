package sec05.ex01;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/cset")
public class SetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hi");

		ServletContext context = getServletContext();
		System.out.println(context);

		System.out.println(context.getContextPath());
		context.setAttribute("a", "apple");
		String str = (String) context.getAttribute("a");
		System.out.println(str);
	}

}
