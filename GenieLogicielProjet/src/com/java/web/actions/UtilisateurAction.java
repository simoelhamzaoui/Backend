package com.java.web.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.java.business.Service;
import com.java.models.Utilisateur;
import com.java.web.utils.NavigationRouteUtil;

public class UtilisateurAction {
	
	private Service service;

	public UtilisateurAction(Service service) { 
		this.service = service;
	}

	
public String login(HttpServletRequest request) {
		
		if(request.getSession().getAttribute("user") != null) {
			request.setAttribute("message", "Une sessions est déja ouverte sur ce navigateur !");
			request.setAttribute("flag", true);
			return "../Index.jsp";
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Utilisateur user = service.selectUtilisateur(username, password);
		if(!"".equals(username) && !"".equals(password)) {

			if(user != null) {
				request.getSession().setAttribute("user", user);
				//SessionUtil.setUserSession(user, request); 
				System.out.println(user);
				
				if(user.getRole().equals(Utilisateur.ADMINISTRATEUR)) {
					return NavigationRouteUtil.navigate(request, "Home", "tableauDeBord");
				}
				else if(user.getRole().equals(Utilisateur.JOUEUR)) {
					return NavigationRouteUtil.navigate(request, "Home", "tableauDeBord");
				}
				return "/views/Home.jsp";
			}
			request.setAttribute("message", "Nom d'utilisateur ou/et mot de passe incorrectes");
		}
		else request.setAttribute("message", "Obligation de remplir les champs !");
		request.setAttribute("flag", true);
		return "../Index.jsp";
	}

	public String logout(HttpServletRequest request) {

		request.setAttribute("logout", true);
		request.setAttribute("user", null);
		request.getSession().setAttribute("user", null);
		return "../index.jsp";
	}
	
	public String listUsers(HttpServletRequest request) {
		List<Utilisateur> utilisateurs = service.selectUtilisateurs();
		request.setAttribute("utilisateurs", utilisateurs);
		return NavigationRouteUtil.navigate(request, "Home", "UserForm");
	}
	
	public String addUser(HttpServletRequest request) {
		String username = request.getParameter("username");
		String nomComplet = request.getParameter("fullname");
		String password = request.getParameter("password");
		String role = "JOUEUR";
		Utilisateur user = new Utilisateur(username, password, nomComplet, role);
		service.insertUtilisateur(user);
		
		List<Utilisateur> users = service.selectUtilisateurs();
		request.setAttribute("users", users);
		request.setAttribute("added", true);
		return NavigationRouteUtil.navigate(request, "Home", "UserForm");
	}
	
	public String addAdmin(HttpServletRequest request) {
		String username = request.getParameter("username");
		String nomComplet = request.getParameter("fullname");
		String password = request.getParameter("password");
		String role = "ADMINISTRATEUR";
		Utilisateur user = new Utilisateur(username, password, nomComplet, role);
		service.insertUtilisateur(user);
		
		List<Utilisateur> users = service.selectUtilisateurs();
		request.setAttribute("users", users);
		request.setAttribute("added", true);
		return NavigationRouteUtil.navigate(request, "Home", "UserForm");
	}

	public String deleteUser(HttpServletRequest request) {
		int userId = Integer.valueOf(request.getParameter("userId"));
		service.deleteUtilisateur((service.selectUtilisateurs(userId)));
		List<Utilisateur> users = service.selectUtilisateurs();
		request.setAttribute("users", users);
		return NavigationRouteUtil.navigate(request, "Home", "UserForm");
	}

	public String updateUser(HttpServletRequest request) {
		int userId = Integer.valueOf(request.getParameter("userId"));
		
		Utilisateur user = service.selectUtilisateurs(userId);
		
		user.setNomComplet(request.getParameter("fullname"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		service.updateUtilisateur(user);
		
		List<Utilisateur> users = service.selectUtilisateurs();
		request.setAttribute("users", users);
		return NavigationRouteUtil.navigate(request, "Home", "UserForm");
	}
	
	public String printDashboard(HttpServletRequest request) {
		return NavigationRouteUtil.navigate(request, "Home", "tableauDeBord");
	}
}
