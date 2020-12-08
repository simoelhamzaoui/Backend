<%@page import="com.java.models.Utilisateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOTO</title>
</head>
<body>
	<%
		List<Utilisateur> users = (List<Utilisateur>) request.getAttribute("utilisateurs");
		boolean added = false;
		if (request.getAttribute("added") != null)
			added = (boolean) request.getAttribute("added");
	%>

	<div class="Forms">
	
		<div class="alert alert-info" role="alert">
			<h5>Liste des utilisateurs</h5>

		</div>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Utilisateur</th>
					<th scope="col">Nom complet</th>
					<th scope="col">Role</th>
					<th scope="col">Gérer</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (users != null) {
						for (Utilisateur u : users) {
				%>

				<form method="post">
				<input type="hidden" name="userId" value="<%=u.getId()%>">
					<tr>
						<td><input type="text" class="form-control" name="username"
							value="<%=u.getUsername()%>" required></td>
						<td><input type="text" class="form-control" name="fullname"
							value="<%=u.getNomComplet()%>" required></td>
						<td><%=u.getRole()%></td>
						<td>
							<button type="submit" class="btn btn-primary"
								formaction="../Controller/alterUser">modifier</button>
							<button type="submit" class="btn btn-danger"
								formaction="../Controller/deleteUser">supprimer</button>
						</td>
					</tr>
				</form>

				<%
					}
					}
				%>
			</tbody>
		</table>
		
		<br />
		
		
		<div class="alert alert-info" role="alert">
			<h5>Ajouter un administrateur</h5>
		</div>
		
		<div class="col-6">
			<form action="../Controller/addAdmin" method="post">
				<div class="form-group">
					<label for="username">Pseudo</label> <input type="text"
						class="form-control" name="username"
						placeholder="Nom d'utilisateur" required>
				</div>
				<div class="form-group">
					<label for="fullname">Nom complet</label> <input type="text"
						class="form-control" name="fullname" placeholder="Nom complet" required>
				</div>
				<div class="form-group">
					<label for="password">Mot de passe</label> <input type="password"
						class="form-control" name="password" placeholder="Mot de passe" required>
				</div>
				<button type="submit" class="btn btn-primary">Valider</button>
			</form>
		</div>
	</div>
</body>
</html>