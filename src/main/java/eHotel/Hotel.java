package eHotel;

import java.util.ArrayList;

public class Hotel {
	
	private int id_hot;
	private int chain_hoteliere_id;
	private int classification_id;
	private int nb_chambres;
	private String address;
	private int telephone;
	private String email;
	private ArrayList<Chambre> chambres;
	
	public Hotel() {
		
	}
	
	public Hotel (int classification_id, int id_hot,int chain_hoteliere_id,
		int nb_chambres,String address,int telephone,String email, ArrayList<Chambre> chambres) {
		
		this.setClassificationId(classification_id);
		this.setHotelId(id_hot);
		this.setChaineId(chain_hoteliere_id);
		this.setNbChambres(nb_chambres);
		this.setHotelAddress(address);
		this.setTelephone(telephone);
		this.setEmail(email);
		this.setChambres(chambres);
		
	}
	
	public void setHotelId (int id_hot) {
		this.id_hot = id_hot;
	}
	
	public int getHotelId() {
		return id_hot;
	}
	
	public void setChaineId (int chain_hoteliere_id) {
		this.chain_hoteliere_id = chain_hoteliere_id;
	}
	
	public int getChaineId() {
		return chain_hoteliere_id;
	}
	
	public void setClassificationId (int classification_id) {
		this.classification_id = classification_id;
	}
	
	public int getClassificationId() {
		return classification_id;
	}
	
	public void setNbChambres (int nb_chambres) {
		this.nb_chambres = nb_chambres;
	}
	
	public int getNbChambres() {
		return nb_chambres;
	}
	
	public void setHotelAddress (String address) {
		this.address = address;
	}
	
	public String getHotelAddress() {
		return address;
	}
	
	public void setTelephone (int telephone) {
		this.telephone = telephone;
	}
	
	public int getTelephone() {
		return telephone;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setChambres(ArrayList<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	public ArrayList<Chambre> getChambres() {
		return chambres;
	}
}
