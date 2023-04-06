package eHotel;

import java.sql.*;

import eHotel.Hotel;
import eHotel.Chambre;
import java.util.*;

public class ConnectionSQL {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement st = null;
	String postsql = null;
	
	public ConnectionSQL() {
		
	}
	
	public void connecter () {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("url","username","password");
		}catch(Exception e) {
			System.out.println("unable to connect");
		}
	}
	
	public void disconnecter() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
		}
	}
	
	public String[] getClientSSN(String ssn) {
		System.out.println(ssn);
		connecter();
		String[] client_ssn = new String[3];

		try {
			ps = conn.prepareStatement("select * from e_hotel.client where nas='" + Integer.parseInt(ssn) + "'");

			rs = ps.executeQuery();

			while (rs.next()) {
				client_ssn[0] = rs.getString(1);
				client_ssn[1] = rs.getString(2);
				client_ssn[2] = rs.getString(4);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnecter();
		}
		System.out.println(client_ssn[0] + " " + client_ssn[1]);
		return client_ssn;
	}
	
	public boolean addNewEmployee(String[] t1, String[] t2, String[] t3) {
		connecter();

		try {
			st = conn.createStatement();
			postsql = "insert into e_hotel.employe values('" + t1[0] + "','" + t1[1] + "','" + t1[2]
					+ "','" + t1[3] + "'," + "'" + t1[4] + "')";
			String inEmployee = "insert into e_hotel.employee values('" + t2[0] + "','" + t2[1] + "')";
			String inAddresse = "insert into e_hotel.employee_addresses values('" + t3[0] + "','" + t3[1]
					+ "','" + t3[2] + "','" + t3[3] + "'," + "'" + t3[4] + "'," + "'" + t3[5] + "')";
			System.out.print(postsql + " " + inAddresse + " " + inEmployee);

			st.execute(inEmployee);
			st.executeUpdate(inAddresse);
			st.executeUpdate(postsql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnecter();
		}

	}
	
	public boolean addNewCustomer(String[] cust) {
		connecter();

		try {
			st = conn.createStatement();
			postsql = "insert into e_hotel.customer values('" + cust[0] + "','" + cust[1] + "','" + cust[2] + "','"
					+ cust[3] + "')";
			String inAddress = "insert into e_hotel.customer_addresses values('" + cust[4] + "','" + cust[5] + "','"
					+ cust[6] + "','" + cust[7] + "','" + cust[8] + "')";
			System.out.print(postsql + " " + inAddress);

			st.executeUpdate(postsql);
			st.executeUpdate(inAddress);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnecter();
		}
	}
	
	public ArrayList<Chambre> getAllRooms() {

		connecter();

		ArrayList<Chambre> chambres = new ArrayList<Chambre>();

		try {
			ps = conn.prepareStatement("select * from e_hotel.room where room_status='available'");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id_chambre = rs.getInt("id_chambre");
				String status_chambre = rs.getString("status_chambre");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnecter();
		}

		return chambres;

	}
	
	public ArrayList<Chambre> getAllBookedRooms() {

		connecter();

		ArrayList<Chambre> Rooms = new ArrayList<Chambre>();

		try {
			ps = conn.prepareStatement("select * from e_hotel.room where room_status='booked'");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id_chambre = rs.getString("room_no");
				String status_chambre = rs.getString("status_chambre");
				Chambre chambre = new Chambre(id_chambre, status_chambre);
				Rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return Rooms;
	}
	
}
