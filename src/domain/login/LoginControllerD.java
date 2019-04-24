package domain.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;
import local.LocalUser;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginControllerD")
public class LoginControllerD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginControllerD() {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DriverDao driverDao = new DriverDaolmpl();

		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String submitType = request.getParameter("submit");
		Login login = new Login(username, pass);
		Driver c;

		if (submitType.equals("login")) {
			c = DbManager.getDriver(username);
			System.out.println("Got driver");
			System.out.println("C null? " + (c == null));

			if (c != null && c.Validate(login)) {
				LocalUser lu = LocalUser.getInstance();
				lu.setName(c.getName());
				lu.setPass(pass);
				lu.setUsername(username);
				lu.setUser(c);
				request.setAttribute("message", "Hello " + c.getName());
				request.getRequestDispatcher("dummy.jsp").forward(request, response);
			} else if (c != null) {
				request.setAttribute("message", "Your password is incorrect.");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			} else {
				request.setAttribute("message", "Data Not Found! Please register!");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} else if (submitType.equals("register")) {
			c = new Driver(request.getParameter("username"), request.getParameter("password"),
					request.getParameter("name"));
			driverDao.register(c);
			request.setAttribute("successMessage", "Registration done, please login!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Data Not Found! Please register!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

}