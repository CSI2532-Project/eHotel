package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import eHotel.*;

@WebServlet("/loginServletEmployee")
public class LoginServletEmployee extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String nom = req.getParameter("username");
		String pwd = req.getParameter("password");
		
		
		ConnectionSQL con = new ConnectionSQL();
		String emp_password = con.getPassEmpByNom(nom);
		
		
		if (pwd.equals(emp_password)) {			
				System.out.println("success");
				// req.setAttribute("employee_id", nom);
				resp.sendRedirect("Login_success.jsp");
				return;			
		}
		resp.sendRedirect("Login_fail.jsp");
		return;
	}
}
