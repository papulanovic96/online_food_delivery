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
	
<title>Papito's</title>

<style>

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: 150px;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

footer {
      background-color: #f2f2f2;
      padding: 25px;
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

<img style="width: 100%;" src="images/slide1-01.jpg" alt="IMG-LOGO" data-logofixed="imglogo2.png">
 
    
    <nav  class="navbar navbar-default">
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
        <li><a href="top.jsp">Artikli</a></li>
        <li class="dropdown">
          <button onclick="myFunction()" class="dropbtn">Restorani</button>
         <div id="myDropdown" class="dropdown-content">
            <a href="kategorija_domaca.jsp">Domaća kuhinja</a>
            <a href="kategorija.jsp">Roštilj</a>
            <a href="kategorija_kineski.jsp">Kineski restoran</a>
            <a href="kategorija_indijski.jsp" >Indijski restoran</a>
            <a href="kategorija_slasticarna.jsp" >Poslastičarnica</a>
            <a href="kategorija_picerija.jsp" >Picerija</a>
          </div>
        </li>
      </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container">

  <div class="row" style="margin-bottom: 30px;">
    <div class="col-sm-12 col-md-10 col-md-offset-1">
    <h2>DOMAĆA KUHINJA</h2>
<table class="table table-hover" id="myTable">

<thead>
	<tr class="header">
		<th scope="col">Naziv</th>
		<th scope="col">Adresa</th>
		<th scope="col">Kategorija</th>
		<th scope="col">Jela</th>
		<th scope="col">Pica</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="restoran" items="${InstanceOPH.getInstance().getListaRestorana()}">
		<c:if test="${restoran.getRestoran_kategorija().equals('Domaca kuhinja')}">
	<tr>
		<td><c:out value="${restoran.getRestoran_naziv()}" /></td>	<!--id="myBtn"  -->
		<td><c:out value="${restoran.getRestoran_adresa()}" /></td>
		<td><c:out value="${restoran.getRestoran_kategorija()}" /></td>
		<td><c:out value="${restoran.getLista_jela_NAZIVI()}" /></td>
		<td><c:out value="${restoran.getLista_pica_NAZIVI()}" /></td>
	</tr>
	</c:if>
	</c:forEach>
</tbody>
</table>
</div>
</div>
</div>

<!-- 	
<div id="myModal" class="modal">

      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Artikli</h4>
        </div>
        <div class="modal-body">
          <table class="table table-hover" id="myTable">

	<tr class="header">
		<th>Jela</th>
		<th>Pića</th>
	</tr>
	<tr>
		<td id="a_naz" ><c:out value="${restoran.getLista_jela_NAZIVI()}" /></td>
		<td id="a_cje" ><c:out value="${restoran.getLista_pica_NAZIVI()}" /></td>
	</tr>


</table>
        </div>

</div>
</div> -->	
			

<script src="js/bootstrap.min.js"></script>
<script src="js/slick-custom.js"></script>
<script src="js/main.js"></script>

<!-- <script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script> -->
<script>
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>
</body>
</html>