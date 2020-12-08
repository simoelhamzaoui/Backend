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

		<div class="alert alert-info" role="alert">
			<h5>Veuillez remplir vos informations</h5>

		</div>
		
		<div class="col-6">
			<form action="../Controller/addUser" method="post">
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
</body>