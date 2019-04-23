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
import local.Driver;
import local.LocalUser;

@WebServlet("/RideList")
public class RideListController extends HttpServlet {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RideListController() {}
	
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter output = response.getWriter();
		try {
		Statement smt= null;
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();
		conn = db.getConnection();
		smt=conn.createStatement();
		
		
		response.setContentType("text/html");
		
		String out="<style>\r\n" + 
				"table, th, td {\r\n" + 
				"  border: 1px solid black;\r\n" + 
				"}\r\n" + 
				"</style> "
				+ "<table style=\"width:100%\">\r\n" + 
		"  <tr>\r\n" + 
		"    <th>Rider</th>\r\n" + 
		"    <th>Location X</th>\r\n" + 
		"    <th>Location Y</th>\r\n" + 
		"    <th>Destination X</th>\r\n" + 
		"    <th>Destination Y</th>\r\n" + 
		"    <th>Distance</th>\r\n" + 
		"    <th>Driver</th> \r\n" + 
		"    <th>Cancel Ride</th> \r\n" + 
		"  </tr>\r\n" ;
		StringBuilder sb=new StringBuilder();
		String query="Select id, customerId, startX, startY, endX, endY, time, driverId from coursedatabase.ride";
	
		ResultSet rs;
		
		rs = smt.executeQuery(query);
	
		/*while(rs.next()) {
			if(rs.getString("userId").equals(LocalUser.getInstance().getUsername())) {
				sb.append("<tr><th>"+rs.getString("userId")+"</th>");
				sb.append("<th>"+rs.getInt("StartX")+"</th>");
				sb.append("<th>"+rs.getInt("StartY")+"</th>");
				sb.append("<th>"+rs.getInt("DestX")+"</th>");
				sb.append("<th>"+rs.getInt("DestY")+"</th>");
				sb.append("<th>"+rs.getString("Driver")+"</th></tr>");
			}
		}*/
			ArrayList<Ride> rds=new ArrayList<>();
			Ride rd;
			while(rs.next()) {
				if(rs.getString("customerId").equals(LocalUser.getInstance().getUsername())) {
					rd=new Ride();
					populate(rs,rd);
					rds.add(rd);
					//rd=null;
				}
			}
			
			//int i=0;
		for(Ride r:rds) {
			
			sb.append("<tr><td>"+r.getRider().getName()+"</td>");
			sb.append("<td>"+r.getStart().getX()+"</td>");
			sb.append("<td>"+r.getStart().getY()+"</td>");
			sb.append("<td>"+r.getDest().getX()+"</td>");
			sb.append("<td>"+r.getDest().getY()+"</td>");
			sb.append("<td>"+r.getDist()+"</td>");
			sb.append("<td>"+r.getCurDriver().getName()+"</td>");
			sb.append("<td><a href=\"DeleteRide?"+r.getId()+"\">Delete This Ride</a></td></tr>");
			//i++;
		}
		output.println(out+sb.toString()+ "</table>\r\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			output.println(e);
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static void populate(ResultSet rs,Ride r) {
		//Ride r=new Ride();
		try {
			r.setId(rs.getInt("id"));
			r.setDest(new Location(rs.getInt("endX"),rs.getInt("endY")));
			r.setStart(new Location(rs.getInt("startX"),rs.getInt("startY")));
			r.setPickup(new Time(rs.getString("time")));
			r.setCurDriver(new Driver(rs.getString("driverID")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}