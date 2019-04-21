package rides;


import domain.login.*;
import local.LocalUser;

public class Ride {
	
	public Ride(Integer id, Customer rider,  Location start, Location dest, String time, Driver driver) {
		this.id = id;
		this.rider = rider;
		this.driver = driver;
		this.dest = dest;
		this.start = start;
		this.time = time;
	}
	
	public Ride(Customer rider,  Location start, Location dest, String time) {
		this.id = null;
		this.rider = rider;
		this.driver = null;
		this.dest = dest;
		this.start = start;
		this.time = time;
	}
	
	private Integer id;
	private Customer rider;
	private Driver driver;
	private Location dest;
	private Location start;
	private String time;
	
	
	public Customer getRider() {
		return rider;
	}
	public void setRider(Customer rider) {
		this.rider = rider;
	}
	
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}