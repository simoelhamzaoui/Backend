package com.java.dao;

import java.util.List;

import com.java.models.Utilisateur;

public interface UtilisateurDao {
	public Utilisateur select(String username);
	public Utilisateur select(int id);
	public Utilisateur select(String username, String password); 
	public List<Utilisateur> selectAll();
	public int insert(Utilisateur user);
	public void delete(Utilisateur user);
	public void update(Utilisateur user);
}
