package com.java.business;

import java.util.List;

import com.java.dao.UtilisateurDao;
import com.java.models.Utilisateur;

public class ServiceDefault implements Service{

	private UtilisateurDao utilisateurDao;
	
	public ServiceDefault(UtilisateurDao utilisateurDao) {
		super();
		this.utilisateurDao = utilisateurDao;
	}

	@Override
	public Utilisateur selectUtilisateurs(int id) {
		return this.utilisateurDao.select(id);
	}

	@Override
	public Utilisateur selectUtilisateur(String username, String password) {
		return this.utilisateurDao.select(username, password);
	}

	@Override
	public List<Utilisateur> selectUtilisateurs() {
		return this.utilisateurDao.selectAll();
	}

	@Override
	public int insertUtilisateur(Utilisateur user) {
		return this.utilisateurDao.insert(user);
	}

	@Override
	public void deleteUtilisateur(Utilisateur user) {
		this.utilisateurDao.delete(user);
		
	}

	@Override
	public void updateUtilisateur(Utilisateur user) {
		this.utilisateurDao.update(user);
		
	}

}
