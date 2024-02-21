package sec05.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "contextFileServlet", value = { "/cfile", "/ctxfile" })
//@WebServlet(value = { "/cfile", "/ctxfile" })
//@WebServlet(urlPatterns = { "/cfile", "/ctxfile" })
//@WebServlet(name = "contextFileServlet", urlPatterns = { "/cfile", "/ctxfile" })
@WebServlet(value = {"/cfile","/ctxfile"}, initParams = { @WebInitParam(name = "b", value = "banana") }, loadOnStartup = 1)
//@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("hi");
		String str1 = getInitParameter("b");
		System.out.println(str1);

		ServletContext context = getServletContext();
		String addr = context.getContextPath();
		System.out.println(addr);

		// 명명된 경로에 있는 리소스를 InputStream에 넣습니다.
//		InputStream is = context.getResourceAsStream("C:/Users/Administrator/eclipse-workspace/pro08/hi1.txt");
//		InputStream is = context.getResourceAsStream("/pro08/hi1.txt");

		// hi1,2,3 파일은 나중에 classpath 경로로 설정
		InputStream is = context.getResourceAsStream("/WEB-INF/hi5.txt");
		System.out.println(is);

		InputStreamReader isr = new InputStreamReader(is);
		System.out.println(isr);

		BufferedReader br = new BufferedReader(isr);
		System.out.println(br);

		String txt = "";
		while ((txt = br.readLine()) != null) {
			System.out.println(txt);
//			txt=br.readLine();
		}

//		String txt =br.readLine();
//
//		while(txt!= null) {
//			System.out.println(txt);
//			txt=br.readLine();
//		}

//		String txt = "";
//		while (txt != null) {
//
//			System.out.println(txt);
//			txt = br.readLine();
//		}

//		byte buffer[] = new byte[100];
//
//		while (true) {
//			int data = isr.read();
//
//			if (data == -1) {
//				break;
//			}
//			System.out.print((char) data);
//		}

//		InputStream is2 = context.getResourceAsStream("/hi4.txt");
//		System.out.println(is2);

//		InputStream isr= new InputStreamReader(is);
//		System.out.println(isr);

	}
}
