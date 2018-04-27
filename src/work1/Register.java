package work1;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import theway.Theway;

public class Register extends HttpServlet{
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		try {
			Theway.regist(name,password);
			RequestDispatcher view =
					request.getRequestDispatcher("register.jsp");
			view.forward(request, response );
		} catch (Exception e) {
			System.out.println("∑¢…˙“Ï≥£");
			e.printStackTrace();
		}
	}
}
