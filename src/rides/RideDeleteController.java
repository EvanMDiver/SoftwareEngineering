package rides;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;



@WebServlet("/DeleteRide")
public class RideDeleteController extends HttpServlet {
	
	public RideDeleteController() {}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();		
		
		DbManager.delete(DbManager.getRide(Integer.parseInt(request.getQueryString())));
		output.println("<h4>file deleted</h4> <a href=\"welcome.jsp\">return to home screen</a>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}