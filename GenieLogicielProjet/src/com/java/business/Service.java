package com.java.business;

import java.util.List;

import com.java.models.Utilisateur;


public interface Service {
	public Utilisateur selectUtilisateurs(int id);
	public Utilisateur selectUtilisateur(String Utilisateurname, String password); 
	public List<Utilisateur> selectUtilisateurs();
	public int insertUtilisateur(Utilisateur Utilisateur);
	public void deleteUtilisateur(Utilisateur Utilisateur);
	public void updateUtilisateur(Utilisateur Utilisateur);
}
