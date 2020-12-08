package com.java.models;


public class Utilisateur {
	public final static String ADMINISTRATEUR = "ADMINISTRATEUR";
	public final static String JOUEUR = "JOUEUR";
		
	private int id;
	private String username;
	private String password;
	private String nomComplet;
	private String role;
	
	public Utilisateur(int id, String username, String password, String nomComplet, String role) {
  		this.id = id;
		this.username = username;
		this.password = password;
		this.nomComplet = nomComplet;
		this.role = role;
	}
	public Utilisateur(String username, String password, String nomComplet, String role) {
 		this.username = username;
		this.password = password;
		this.nomComplet = nomComplet;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	} 
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", nomComplet=" + nomComplet
				+ ", role=" + role + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
