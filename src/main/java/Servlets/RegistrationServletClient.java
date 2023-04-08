package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import eHotel.*;

public class RegistrationServletClient extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String client_ssn = req.getParameter("ssn");
		String client_first = req.getParameter("firstname");
		String client_last = req.getParameter("lastname");
		String client_address = req.getParameter("address");
		String client_password = req.getParameter("password");
		String client_postal = req.getParameter("postalcode");
		String client_city = req.getParameter("city");
		String client_country = req.getParameter("country");
		String[] parametre = new String[] {client_ssn,client_first,client_last,client_password,client_address,client_city, client_country, client_postal};
		
		ConnectionSQL conn = new ConnectionSQL();
		boolean client_pwd = conn.addNewCustomer(parametre);
		
		System.out.println(client_pwd);
		
		if (client_pwd) {			
				System.out.println("success");
				
				ArrayList<Chambre> booked_rooms = conn.getBookedRooms(client_ssn);
				
				ArrayList<Chambre> available_rooms = conn.getAllAvailableRooms();
				
				System.out.println(available_rooms);
				
				req.setAttribute("client_nom", client_first);
				req.setAttribute("booked_rooms", booked_rooms);
				req.setAttribute("available_rooms", available_rooms);
				req.getRequestDispatcher("index.html").forward(req, resp);
				return;			
		}
		resp.sendRedirect("Registration_fail.jsp");
		return;
	}
	
}
