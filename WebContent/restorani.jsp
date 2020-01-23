<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Model.Administrator"%>
<%@page import="Model.Korisnik" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
<title>Restorani admin</title>

<style type="text/css">
body
{
	background-color: teal;
}
.nav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}
.myButton {
	background-color:#599bb3;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Trebuchet MS;
	font-size:12px;
	font-style:italic;
	padding:10px 18px;
	text-decoration:none;
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
	<header class="navbar-fixed-top">
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
								<c:if test="${!empty sessionScope.admin}">
        						<li><a href="index_admin.jsp"><span class="glyphicon glyphicon-user"></span> Dobrodosli, ${admin.getName()}</a></li>
        						</c:if>
								<c:if test="${empty sessionScope.admin}">
        						<li><a href="#"><span class="glyphicon glyphicon-user"></span> Dobrodosli</a></li>
								<li>
									<a href="admin_login.jsp">Admin</a>
								</li>
								</c:if>
        						<c:if test="${!empty sessionScope.admin}">
     							<li>
     							<a href="/Project_F_OPH/AdminLogin?logoff=OUT">Odjavi se</a>
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
        <li><a href="artikli.jsp">Artikli</a></li>
        <li><a href="restorani.jsp">Restorani</a></li>
        <li><a href="vozila.jsp">Vozila</a></li>
        <li><a href="admin_porudzbe.jsp">Porudžbine</a></li>
        <li class="dropdown">
          <button onclick="myFunction()" class="dropbtn">Korisnici</button>
         <div id="myDropdown" class="dropdown-content">
            <a href="lista_admina.jsp">Administratori</a>
            <a href="reg_korisnici.jsp">Kupci</a>
            <a href="dostavljaci_reg.jsp">Dostavljači</a>
          </div>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<c:if test="${empty sessionScope.admin && empty sessionScope.korisnik}">

<div class="container">
			
  <div class="row" style="margin-bottom: 30px;">
    <div class="col-sm-12 col-md-10 col-md-offset-1">
    <h2>RESTORANI</h2>
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
	<c:forEach var="restoran" items="${restorani}">
	<tr>
		<td><c:out value="${restoran.getRestoran_naziv()}" /></td>
		<td><c:out value="${restoran.getRestoran_adresa()}" /></td>
		<td><c:out value="${restoran.getRestoran_kategorija()}" /></td>
		<td><c:out value="${restoran.getLista_jela_NAZIVI()}" /></td>
		<td><c:out value="${restoran.getLista_pica_NAZIVI()}" /></td>
	</tr>
	</c:forEach>
</tbody>
</table>
</div>
</div>
</div>

</c:if>

<c:if test="${!empty sessionScope.admin}">
<div class="card" style="width: 18rem;">
<div class="card-body" style="background-color: maroon; ">
<h5 class="card-title">Pretraga</h5>
<br>
   			<input class="form-control" type="text" id="myInput" onkeyup="myFunction2()" placeholder="Naziv"> <br>
			<input class="form-control" type="text" id="myInput2" onkeyup="myFunction2()" placeholder="Adresa"><br>
			<input class="form-control" type="text" id="myInput3" onkeyup="myFunction2()" placeholder="Kategorija"> 
			</div>
			</div>
<div class="container">

  <div class="row" style="margin-bottom: 30px;">
    <div class="col-sm-12 col-md-10 col-md-offset-1">
    	
    <h2>RESTORANI</h2>
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
	<c:forEach var="restoran" items="${restorani}">
	<tr>
		<td><c:out value="${restoran.getRestoran_naziv()}" /></td>
		<td><c:out value="${restoran.getRestoran_adresa()}" /></td>
		<td><c:out value="${restoran.getRestoran_kategorija()}" /></td>
		<td><c:out value="${restoran.getLista_jela_NAZIVI()}" /></td>
		<td><c:out value="${restoran.getLista_pica_NAZIVI()}" /></td>
		<td><a class="btn btn-warning" href="/Project_F_OPH/AdminEdit?izmjeni=${restoran.getRestoran_naziv()}">Izmjeni</a></td>
		<td><a class="btn btn-danger" href="/Project_F_OPH/AdminDelete?obrisi=${restoran.getRestoran_naziv()}">Obriši</a></td>
	</tr>
	</c:forEach>
</tbody>
</table>
<br>
<a href="dodavanje.jsp" class="btn btn-success">+ Novi restoran</a>
</div>
	</div>
		</div>
</c:if>


<script type="text/javascript">

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
<script type="text/javascript">

/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunctionX() {
    document.getElementById("myDropdownX").classList.toggle("show");
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
<script>
function myFunction2() {
  // Declare variables 
  var input, filter, table, tr, td, i;
  var naziv, adresa, kategorija, ss, kk;

  
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  
  naziv = document.getElementById("myInput");
  adresa = document.getElementById("myInput2");
  kategorija = document.getElementById("myInput3");
  
  filter = naziv.value.toUpperCase();
  filter2 = adresa.value.toUpperCase();
  filter3 = kategorija.value.toUpperCase();
  
  if(naziv != null && adresa != null && kategorija != null)
	  {
	  for (i = 0; i < tr.length; i++) {
		    ss = tr[i].getElementsByTagName("td")[2];
		    td = tr[i].getElementsByTagName("td")[1];
		    kk = tr[i].getElementsByTagName("td")[0];
		    if (td || kk || ss) {
		      if (td.innerHTML.toUpperCase().indexOf(filter2) > -1 && kk.innerHTML.toUpperCase().indexOf(filter) > -1 && ss.innerHTML.toUpperCase().indexOf(filter3) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    } 
		  }
	  }
}
</script>
</body>
</html>