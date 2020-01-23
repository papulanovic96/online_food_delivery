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
	
<title>Istorija</title>

<style>
tr:hover
{
	background-color: silver;
}
.kkkkk:hover
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

   <div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
        <h2 class="media-heading">Istorija porudžbi</h2>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Proizvod</th>
                        <th>Kolicina</th>
						<th>Kupac</th>
						<th>Dostavljač</th>
						<th>Napomena</th>
						<th>Datum/vrijeme</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>

                <c:forEach var="porudzbina" items="${korisnik.getPorudzbine()}">
                    <tr class="kkkkk">
                    <c:if test="${porudzbina.getPorudzbina_status().equals('Dostavljeno') || porudzbina.getPorudzbina_status().equals('Otkazano')}">
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <div class="media-body">
                                <h4 class="media-heading"><c:out value="${porudzbina.ispis_mape()}"/></h4>
                                <span class="text-danger"><strong><c:out value="${porudzbina.getPorudzbina_status()}" /></strong></span>
                            </div>
                        </div></td>
                        
                        <td  class="col-sm-1 col-md-1" style="text-align: center">
                        <h5 class="media-heading" ><c:out value="${porudzbina.ispis_mape_vrijednost()}"/></h5></td>
                        <td><h5 class="media-heading"><c:out value="${porudzbina.getPorudzbina_kupac_NAZIV()}"/></h5></td>
                        <td><h4 class="media-heading"><c:out value="${porudzbina.getPorudzbina_dostavljac_NAZIV()}"/></h4></td>
                        <td><h4 class="media-heading"><c:out value="${porudzbina.getPorudzbina_napomena()}"/></h4></td>
                        
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <div class="media-body">
                                <h5 class="media-heading"> <c:out value="${porudzbina.getPorudzbina_datumivrijeme()}" /></h5>
							</div>
                        </div></td>
                        </c:if>
                    </tr>
                    </c:forEach>  
                </tbody>
            </table>
        </div>
    </div>
</div>

  </c:if>
  	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>

