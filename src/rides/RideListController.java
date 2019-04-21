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

@WebServlet("/RideList")
public class RideListController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RideListController() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter output = response.getWriter();
		try {
			ArrayList<Ride> rides = DbManager.getRides();

			response.setContentType("text/html");

			String out = "<style>\r\n" + "table, th, td {\r\n" + "  border: 1px solid black;\r\n" + "}\r\n"
					+ "</style> " + "<table style=\"width:100%\">\r\n" + "  <tr>\r\n" + "<th>Location X</th>\r\n"
					+ "    <th>Location Y</th>\r\n" + "    <th>Destination X</th>\r\n"
					+ "    <th>Destination Y</th>\r\n" + "    <th>Time</th>\r\n" + "    <th>Driver</th> \r\n" + "  </tr>\r\n";
			StringBuilder sb = new StringBuilder();

			for (Ride r : rides) {
				if (r.getRider().equals(LocalUser.getUser())) {
					sb.append("<tr>");
					sb.append("<th>" + r.getStart().getX() + "</th>");
					sb.append("<th>" + r.getStart().getY() + "</th>");
					sb.append("<th>" + r.getDest().getX() + "</th>");
					sb.append("<th>" + r.getDest().getY() + "</th>");
					sb.append("<th>" + r.getTime() + "</th>");
					if (r.getDriver() == null) {
						sb.append("<th> Unclaimed </th></tr>");
					} else {

						sb.append("<th>" + r.getDriver().getName() + "</th></tr>");
					}
				}
			}

			output.println(out + sb.toString() + "</table>\r\n");
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			output.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}