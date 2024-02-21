package test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/test")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberDAO memDAO = new MemberDAO();

	public void init(ServletConfig config) throws ServletException {
		System.out.println("MemberServlet 초기화");
	}

	public void destroy() {
		System.out.println("MemberServlet 종료");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("현재 request 객체 "+request);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
//		System.out.println("doHandle 메소드 실행");
		PrintWriter pw = response.getWriter();
//		pw.write("hi");
		String command = request.getParameter("command");
		System.out.println("커맨드: " + command);

		MemberDAO dao = new MemberDAO();
//		List<MemberVO> list = dao.listMembers();

		if (command != null && command.equals("addMember")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			System.out.println("가입 정보 : " + id + ", " + pwd + ", " + name + ", " + email);

			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);

			dao.addMember(vo);
		} else if (command != null && command.equals("delMember")) {
			System.out.println("여기는 삭제시 코드");
			String id = request.getParameter("id");
			System.out.println("삭제 id: " + id);
			dao.delMember(id);
		}

		List<MemberVO> list = dao.listMembers();
		System.out.println(list);
		System.out.println("----------------------");
		request.setAttribute("list", list); // 속성 설정
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("viewMembers");
		dispatcher.forward(request, response);
		
		pw.close();

	}

}
