package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import eHotel.*;

public class ServletBookingRoom extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String client_nom = req.getParameter("client_nom");
		String id_chambre = req.getParameter("id_chambre");
		
		
		ConnectionSQL conn = new ConnectionSQL();
		
		String client_info = conn.bookChambre(client_nom,Integer.parseInt(id_chambre));
		
		//[0]:SSN,[1]:pwd, [2]:name
		String[] pwd = conn.getClientInfo(client_info);
	
		if (client_info.length()==8) {			
			
			ArrayList<Chambre> booked_rooms = conn.getBookedRooms(client_info);
			
			ArrayList<Chambre> available_rooms = conn.getAllAvailableRooms();
			
			
			req.setAttribute("client_nom", client_nom);
			req.setAttribute("booked_rooms", booked_rooms);
			req.setAttribute("available_rooms", available_rooms);

			req.getRequestDispatcher("index.jsp").forward(req, resp);
			return;	
		}
		resp.sendRedirect("Login_fail.jsp");
		return;
	}
	
}
