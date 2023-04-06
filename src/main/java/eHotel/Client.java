package eHotel;

public class Client {
	private int id_client;
	private String nom;
	private String address;
	private int ssn;
	private String date_enregistrement;
	
	public Client() {
		
	}
	
	public Client(int id_client, String nom, String address,
		int ssn, String date_enregistrement) {
		
		this.id_client = id_client;
		this.nom = nom;
		this.address = address;
		this.ssn = ssn;
		this.date_enregistrement = date_enregistrement;
	}
	
	public void setClientId(int id_client) {
		this.id_client = id_client;
	}
	
	public int getClientId() {
		return id_client;
	}
	
	public void setClientNom(String nom) {
		this.nom = nom;
	}
	
	public String getClientNom() {
		return nom;
	}
	
	public void setClientAddress(String address) {
		this.address = address;
	}
	
	public String getClientAddress() {
		return address;
	}
	
	public void setClientSsn(int ssn) {
		this.ssn = ssn;
	}
	
	public int getClientSnn() {
		return ssn;
	}
	
	public void setDateEnregistrement(String date_enregistrement) {
		this.date_enregistrement = date_enregistrement;
	}
	
	public String getDateEnregistrement() {
		return date_enregistrement;
	}
}
