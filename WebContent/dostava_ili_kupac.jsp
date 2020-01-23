<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="Model.Korisnik"%>
<%@page import="Model.Dostavljac"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Sign in</title>

<style type="text/css">
html,
body {
  height: 100%;
}

body {
  display: -ms-flexbox;
  display: flex;
  -ms-flex-align: center;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
  font-family: Nirmala UI;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}
.form-signin .checkbox {
  font-weight: 400;
}
.form-signin .form-control {
  position: relative;
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: 10px;
 
}
.form-signin input[type="password"] {
  margin-top: 10px;

}
</style>

  </head>

  <body>
  <c:if test="${empty sessionScope.korisnik && empty sessionScope.dostavljac}">
  <body class="text-center">
  <form class="form-signin">
      <h1 class="h3 mb-3 font-weight-normal">Prijavite se</h1>
      <div><a style="margin-bottom: 3px;" class="btn btn-lg btn-primary btn-block" href="user_login.jsp">Kupac</a></div>
      <div><a style="margin-bottom: 3px;" class="btn btn-lg btn-primary btn-block" href="dostava_login.jsp">Dostavljač</a></div>
      <p style="margin-bottom: 5px;" class="mt-5 mb-3 text-muted">&copy; 2018-2019</p>
      <p><a href="user_registration.jsp">Otvori nalog</a></p>
    </form>
    </c:if>
<c:if test="${!empty sessionScope.korisnik}">
	<form class="form-signin" action="/Project_F_OPH/ServletLogin" method="post">
	<p style="margin-bottom: 5px; text-align: center;" class="mt-5 mb-3 text-muted"> Korisnik,<strong> ${korisnik.getName()}</strong> je ulogovan. </p>
	<input type="hidden" name="logoff" value="OUT">
	<button style="margin-bottom: 3px;" class="btn btn-lg btn-primary btn-block" type="submit">Odjavi se</button>
	</form>
</c:if>

<c:if test="${!empty sessionScope.dostavljac }">
	<form class="form-signin" action="/Project_F_OPH/DostavaLogin" method="post">
	<p style="margin-bottom: 5px; text-align: center;" class="mt-5 mb-3 text-muted"> Dostavljač,<strong> ${dostavljac.getName()}</strong> je ulogovan. </p>
	<input type="hidden" name="logoff" value="OUT">
	<button style="margin-bottom: 3px;" class="btn btn-lg btn-primary btn-block" type="submit">Odjavi se</button>
	</form>
</c:if>
</body>
</html>