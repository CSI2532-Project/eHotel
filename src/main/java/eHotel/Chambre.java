package eHotel;

public class Chambre {
	
	private int id_chambre;
	private int hotel_id;
	private float prix;
	private String commodites;
	private int capacite;
	private String vue;
	private boolean etendue;
	private String dommages;
	private String status_chambre;
	private int location_id;
	private String debut_date;
	private String fin_date;
	
	public Chambre() {
		
	}
	
	public Chambre (int id_chambre,int hotel_id,float prix,String commodites, 
		int capacite,String vue,boolean etendue,String dommages,String status_chambre) {
		
		this.id_chambre = id_chambre;
		this.setHotelId(hotel_id);
		this.setPrix(prix);
		this.setCommodites(commodites);
		this.setCapacite(capacite);
		this.setChambreVue(vue);
		this.setEtendue(etendue);
		this.setChambreDommages(dommages);
		this.status_chambre = status_chambre;
	}
	
	public Chambre (int location_id,String debut_date,String fin_date,
		int hotel_id, int id_chambre, float prix) {
		
		this.setLocationId(location_id);
		this.setDebutDate(debut_date);
		this.setFinDate(fin_date);
		this.setHotelId(hotel_id);
		this.id_chambre = id_chambre;
		this.setPrix(prix);
	}
	
	public Chambre (int id_chambre, String status_chambre) {
		
		this.id_chambre = id_chambre;
		this.status_chambre = status_chambre;
	}
	
	public void setChambreId(int n_chambre_id) {
		this.id_chambre = n_chambre_id;
		
	}
	
	public void setStatusChambre(String n_status_chambre) {
		this.status_chambre = n_status_chambre;
	}
	
	public int getChambreId() {
		return id_chambre;
	}
	
	public String getStatusChambre() {
		return status_chambre;
	}

	public void setChambreDommages(String dommages) {
		this.dommages = dommages;
	}
	
	public String getChambreDommages() {
		return dommages;
	}

	public void setHotelId(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	
	public int getHotelId() {
		return hotel_id;
	}

	public void setDebutDate(String debut_date) {
		this.debut_date = debut_date;
	}
	
	public String getDebutDate() {
		return debut_date;
	}

	public void setFinDate(String fin_date) {
		this.fin_date = fin_date;
	}
	
	public String getFinDate() {
		return fin_date;
	}
	
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	public float getPrix() {
		return prix;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	public int getCapacite() {
		return capacite;
	}

	public boolean isEtendue() {
		return etendue;
	}

	public void setEtendue(boolean etendue) {
		this.etendue = etendue;
	}

	public void setChambreVue(String vue) {
		this.vue = vue;
	}
	
	public String setChambreVue() {
		return vue;
	}

	public void setLocationId(int location_id) {
		this.location_id = location_id;
	}
	
	public int getLocationId() {
		return location_id;
	}
	
	public void setCommodites(String commodites) {
		this.commodites = commodites;
	}
	
	public String getCommodites() {
		return commodites;
	}
}
