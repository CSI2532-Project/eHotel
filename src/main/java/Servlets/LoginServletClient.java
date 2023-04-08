package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import eHotel.*;

public class LoginServletClient extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String pwd = req.getParameter("password");
		String client_i = req.getParameter("username");

		ConnectionSQL con = new ConnectionSQL();
//		[0]:name,[1]:pwd
		String[] client_info = con.getClientInfo(client_i);
		if (pwd.equals(client_info[1])) {

			ArrayList<Chambre> booked_rooms = con.getBookedRooms(client_i);

			ArrayList<Chambre> available_rooms = con.getAllAvailableRooms();

			req.setAttribute("client_nom", client_info[2]);
			req.setAttribute("booked_rooms", booked_rooms);
			req.setAttribute("available_rooms", available_rooms);

			req.getRequestDispatcher("index.html").forward(req, resp);
			return;
		}
		resp.sendRedirect("Login_fail.jsp");
		return;
	}
	
}
