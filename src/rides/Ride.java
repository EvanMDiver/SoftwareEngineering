package rides;

import local.LocalUser;

public class Ride {
	private LocalUser rider = LocalUser.getInstance();
	private Location dest;
	private Location start;
	private Time pickup;
	
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
