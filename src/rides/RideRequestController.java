package rides;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestRide")
public class RideRequestController extends HttpServlet {
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Ride r= new Ride();
		Location l = new Location();
		Location l2 = new Location();
		Time t =new Time();
		l.setY((int)request.getAttribute("DestinationY"));
		l.setX((int)request.getAttribute("DestinationX"));
		r.setDest(l);
		
		l2.setY((int)request.getAttribute("Pick-UpX"));
		l2.setX((int)request.getAttribute("Pick-UpY"));
		r.setStart(l2);
		
		t.setTime((int)request.getAttribute("Time"));
		r.setPickup(t);
		
	}
}
