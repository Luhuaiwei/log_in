package work1;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import theway.Theway;

public class Login extends HttpServlet{
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		try {
			System.out.println("�ж��û������뿪ʼ��");
			boolean iflog = Theway.login(name,password);
			if(iflog) {
				ResultSet rs = Theway.getall(name);
				System.out.println("��ʼת������true");
				request.setAttribute("result", rs);
				RequestDispatcher view =
						request.getRequestDispatcher("account_login.jsp");
				view.forward(request, response );
			}
			else {
				System.out.println("��ʼת������false");
				RequestDispatcher view =
					request.getRequestDispatcher("loginfair.jsp");
				view.forward(request, response );
			}		
		} catch (Exception e) {
			System.out.println("�����쳣");
			e.printStackTrace();
		}
	}
}