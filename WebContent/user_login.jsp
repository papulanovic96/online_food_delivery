<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="Model.Korisnik"%>
<%@page import="Model.Dostavljac"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/stil_user_login.css">

<title>Prijava</title>

</head>
<body class="text-center">

<c:if test="${empty sessionScope.korisnik}">
	
    <form class="form-signin" action="/Project_F_OPH/ServletLogin" method="post">
      <h1 class="h3 mb-3 font-weight-normal">Prijavite se</h1>
      <label for="inputEmail" class="sr-only">Korisnicko ime</label>
      <input type="text" id="inputEmail" class="form-control" name="username" placeholder="Username" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input style="margin-bottom: 20px;" type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
      <button style="margin-bottom: 3px;" class="btn btn-lg btn-primary btn-block" type="submit">Prijavi se</button>
      <p style="margin-bottom: 5px;" class="mt-5 mb-3 text-muted">&copy; 2018-2019</p>
    </form>
    
</c:if>
    
<c:if test="${!empty sessionScope.korisnik}">
	<form action="/Project_F_OPH/ServletLogin" method="post">
	<input type="hidden" name="logoff" value="OUT">
	<button type="submit">Odjavi se</button>
	</form>
</c:if>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick-custom.js"></script>
<script src="js/main.js"></script>
<script src="js/validacija.js"></script>
</body>
</html>