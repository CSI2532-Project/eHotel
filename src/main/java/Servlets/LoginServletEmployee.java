package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import eHotel.*;

public class LoginServletEmployee extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String nom = req.getParameter("name");
		String pwd = req.getParameter("password");
		
		
		ConnectionSQL con = new ConnectionSQL();
		String emp_password = con.getPassEmpByNom(nom);
		
		
		if (pwd.equals(emp_password)) {			
				System.out.println("success");
				req.setAttribute("employee_id", nom);
				resp.sendRedirect("Login_success.jsp?id_employe="+nom);
				return;			
		}
		resp.sendRedirect("Login_fail.jsp");
		return;
	}
}
