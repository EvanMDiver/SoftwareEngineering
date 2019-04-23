package rides;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;
import domain.login.Driver;
import local.LocalUser;

@WebServlet("/UnclaimedRides")
public class RequestClaimController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequestClaimController() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/unclaimedrides.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.print("Made it here");

		int rideId = Integer.parseInt(request.getParameter("rideId"));
		
		Ride r = DbManager.getRide(rideId);
		
		if(r.getDriver() == null) {
			//okay to set new driver
			//r.setDriver((Driver) LocalUser.getUser()); //commented out because no drivers exist yet
			r.setDriver(new Driver("testDriver", "test", "Test Driver"));
			DbManager.saveRide(r);
		}
		
		doGet(request, response);
		
		
		
		
	}
	
	public static String getTable() throws SQLException {
		ArrayList<Ride> rides = DbManager.getRides();
		Date d = new Date();
		

		String out = d.toString() +"\n<style>\r\n" + "table, th, td {\r\n" + "  border: 1px solid black;\r\n" + "}\r\n"
				+ "</style> " + "<table style=\"width:100%\">\r\n"+ "  <tr>\r\n" + "  <tr>\r\n"+ "<th>Customer</th>\r\n"  + "<th>Location X</th>\r\n"
				+ "    <th>Location Y</th>\r\n" + "    <th>Destination X</th>\r\n"
				+ "    <th>Destination Y</th>\r\n" + "    <th>Time</th>\r\n" + "    <th>Claim</th> \r\n"
				+ "  </tr>\r\n";
		StringBuilder sb = new StringBuilder();

		for (Ride r : rides) {
			System.out.println(r.claimed());
			if (!r.claimed()) {
				
				sb.append("<tr>");

				sb.append("<th>" + r.getRider().getName() + "</th>");
				sb.append("<th>" + r.getStart().getX() + "</th>");
				sb.append("<th>" + r.getStart().getY() + "</th>");
				sb.append("<th>" + r.getDest().getX() + "</th>");
				sb.append("<th>" + r.getDest().getY() + "</th>");
				sb.append("<th>" + r.getTime() + "</th>");
				sb.append("<th> <form method = \"post\"><button name=\"rideId\" type=\"submit\" value="+r.getId()+">Claim </button> <form>  </th></tr>");

			}
		}
		
		return out + sb + "</table>\r\n";
		
	}
	

}
