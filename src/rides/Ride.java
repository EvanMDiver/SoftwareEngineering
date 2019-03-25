package rides;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DbManager;
import local.LocalUser;

public class Ride {
	private LocalUser rider = LocalUser.getInstance();
	private Location dest;
	private Location start;
	private Time pickup;
	
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	/**
	 * CREATE TABLE `ride` (
`userId` char(20) NOT NULL,
`StartX` int DEFAULT NULL,
`StartY` int DEFAULT NULL,
`DestX` int DEFAULT NULL,
`DestY` int DEFAULT NULL,
`Driver` char(20) DEFAULT NULL
);
	 * */
	public void addRide() {
		int status = 0;
		conn = db.getConnection();
		try {
			ps =conn.prepareStatement("insert into ride values(?,?,?,?,?,?)");
			ps.setString(1, rider.getUsername());
			ps.setInt(2, start.getX());
			ps.setInt(3, start.getY());
			ps.setInt(4, dest.getX());
			ps.setInt(5, dest.getY());
			ps.setString(6, "Temp");
			status = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public LocalUser getRider() {
		return rider;
	}
	public void setRider(LocalUser rider) {
		this.rider = rider;
	}
	public Location getDest() {
		return dest;
	}
	public void setDest(Location dest) {
		this.dest = dest;
	}
	public Location getStart() {
		return start;
	}
	public void setStart(Location start) {
		this.start = start;
	}
	public Time getPickup() {
		return pickup;
	}
	public void setPickup(Time pickup) {
		this.pickup = pickup;
	}
	
}
