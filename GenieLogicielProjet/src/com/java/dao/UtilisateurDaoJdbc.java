package com.java.dao;

import java.util.ArrayList;
import java.util.List;

import com.java.dao.jdbc.Database;
import com.java.dao.utils.RowMapper;
import com.java.models.Utilisateur;

public class UtilisateurDaoJdbc implements UtilisateurDao {
private Database db;
	
	public UtilisateurDaoJdbc(Database db) {

		this.db = db;
	}
	
	public Utilisateur select(int id) {
		String data[][] = db.select("utilisateur", "idUtilisateur", id);
		Utilisateur u = null;
		
		for (int i = 1; i < data.length; i++) {
			u = RowMapper.getUtilisateur(data[i]);
		}
		return u;
	}

	public Utilisateur select(String Utilisateurname) {
		String data[][] = db.select("utilisateur", "username", Utilisateurname);
		Utilisateur u = null;
		
		for (int i = 1; i < data.length; i++) {
			u = RowMapper.getUtilisateur(data[i]);
		}
		return u;
	}

	
	public Utilisateur select(String Utilisateurname, String password) {

		String data[][] = db.selectLike("utilisateur", "username", Utilisateurname);
		Utilisateur u = null;
		
		for (int i = 1; i < data.length; i++) {
			u = RowMapper.getUtilisateur(data[i]);
			if(u.getPassword().equals(password)) {
				
				return u;
			}
		}
		return null;
	}
	
	
	public int insert(Utilisateur Utilisateur) {
		Utilisateur u = select(Utilisateur.getUsername());
		if(u == null) {
			return db.insert("utilisateur", new String[] {"username", "password", "nomComplet", "role"}, 
					Utilisateur.getUsername(), Utilisateur.getPassword(), Utilisateur.getNomComplet(), Utilisateur.getRole());
		}
		return 0;
	}

	
	public void delete(Utilisateur Utilisateur) {
		db.delete("utilisateur", "idUtilisateur", "" + Utilisateur.getId());
	}
 
	public void update(Utilisateur Utilisateur) {
		db.update("utilisateur", Utilisateur.getId(), Utilisateur.getUsername(), Utilisateur.getPassword(), Utilisateur.getNomComplet(), Utilisateur.getRole());
	}

	public List<Utilisateur> selectAll() {
		String data[][] = db.select("utilisateur");
		List<Utilisateur> Utilisateurs = new ArrayList<>();
		for (int i = 1; i < data.length; i++) {
			Utilisateurs.add(RowMapper.getUtilisateur(data[i]));
		}
		return Utilisateurs;
	}

}
