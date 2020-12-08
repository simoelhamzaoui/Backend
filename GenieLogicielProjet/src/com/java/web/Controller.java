package com.java.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.business.Service;
import com.java.business.ServiceDefault;
import com.java.dao.UtilisateurDao;
import com.java.dao.UtilisateurDaoJdbc;
import com.java.dao.jdbc.DataSource;
import com.java.dao.jdbc.Database;
import com.java.dao.jdbc.MySQLDataSource;
import com.java.web.actions.UtilisateurAction;
import com.java.web.utils.NavigationRouteUtil;

@WebServlet({ "/Controller", "/Controller/*" })
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	private UtilisateurAction utilisateurAction;
	
	public void init(ServletConfig config) throws ServletException {
		DataSource dataSource = new MySQLDataSource("localhost", "genielogiciel", "root", "");
		Database db = new Database(dataSource);
		
		UtilisateurDao utilisateurDao = new UtilisateurDaoJdbc(db);
		
		Service service = new ServiceDefault(utilisateurDao);
		
		this.utilisateurAction = new UtilisateurAction(service);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/views/Error.jsp";
		String uri = request.getRequestURI();
		
		if(uri.endsWith("/login")) {
			view = this.utilisateurAction.login(request);
		}
		else if(uri.endsWith("/logout")) {
			view = this.utilisateurAction.logout(request);
		}
		else if(uri.endsWith("/showUsers")) {
			view = this.utilisateurAction.listUsers(request);
		}
		else if(uri.endsWith("/addUser")) {
			view = this.utilisateurAction.addUser(request);
		}
		else if(uri.endsWith("/addAdmin")) {
			view = this.utilisateurAction.addAdmin(request);
		}
		else if(uri.endsWith("/alterUser")) {
			view = this.utilisateurAction.updateUser(request);
		}
		else if(uri.endsWith("/deleteUser")) {
			view = this.utilisateurAction.deleteUser(request);
		}
		else if(uri.endsWith("/dashboard")) {
			view = this.utilisateurAction.printDashboard(request);
		}
		else if(uri.endsWith("/inscription")) {
			view = NavigationRouteUtil.navigate(request, "Home", "inscription");
		}
		request.getRequestDispatcher(view).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
