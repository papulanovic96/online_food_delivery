<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="Model.Korisnik"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
<title>User page</title>

<style>
tr:hover
{
	  background-color: silver;
}
body {
      background-color: maroon;
      color: gray;
}
.dropbtn {
    background-color: transparent;
    color: gray;
    padding: 12.5px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
    color: black;
}

.dropdown {
    position: relative;
    display: inline-block;
}
.kont{
    	margin: 50px;
        padding-right: 400px;
    }

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f1f1f1;
    min-width: 160px;
    overflow: auto;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown a:hover {color: black;}

.show {display: block;}
</style>
</head>
<body class="animsition">

	<!-- Header -->
	<header class="navbar navbar-fixed-top">
		<!-- Header desktop -->
		<div class="wrap-menu-header gradient1 trans-0-4">
			<div class="container h-full">
				<div class="wrap_header trans-0-3">
					<!-- Logo -->
					<div class="logo">
						<a href="index.jsp">
							<img src="img/logo.png" alt="IMG-LOGO" data-logofixed="imglogo2.png">
						</a>
					</div>

					<!-- Menu -->
					<div class="wrap_menu p-l-45 p-l-0-xl">
						<nav class="menu">
							<ul class="main_menu">
								<li>
									<a href="index.jsp">Home</a>
								</li>

								<li>
									<a href="admin_login.jsp">Admin</a>
								</li>

								<c:if test="${!empty sessionScope.korisnik}">
        						<li><a href="kreiranje_porudzbine.jsp"><span class="glyphicon glyphicon-user"></span> Dobrodošli, ${korisnik.getName()}</a></li>
        						</c:if>
<c:if test="${empty sessionScope.korisnik}">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Dobrodošli</a></li>
        </c:if>
								        <c:if test="${!empty sessionScope.korisnik}">
        <li><a href="porudzbine.jsp"><span class="glyphicon glyphicon-shopping-cart"></span>Porudžbine (${korisnik.getBrojPorudzbina()})</a></li>
        </c:if>
        						<c:if test="${empty sessionScope.korisnik}">
								<li>
									<a href="user_registration.jsp">Register</a>
								</li>
								</c:if>
		<c:if test="${empty sessionScope.korisnik}">
        <li><a href="dostava_ili_kupac.jsp">Log in</a></li>
		</c:if>
        <c:if test="${!empty sessionScope.korisnik}">
     	<li>
     	<a href="/Project_F_OPH/ServletLogin?logoff=OUT">Odjavi se</a>
		</li>
     	</c:if>
							</ul>
						</nav>
					</div>

					<!-- Social -->
					<div class="social flex-w flex-l-m p-r-20">
						<a href="#"><i class="fa fa-tripadvisor" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-facebook m-l-21" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-twitter m-l-21" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-facebook m-l-21" aria-hidden="true"></i></a>
						
					</div>
				</div>
			</div>
		</div>
	</header>
    
    <nav style="margin-top: 120px;" class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="istorija.jsp">Istorija porudžbina</a></li>
    	<li><a href="omiljeni.jsp">Omiljeni restorani</a></li>
    	<li><a href="artikli_korisnik.jsp">Poruči artikle</a></li>

      </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<c:if test="${!empty sessionScope.korisnik}">
<div class="kont">

<form action="/Project_F_OPH/KorisnikKreiranjePorudzbine">

<div class="form-group" style="padding-right: 400px;">
Unesite količinu artikala: <input type="text" name="kolicina"  class="form-control" placeholder="Količina"></div>
<button type="submit" class="btn btn-success" name="napravi_porudzbu" value="create_man">+ napravi_porudzbu</button>
<table class="table ">
<thead>
      <tr class="header">
      	<th>Naziv</th>
		<th>Cjena</th>
		<th>Opis</th>
		<th>Kolicina</th>
		<th>Tip</th>
		<th>Unos kolicine</th>
		<th></th>
	</tr>
</thead>
    <tbody>
    
	<c:forEach var="artikal" items="${artikli}">

	<tr>
		<td><c:out value="${artikal.getNaziv_artikla()}" /></td>
		<td><c:out value="${artikal.getJedinicna_cjena()}" /></td>
		<td><c:out value="${artikal.getOpis_artikla()}" /></td>
		<td><c:out value="${artikal.getKolicina_artikla()}" /></td>
		<td><c:out value="${artikal.getArtikal_tip()}" /></td>
		<td><c:if test="${!artikal.getArtikal_tip().equals('obrisan')}"><button type="submit" class="btn btn-success" name="poruci" value="${artikal.getNaziv_artikla()}">+ poruči</button></c:if></td>
	</tr>
		
	</c:forEach>
	
    </tbody>
  </table>
  </form>
  </div>
  </c:if>

<script src="js/bootstrap.min.js"></script>
<script src="js/slick-custom.js"></script>
<script src="js/main.js"></script>
</body>
</html>