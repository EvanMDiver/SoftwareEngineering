package domain.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.LocalUser;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginControllerD")
public class LoginControllerD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginControllerD() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DriverDao driverDao = new DriverDaolmpl();
		
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String submitType = request.getParameter("submit");
		Login login = new Login(username, pass);
		Driver c = driverDao.validateDriver(login);
		
		if(submitType.equals("login") && c!=null && c.getName()!=null){
			LocalUser lu=LocalUser.getInstance();
			lu.setName(c.getName());
			lu.setPass(pass);
			lu.setUsername(username);
			request.setAttribute("message", "Hello "+c.getName());
			request.getRequestDispatcher("dummy.jsp").forward(request, response);
			
		}else if(submitType.equals("register")){
			c.setName(request.getParameter("name"));
			c.setUsername(request.getParameter("username"));
			c.setPassword(request.getParameter("password"));
			driverDao.register(c);
			request.setAttribute("successMessage", "Registration done, please login!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "Data Not Found! Please register!");
			request.getRequestDispatcher("registerD.jsp").forward(request, response);
		}

	}

}