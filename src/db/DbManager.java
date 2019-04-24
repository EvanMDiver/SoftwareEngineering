package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.login.Customer;
import domain.login.Driver;
import rides.Location;
import rides.Ride;

/**
 * 
 * @author mehra getConnection method help us to connect to the appropriate
 *         database. In this project we only have one database. Data comes from
 *         MyDB interface.
 */
public class DbManager implements MyDB {


	private DbManager() {
	};

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConnection = DriverManager.getConnection(CONN_URL, USER, PASS);
			return myConnection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<Ride> getRides() throws SQLException {
		ArrayList<Ride> list = new ArrayList<Ride>();
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		ResultSet rs = state.executeQuery(
				"Select id, customerId, startX, startY, endX, endY, time, driverId from coursedatabase.ride");

		while (rs.next()) {
			int id = rs.getInt("id");
			String customerId = rs.getString("customerId");
			int startX = rs.getInt("startX");
			int startY = rs.getInt("startY");
			int endX = rs.getInt("endX");
			int endY = rs.getInt("endY");
			String time = rs.getString("time");
			String driverId = rs.getString("driverId");
			Location start = new Location(startX, startY);
			Location dest = new Location(endX, endY);
			
			Customer rider = getCustomer(customerId);
			Driver driver = getDriver(driverId);

			Ride ride = new Ride(id, rider, start, dest, time, driver);
			list.add(ride);
		}
		System.out.printf("Loaded %d rides\n", list.size());
		return list;
	}

	public static Customer getCustomer(String username) {
		try {
			Connection conn = getConnection();
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("select * from coursedatabase.customer where userId = '" + username+ "';");
			
			if(rs.first()){
				return new Customer(rs.getString("userId"), rs.getString("password"), rs.getString("name"));
			}
			else return null;
		} catch (SQLException e) { 
			e.printStackTrace();
			return null;
		}
	}
	
	public static Driver getDriver(String username) {
		try {
			Connection conn = getConnection();
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("select * from coursedatabase.driver where userId = '" + username+ "';");
			
			if(rs.next()){
				return new Driver(rs.getString("userId"), rs.getString("password"), rs.getString("name"));
			}
			else return null;
		} catch (SQLException e) { 
			e.printStackTrace();
			return null;
		}
	}
	

	public static boolean add(Ride r) {
		try {
			Connection conn = getConnection();
			Statement state = conn.createStatement();

			state.execute("insert into coursedatabase.ride (customerId, startX, startY, endX, endY, time) values"
					+ " ('" + r.getRider().getUsername() + "'," + r.getStart().getX() + "," + r.getStart().getY() + ","
					+ r.getDest().getX() + "," + r.getDest().getY() + ",'" + r.getTime() + "');");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public static void saveRide(Ride r) {
		try {
			Connection conn = getConnection();
			Statement state = conn.createStatement();
			
			state.executeUpdate("update coursedatabase.ride set driverId = \""+ r.getDriver().getUsername() + "\" where id =" + r.getId());
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static Ride getRide(int rideId) {
		try {
			Connection conn = getConnection();
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("select * from coursedatabase.ride where id = '" + rideId+ "';");
			
			if(rs.next()){
				int id = rs.getInt("id");
				String customerId = rs.getString("customerId");
				int startX = rs.getInt("startX");
				int startY = rs.getInt("startY");
				int endX = rs.getInt("endX");
				int endY = rs.getInt("endY");
				String time = rs.getString("time");
				String driverId = rs.getString("driverId");
				Location start = new Location(startX, startY);
				Location dest = new Location(endX, endY);
				
				Customer rider = getCustomer(customerId);
				Driver driver = getDriver(driverId);

				Ride ride = new Ride(id, rider, start, dest, time, driver);
				return ride;
			}
			else return null;
		} catch (SQLException e) { 
			e.printStackTrace();
			return null;
		}
	}

	public static void delete(Ride ride) {
		Connection conn = getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement("DELETE from ride where id = ?");
			ps.setInt(1, ride.getId());
			ps.executeUpdate();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}

}
