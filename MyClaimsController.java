package rides;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;
import local.LocalUser;

@WebServlet("/MyClaims")
public class MyClaimsController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyClaimsController() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			getServletContext().getRequestDispatcher("/myrides.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public String getTable() {
		ArrayList<Ride> rides;
		try {
			rides = DbManager.getRides();
		


		String out = "<style>\r\n" + "table, th, td {\r\n" + "  border: 1px solid black;\r\n" + "}\r\n"
				+ "</style> " + "<table style=\"width:100%\">\r\n" + "  <tr>\r\n" + "<th>Location X</th>\r\n"
				+ "    <th>Location Y</th>\r\n" + "    <th>Destination X</th>\r\n"
				+ "    <th>Destination Y</th>\r\n" + "    <th>Time</th>\r\n" + "    <th>Rider</th> \r\n" + "  <th></th></tr>\r\n";
		StringBuilder sb = new StringBuilder();

		for (Ride r : rides) {
			if (r.getDriver().equals(LocalUser.getUser())) {
				sb.append("<tr>");
				sb.append("<th>" + r.getStart().getX() + "</th>");
				sb.append("<th>" + r.getStart().getY() + "</th>");
				sb.append("<th>" + r.getDest().getX() + "</th>");
				sb.append("<th>" + r.getDest().getY() + "</th>");
				sb.append("<th>" + r.getTime() + "</th>");
				if (r.getRider() == null) {
					sb.append("<th> Unclaimed </th></tr>");
				} else {

					sb.append("<th>" + r.getRider().getName() + "</th>");
				}
				sb.append("<th><a href=\"DeleteRide?"+r.getId()+"\">Unclaim this Ride</a></th></tr>");
			}
		}

		return (out + sb.toString() + "</table>\r\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}