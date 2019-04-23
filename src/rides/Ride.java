package rides;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DbManager;
import local.Driver;
import local.LocalUser;

public class Ride {
	private int ID;
	private LocalUser rider = LocalUser.getInstance();
	private Location dest;
	private Location start;
	private Time pickup;
	private Driver curDriver;
	
	static Connection conn;
	static PreparedStatement ps;
	static DbManager db = new DbManager();
	/**
	 * CREATE TABLE `ride` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customerId` CHAR(20) NOT NULL,
  `startX` INT NOT NULL,
  `startY` INT NOT NULL,
  `endX` INT NOT NULL,
  `endY` INT NOT NULL,
  `time` VARCHAR(60) NOT NULL,
  `driverId` CHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
  );
	 * */
	public void addRide() {
		int status = 0;
		conn = db.getConnection();
		try {
			ps =conn.prepareStatement("insert into ride(customerId,startX,startY,endX,endY,time) values(?,?,?,?,?,?)");
			
			ps.setString(1, rider.getUsername());
			ps.setInt(2, start.getX());
			ps.setInt(3, start.getY());
			ps.setInt(4, dest.getX());
			ps.setInt(5, dest.getY());
			ps.setString(6, pickup.getTime());
			status = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public int getId() {
		return ID;
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
	public void setPickup(Time t) {
		pickup=t;
		
	}
	
	
	public Driver getCurDriver() {
		return curDriver;
	}

	public void setId(int id) {
		ID=id;
	}
	public void setCurDriver(Driver curDriver) {
		this.curDriver = curDriver;
	}
	
	public int getDist() {
		return (int) Math.sqrt(Math.pow(getStart().getX()-getDest().getX(),2)+Math.pow(getStart().getY()-getDest().getY(),2));
	}
	
	public static void deleteRide(int rideID) {
		
		conn = db.getConnection();
		
		try {
			ps =conn.prepareStatement("DELETE from ride where id = ?");
			ps.setInt(1, rideID);
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}