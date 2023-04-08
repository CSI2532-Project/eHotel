package Servlets;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import eHotel.*;

@WebServlet("/registrationServletClient")
public class RegistrationServletClient extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String client_first_last = req.getParameter("firstlastname");
		String client_address = req.getParameter("address");
		String client_ssn = req.getParameter("ssn");
		String client_password = req.getParameter("password");
		String[] parametre = new String[] {client_first_last,client_address,client_ssn,client_password};
		
		ConnectionSQL conn = new ConnectionSQL();
		boolean client_pwd = conn.addNewClient(parametre);
		
		System.out.println(client_pwd);
		
		if (client_pwd) {			
				System.out.println("success");
				
	/*			ArrayList<Chambre> booked_rooms = conn.getBookedRooms(client_ssn);
				
				ArrayList<Chambre> available_rooms = conn.getAllAvailableRooms();
				
				System.out.println(available_rooms);
				
				req.setAttribute("client_nom", client_first_last);
				req.setAttribute("booked_rooms", booked_rooms);
				req.setAttribute("available_rooms", available_rooms);*/
				
				req.getRequestDispatcher("index.html").forward(req, resp);
				return;			
		}
		resp.sendRedirect("Registration_fail.jsp");
		return;
	}
	
}
