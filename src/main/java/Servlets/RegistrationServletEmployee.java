package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import eHotel.*;

public class RegistrationServletEmployee extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String emp_ssn = req.getParameter("ssn");
		String emp_nom = req.getParameter("firstname");
		String emp_last = req.getParameter("lastname");
		String emp_address = req.getParameter("address");
		String emp_password = req.getParameter("password");
		String emp_postal = req.getParameter("postalcode");
		String emp_city = req.getParameter("city");
		String emp_country = req.getParameter("country");
		String emp_dob = req.getParameter("dob");
		String emp_province = req.getParameter("province");
		String[] t1 = new String[] {emp_nom, emp_ssn, emp_last,emp_dob};
		String[] t2 = new String[] {emp_nom, emp_password};
		String[] t3 = new String[] {emp_nom, emp_address, emp_city, emp_province, emp_country, emp_postal};
		ConnectionSQL conn = new ConnectionSQL();
		boolean emp_pwd = conn.addNewEmployee(t1, t2, t3);
		
		System.out.println(emp_pwd);
		
		if (emp_pwd) {			
				System.out.println("success");
				
				ArrayList<Chambre> booked_rooms = conn.getBookedRooms(emp_ssn);
				
				ArrayList<Chambre> available_rooms = conn.getAllAvailableRooms();
				
				System.out.println(available_rooms);
				
				req.setAttribute("emp_nom", emp_nom);
				req.setAttribute("bookedRooms", booked_rooms);
				req.setAttribute("allRooms", available_rooms);
				
				req.getRequestDispatcher("index.html").forward(req, resp);
				return;			
		}
		resp.sendRedirect("Registration_fail.jsp");
		return;
	}
	
}
