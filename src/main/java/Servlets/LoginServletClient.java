package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import eHotel.*;

@WebServlet("/loginServletClient")
public class LoginServletClient extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String client_i = req.getParameter("username");
		String pwd = req.getParameter("password");

		ConnectionSQL conn = new ConnectionSQL();
		String client_info = conn.getPassClientByNom(client_i);
		if (pwd.equals(client_info)) {

			/* ArrayList<Chambre> booked_rooms = conn.getBookedRooms(client_i);

			ArrayList<Chambre> available_rooms = conn.getAllAvailableRooms();

			req.setAttribute("client_nom", client_info);
			req.setAttribute("booked_rooms", booked_rooms);
			req.setAttribute("available_rooms", available_rooms);*/

			req.getRequestDispatcher("index.html").forward(req, resp);
			return;
		}
		resp.sendRedirect("Login_fail.jsp");
		return;
	}
	
}
