package rides;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RideList")
public class RideListController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RideListController() {}
	
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		output.println("<style>\r\n" + 
				"table, th, td {\r\n" + 
				"  border: 1px solid black;\r\n" + 
				"}\r\n" + 
				"</style> "
				+ "<table style=\"width:100%\">\r\n" + 
		"  <tr>\r\n" + 
		"    <th>Rider</th>\r\n" + 
		"    <th>Drivver</th> \r\n" + 
		"    <th>Location X</th>\r\n" + 
		"    <th>Location Y</th>\r\n" + 
		"    <th>Destination X</th>\r\n" + 
		"    <th>Destination Y</th>\r\n" + 
		"  </tr>\r\n" + 
		"  <tr>\r\n" + 
		"    <td>Jill</td>\r\n" + 
		"    <td>Smith</td>\r\n" + 
		"    <td>50</td>\r\n" + 
		"  </tr>\r\n" + 
		"  <tr>\r\n" + 
		"    <td>Eve</td>\r\n" + 
		"    <td>Jackson</td>\r\n" + 
		"    <td>94</td>\r\n" + 
		"  </tr>\r\n" + 
		"  <tr>\r\n" + 
		"    <td>John</td>\r\n" + 
		"    <td>Doe</td>\r\n" + 
		"    <td>80</td>\r\n" + 
		"  </tr>\r\n" + 
		"</table>\r\n");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
