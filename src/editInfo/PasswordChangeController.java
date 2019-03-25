package editInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.login.Customer;
import domain.login.CustomerDao;
import domain.login.CustomerDaoImpl;
import domain.login.Login;
import local.LocalUser;

@WebServlet("/EditInfo")
public class PasswordChangeController extends HttpServlet  {
	
	public PasswordChangeController(){}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerDao customerDao = new CustomerDaoImpl();
		
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String submitType = request.getParameter("submit");
		Login login = new Login(username, pass);
		Customer c = customerDao.validateCustomer(login);
		
		
		c.setName(request.getParameter("name"));
		c.setUsername(request.getParameter("username"));
		c.setPassword(request.getParameter("password"));
		
		request.setAttribute("successMessage", request.getParameter("username"));
		
		customerDao.passChange(c);
		
		LocalUser lc = LocalUser.getInstance();
		request.setAttribute("message", "Hello "+lc.getName());
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
		
		
	}
}