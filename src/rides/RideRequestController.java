package rides;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.LocalUser;

@WebServlet("/RequestRide")
public class RideRequestController extends HttpServlet {
	
	public RideRequestController() {}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Ride r= new Ride();
		Location l = new Location();
		Location l2 = new Location();
		Time t =new Time();
		int x=Integer.parseInt(request.getParameter("DestinationX").trim());
		int y=Integer.parseInt(request.getParameter("DestinationY").trim());
		String tm=request.getParameter("Time");
		l.setY(y);
		l.setX(x);
		r.setDest(l);
		
		x=Integer.parseInt(request.getParameter("Pick-UpX").trim());
		y=Integer.parseInt(request.getParameter("Pick-UpY").trim());
		
		l2.setY(y);
		l2.setX(x);
		r.setStart(l2);
		
		t.setTime(tm);
		r.setPickup(t);
		
		r.addRide();
		
		LocalUser c=LocalUser.getInstance();
		request.setAttribute("message", "Ride Created "+c.getName());
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
		
	}
}