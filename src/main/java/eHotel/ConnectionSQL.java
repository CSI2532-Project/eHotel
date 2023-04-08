package eHotel;

import java.sql.*;
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
			String url = "jdbc:postgresql://localhost:5432/postgres";
			conn = DriverManager.getConnection(url,"postgres","357899");
		}catch(Exception e) {
			System.out.println("Unable to connect");
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
	
	public String[] getClientInfo(String ssn) {
		System.out.println(ssn);
		connecter();
		String [] client_ssn = new String [3];

		try {
			ps = conn.prepareStatement("select * from e_hotel.client where nas='" + ssn + "'");

			rs = ps.executeQuery();

			while (rs.next()) {
				client_ssn [0]= rs.getString(1);
				client_ssn [1]= rs.getString(2);
				client_ssn [2]= rs.getString(3);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnecter();
		}
		System.out.println(client_ssn[0] + " " + client_ssn[1] + " " + client_ssn[2]);
		return client_ssn;
	}
	
	public String getPassClientByNom(String nom) {
		connecter();

		String password = "";

		try {
			ps = conn.prepareStatement(
					"select password from e_hotel.client where nom=" + "'" + nom + "'");

			rs = ps.executeQuery();

			while (rs.next()) {
				password = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnecter();
		}
		return password;

	}
	
	public String getPassEmpByNom(String nom) {
		connecter();

		String password = "";

		try {
			ps = conn.prepareStatement(
					"select password from e_hotel.employe where nom=" + "'" + nom + "'");

			rs = ps.executeQuery();

			while (rs.next()) {
				password = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnecter();
		}
		return password;

	}
	
	public boolean addNewEmployee(String[] t1) {
		connecter();

		try {
			st = conn.createStatement();
			postsql = "insert into e_hotel.employe (nom,adresse,nas,password) values('" + t1[0] + "','" + t1[1] + "','" + t1[2]
					+ "','" + t1[3] + "')";
			st.executeUpdate(postsql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnecter();
		}

	}
	
	public boolean addNewClient(String[] client) {
		connecter();

		try {
			st = conn.createStatement();
			postsql = "insert into e_hotel.client (nom,adresse,nas,password) values('" + client[0] + "','" + client[1] + "','" + client[2] + "','" + client[3] + "')";
			System.out.print(postsql);

			st.executeUpdate(postsql);
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
			ps = conn.prepareStatement("select * from e_hotel.chambre where status_chambre='Available'");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id_chambre = rs.getInt("id_chambre");
				String status_chambre = rs.getString("status_chambre");
				Chambre chambre = new Chambre(id_chambre, status_chambre);
				chambres.add(chambre);
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

		ArrayList<Chambre> chambres = new ArrayList<Chambre>();

		try {
			ps = conn.prepareStatement("select * from e_hotel.chambre where status_chambre='Booked'");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id_chambre = rs.getInt("id_chambre");
				String status_chambre = rs.getString("status_chambre");
				Chambre chambre = new Chambre(id_chambre, status_chambre);
				chambres.add(chambre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnecter();
		}

		return chambres;
	}
	
	public ArrayList<Chambre> getBookedRooms(String client_ssn) {

		connecter();

		ArrayList<Chambre> chambres = new ArrayList<Chambre>();

		try {
			st = conn.createStatement();
			st.execute(
					"create view e_hotel.client_chambre as select location.client_ssn, location.id_location, location.checking_date, location.checkout_date, hotel.id_hot, chambre.id_chambre, chambre.prix from e_hotel.location, e_hotel.hotel, e_hotel.chambre where location.id_chambre = chambre.id_chambre and chambre.hotel_id = hotel.id_hot and client_ssn='"
							+ client_ssn + "'");
			ps = conn.prepareStatement("select * from e_hotel.client_chambre");
			rs = ps.executeQuery();

			while (rs.next()) {
				int id_location = rs.getInt("id_location");
				String debut_date = rs.getString("debut_date");
				String fin_date = rs.getString("fin_date");
				int id_hot = rs.getInt("id_hot");
				int id_chambre = rs.getInt("id_chambre");
				float prix = rs.getFloat("prix");

				System.out.println(id_hot + id_chambre);

				Chambre chambre= new Chambre(id_location, debut_date, fin_date, id_hot, id_chambre, prix);
				chambres.add(chambre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st = conn.createStatement();
				st.execute("drop view e_hotel.client_chambre");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			disconnecter();
		}
		return chambres;
	}
	
	public ArrayList<Chambre> getAllAvailableRooms() {

		connecter();

		ArrayList<Chambre> chambres = new ArrayList<Chambre>();

		try {
			ps = conn.prepareStatement(
					"select * chaine_hoteliere.id_chaine, hotel.id_hot, chambre.prix, hotel.classification, hotel.nb_chambres, chambre.capacite, hotel.adresse from e_hotel.chambre, e_hotel.hotel, e_hotel.chaine_hoteliere where chaine_hoteliere.id_chaine = hotel.chaine_hoteliere_id AND chambre.hotel_id = hotel.id_hot AND (NOT EXISTS (SELECT * FROM e_hotel.location WHERE location.id_chambre = chambre.id_chambre AND (location.checking_date = CURRENT_DATE OR location.checkout_date = CURRENT_DATE))) ");
			rs = ps.executeQuery();
			while (rs.next()) {
				float prix_chambre = rs.getFloat("prix_chambre");
				int id_chaine = rs.getInt("id_chaine");
				int id_hot = rs.getInt("id_hot");
				int capacite = rs.getInt("capacite");
				String adresse = rs.getString("adresse");

				Chambre chambre = new Chambre();
				chambre.setCapacite(capacite);
				chambre.setPrix(prix_chambre);
				chambre.setAdresse(adresse);
				chambre.setHotelId(id_hot);
				chambre.setHotChaineId(id_chaine);
				
				chambres.add(chambre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnecter();
		}

		return chambres;

	}
	
	public String bookChambre(String nom_client, int id_chambre) {
		connecter();

		try {

			st = conn.createStatement();
			postsql = "update e_hotel.chambre set nom_client='" + nom_client + "', status_chambre='Booked' where id_chambre='"
					+ id_chambre + "'";
			st.executeUpdate(postsql);

			return nom_client;

		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		} finally {
			disconnecter();
		}

	}
	
}
