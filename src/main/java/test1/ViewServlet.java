package test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
		
		pw.write("<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"UTF-8\">"
				+ "<title>Insert title here</title>" + "<style>table,tr,th,td {" + "border: solid 2px black;"
				+ "border-collapse: collapse;" + " padding: 8px;}</style>" + "</head>"
				+ "<table><tr><th>아이디##</th><th>비밀번호</th>" + "<th>이름</th><th>이메일</th><th>가입일</th></tr>");

		for (int i = 0; i < list.size(); i++) {
			String id = list.get(i).getId();
			String pwd = list.get(i).getPwd();
			String name = list.get(i).getName();
			String email = list.get(i).getEmail();
			Date joinDate = list.get(i).getJoinDate();
			pw.write("<tr><td>\r\n" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>"
					+ joinDate + "</td>" + "<td><a href='http://localhost:8090/pro08/test?command=delMember&id=" + id
					+ "'>삭제</a></td>" + "</tr>");
		}
		pw.write("</table>" + "<body>" + "<tr></tr>" + "<a href='http://localhost:8090/pro08/NewFile.html'>새 회원 등록하기"
				+ "</body>" + "</html>");
//		memDAO.listMembers();

		pw.close();
	}

}
