package rides;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;



@WebServlet("/UnclaimRide")
public class RideUnclaimController extends HttpServlet {
	
	public RideUnclaimController() {}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();		
		
		Ride r = DbManager.getRide(Integer.parseInt(request.getQueryString()));
		r.setDriver(null);
		DbManager.saveRide(r);
		output.println("<h4>Ride Unclaimed</h4> <a href=\"myclaims.jsp\">return to home screen</a>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}