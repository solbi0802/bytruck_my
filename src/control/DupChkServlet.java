package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

public class DupChkServlet extends HttpServlet{
	private UserService service = new UserService();
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet");
		
		String idValue = request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			String result = service.dupChk(idValue);
			System.out.println(result);
			out.print(result);
		}catch(Exception e) {
			out.print(e.getMessage());
		}	
	}

}
