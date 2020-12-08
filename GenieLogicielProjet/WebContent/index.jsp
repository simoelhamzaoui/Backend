<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenue au Jeu</title>

<link rel="stylesheet" href="../css/bootstrap.css" />
<link rel="stylesheet" href="../css/Style.css" />
<link rel="stylesheet" href="../css/particles.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/particles.css" />
<link rel="stylesheet" href="css/Style.css" />
</head>
<body>
	<%
		
		boolean flag = false;
		String message = "";
		String action = "Controller/login";
		String img = "photo/loto.png";

		if (request.getAttribute("flag") != null) {
			flag = (Boolean) request.getAttribute("flag");
			message = (String) request.getAttribute("message");
			img = "../photo/loto.png"; 
		}
		if (request.getAttribute("logout") != null) {

			action = "../Controller/login";
			img = "../photo/loto.png"; 
		}
		
		if (request.getSession().getAttribute("user") != null && !flag) {
			String redirectURL = "views/Home.jsp";
			response.sendRedirect(redirectURL);
		}

	%>
	<div id="particles-js"></div>
	<div class="container">
		<div class="row">
			<div class="col-sm"></div>
			<div class="col-sm card Divs">
				<div>
					<img src="<%=img%>"
						style="display: block; margin: 0 auto; max-width: 50%; width: 110px;" />
				</div>
				<hr />
				<%
					if (flag) {
						action = "../Controller/login";
				%>
				<div class="alert alert-danger" role="alert">
					<%=message%>
				</div>
				<%
					}
				%>
				<form action="<%=action%>" method="post">
					<div class="form-group">
						<label for="usernameInput">Nom d'utilsateur :</label> <input
							type="text" class="form-control" name="username"
							id="usernameInput">
					</div>
					<div class="form-group">
						<label for="InputPassword">Mot de passe :</label> <input
							type="password" class="form-control" name="password"
							id="InputPassword">
					</div>
					<button type="submit" class="btn btn-primary"
						style="display: block; margin: 0 auto;">Se Connecter</button>
					<li> <a type="submit" class="btn btn-primary"
						style="display: block; margin: 0 auto; " href="./Controller/inscription" >S'inscrire</a></li>
				</form>
			</div>
			<div class="col-sm"></div>
		</div>
	</div>
	<script src="js/jquery-3.3.1.slim.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/particles.min.js"></script>
	<script src="js/particles.js"></script>
	<script src="js/stats.min.js"></script>

	<script src="../js/jquery-3.3.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/particles.min.js"></script>
	<script src="../js/particles.js"></script>
	<script src="../js/stats.min.js"></script>
</body>
</html>