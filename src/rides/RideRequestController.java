package rides;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;
import domain.login.Customer;
import local.LocalUser;

@WebServlet("/RequestRide")
public class RideRequestController extends HttpServlet {

	public RideRequestController() {
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int x = Integer.parseInt(request.getParameter("DestinationX").trim());
		int y = Integer.parseInt(request.getParameter("DestinationY").trim());

		Location start = new Location(x, y);

		x = Integer.parseInt(request.getParameter("Pick-UpX").trim());
		y = Integer.parseInt(request.getParameter("Pick-UpY").trim());

		Location dest = new Location(x, y);

		Ride r = new Ride((Customer) LocalUser.getUser(), start, dest, request.getParameter("Time"));

		if (DbManager.add(r)) {
			request.setAttribute("message", "Ride Created.");
		} else {
			request.setAttribute("message", "Could not create ride.");
		}

		request.getRequestDispatcher("welcome.jsp").forward(request, response);

	}
}