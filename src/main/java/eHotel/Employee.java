package eHotel;

import java.util.ArrayList;

public class Employee {
	private ArrayList<String> emp_role;
	private int emp_id;
	private String nom;
	private String address;
	private int ssn;
	private float salaire;
	
	public Employee() {
		
	}
	
	public void setEmployeeRole(ArrayList<String> emp_role) {
		this.emp_role = emp_role;
	}
	
	public String getEmployeeRole() {
		return emp_role.toString();
	}
	
	public void setEmployeeId(int emp_id) {
		this.emp_id = emp_id;
	}
	
	public int getEmployeeId() {
		return emp_id;
	}
	
	public void setEmployeeNom(String nom) {
		this.nom = nom;
	}
	
	public String getEmployeeNom() {
		return nom;
	}
	
	public void setEmployeeAddress(String address) {
		this.address = address;
	}
	
	public String getEmployeeAddress() {
		return address;
	}
	
	public void setEmployeeSsn(int ssn) {
		this.ssn = ssn;
	}
	
	public int getEmployeeSsn() {
		return ssn;
	}
	
	public void setEmployeeSalaire(float salaire) {
		this.salaire = salaire;
	}
	
	public float getEmployeeSalaire() {
		return salaire;
	}
}
