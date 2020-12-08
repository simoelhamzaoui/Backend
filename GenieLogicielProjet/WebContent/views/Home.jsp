<%@page import="com.java.models.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>LOTO</title>
	<script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<script src="js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../css/bootstrap.css" />
	<script src="../js/jquery.min.js"></script>
	
	<link rel="stylesheet" href="css/Style.css" /> 
	<link rel="stylesheet" href="../css/Style.css" />
	<link rel="stylesheet" href="../css/bootstrap.css" />
	<link rel="stylesheet" href="../css/all.min.css" /> 
	<script src="js/fontawesome.js"></script>
	<script src="../js/fontawesome.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('dropdown-toggle').dropdown()
});

function printPage() {
	window.print();
}

</script>
</head>
<body>
	<%
		Utilisateur user = null;
		String view = "";
		if(request.getAttribute("page") != null){
			
			view = (String)request.getAttribute("page");
		}
		if((Utilisateur)request.getSession().getAttribute("user") != null){
			
			user = (Utilisateur)request.getSession().getAttribute("user");
		}
		else {
			response.sendRedirect("../index.jsp");
		}
		
		
	%>
	<div class="container">
	  <div class="row">
	    <div class="col-12" style="padding: 0">
	   		 <jsp:include page="Header.jsp" />
		</div>
 	    <div class="col-12"> 
			<div class="container" style="padding: 15px !important;"> 
	   		 	<jsp:include page="<%= view %>" /> 
			</div>
		</div>
	  </div>
	</div>
		
	<script src="js/jquery-3.3.1.slim.min.js"></script>
	<script src="js/popper.min.js"  ></script>
	<script src="js/bootstrap.min.js" ></script>
		
	<script src="../js/jquery-3.3.1.slim.min.js"></script>
	<script src="../js/popper.min.js"  ></script>
	<script src="../js/bootstrap.min.js" ></script>
</body>
</html>