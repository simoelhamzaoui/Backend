<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.java.models.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<%
	Utilisateur user = null;
	List<String> links = new ArrayList<>();
	String id = "";
	if (request.getSession().getAttribute("user") != null) {
		user = (Utilisateur) request.getSession().getAttribute("user");
	}
%>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	<%if (!links.isEmpty()) {
		for (String link : links) {
			id = link.substring(link.lastIndexOf('/') + 1);
	%>
	<!-- appeler la fonction chaque 2 sec -->
	setInterval(<%= id%>, 2000);
	function <%= id%>(){
	    $.ajax({
	        url: "<%=link%>",
			type : "GET",
			success : function(notification) {
				document.getElementById("<%= id %>").innerHTML = notification;
			},
			error : function(data) {
			}
		});
	}
	
	
<%
		}
		}
%>
window.onload = function () {
    <%
    	for (String link : links) {
    %>
    	<%= link.substring(link.lastIndexOf('/') + 1) + "();"%>
    <%
    	}
    %>
};
</script>
</head>
<body>
	<nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<%
					if (Utilisateur.ADMINISTRATEUR.equals(user.getRole())) {
				%>
				<li class="nav-item"><a class="nav-link" href="../Controller/dashboard" >Tableau de bord</a></li>
				<li class="nav-item"><a class="nav-link" href="../Controller/showUsers">Utilisateurs</a></li>
				<li class="nav-item"><a class="nav-link" href="../Controller/dashboard" >Gestion de la BDD</a></li>
				
				<%
					} else if (Utilisateur.JOUEUR.equals(user.getRole())) {
				%>
				<li class="nav-item"><a class="nav-link">Grilles des jeux récents</a></li>
				<li class="nav-item"><a class="nav-link">Mon compte</a></li>
				<%
					}
				%>
			</ul>
		</div>
		<p class="text-white" style="font-size: 9px; width: 12rem;">Bonjour monsieur <%= user.getNomComplet() %></p>
		<form class="form-inline my-2 my-lg-0"
			style="justify-content: flex-end;" action="../Controller/logout"
			method="post">
			<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Déconnexion</button>
		</form>
	</nav>
</body>
</html>