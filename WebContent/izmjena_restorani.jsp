<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Model.Administrator"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Dodaj restoran</title>
<style>
body 
{
      background-color: teal;
}
footer 
{
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

.kont{
    	margin: 50px;
        padding-right: 1000px;
    }

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    
    padding-top: 200px; /* Location of the box */

    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
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
</style>
</head>
<body class="animsition" onload="myFunctionx()">

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
          <button onclick="fank()" class="dropbtn">Korisnici</button>
          <div id="myDropdown" class="dropdown-content">
            <a href="lista_admina.jsp">Administratori</a>
           	<a href="reg_korisnici.jsp">Kupci</a>
            <a href="kategorija_kineski.jsp">Dostavljači</a>
          </div>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<c:if test="${!empty sessionScope.admin}">
<div class="kont">
    <form action="/Project_F_OPH/AdminRestoran">
        <div class="form-group">
            <input type="button" id="myBtn" class="form-control" required value="...">
        </div>
        <div class="form-group">
            <input type="text" name="naziv_restorana"  name="cjena_artikla" class="form-control" placeholder="Naziv restorana" required value="<%=request.getAttribute("naz")%>">
        </div>
        <div class="form-group">
            <input type="text" name="adresa_restorana" class="form-control" placeholder="Adresa restorana" required value="<%=request.getAttribute("adr")%>">
        </div>
        <div class="form-group">
            <select class="form-control" name="kategorija_restorana" id="mySelect">
				<option value="Domaca kuhinja">Domaća kuhinja</option>
				<option value="Rostilj">Roštilj</option>
				<option value="Kineski restoran">Kineski restoran</option>
				<option value="Indijski restoran">Indijski restoran</option>
				<option value="Poslasticarnica">Poslastičarnica</option>
				<option value="Picerija">Picerija</option>
			</select>
        </div>

        <button type="submit" class="btn btn-primary">Dodaj</button>
        
    </form>
</div>

</c:if>
  
   <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Dodaj pića u restoran</h4>
        </div>
        <div class="modal-body">
          <table id="myTable">

	<tr class="header">
		<th>Naziv</th>
		<th>Cjena</th>
		<th>Opis</th>
		<th>Kolicina</th>
		<th colspan="2"></th>
	</tr>
	<c:forEach var="artikal" items="${artikli}">
	<tr>
		<td id="a_naz" ><c:out value="${artikal.getNaziv_artikla()}" /></td>
		<td id="a_cje" ><c:out value="${artikal.getJedinicna_cjena()}" /></td>
		<td id="a_ops" ><c:out value="${artikal.getOpis_artikla()}" /></td>
		<td id="a_kol" ><c:out value="${artikal.getKolicina_artikla()}" /></td>
		<td ><a class="btn btn-default" href="/Project_F_OPH/AdminRestoran?artikal_pice=${artikal.getNaziv_artikla()}">+ dodaj</a></td>
	</tr>
	</c:forEach>

</table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Dodaj pića u restoran</h4>
        </div>
        <div class="modal-body">
          <table class="table table-hover" id="myTable">

	<tr class="header">
		<th>Naziv</th>
		<th>Cjena</th>
		<th>Opis</th>
		<th>Kolicina</th>
		<th colspan="2"></th>
	</tr>
	<c:forEach var="artikal" items="${artikli}">
	<tr>
		<td id="a_naz" ><c:out value="${artikal.getNaziv_artikla()}" /></td>
		<td id="a_cje" ><c:out value="${artikal.getJedinicna_cjena()}" /></td>
		<td id="a_ops" ><c:out value="${artikal.getOpis_artikla()}" /></td>
		<td id="a_kol" ><c:out value="${artikal.getKolicina_artikla()}" /></td>
		<td ><a class="btn btn-succes" href="/Project_F_OPH/AdminRestoran?artikal_pice=${artikal.getNaziv_artikla()}">+ dodaj</a></td>
	</tr>
	</c:forEach>

</table>
        </div>

</div>
<script>
function myFunctionx() {
    document.getElementById("mySelect").value = "<%=request.getAttribute("kat")%>";
}
</script>
<script>
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
</script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick-custom.js"></script>
<script src="js/main.js"></script>

</body>
</html>