<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Model.Artikal"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Izmjeni artikal</title>
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
								<c:if test="${empty sessionScope.admin}">
								<li>
									<a href="admin_login.jsp">Admin</a>
								</li>
								</c:if>
								<c:if test="${!empty sessionScope.admin}">
        						<li><a href="index_admin.jsp"><span class="glyphicon glyphicon-user"></span> Dobrodosli, ${admin.getName()}</a></li>
        						</c:if>
								<c:if test="${empty sessionScope.admin}">
        						<li><a href="#"><span class="glyphicon glyphicon-user"></span> Dobrodosli</a></li>
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
    <form action="/Project_F_OPH/AdminCreate">
        <div class="form-group">
            <input type="text" name="naziv_artikla" class="form-control" placeholder="Naziv artikla" value="<%=request.getAttribute("naz")%>" required>
        </div>
        <div class="form-group">
            <input type="text" name="cjena_artikla" class="form-control" placeholder="Cjena artikla" value="<%=request.getAttribute("cje")%>" required>
        </div>
        <div class="form-group">
            <input type="text" name="kolicina_grami_mililitri" class="form-control" placeholder="Količina porcije artikla" value="<%=request.getAttribute("kpa")%>" required>
        </div>
        <div class="form-group">
            <input type="text"  name="kolicina_artikla" class="form-control" placeholder="Na stanju" value="<%=request.getAttribute("nst")%>" required>
        </div>

        <div class="form-group">
            <select id="selectResto" class="form-control" name = "restoran_artikal" placeholder="Restoran" required>
            <c:forEach var="restoran" items="${restorani}">
				<option value="${restoran.getRestoran_naziv()}" ><c:out value="${restoran.getRestoran_naziv()}" /></option>
			</c:forEach>
                    </select>
        </div>
        <div class="form-group">
            <select id="mySelect" class="form-control" placeholder="Tip" name="tip_artikla" required>
            <option value="jelo">Jelo</option>
            <option value="pice">Piće</option>
                    </select>
        </div>
        <div class="form-group">
            <input style="height: 100px;" name="opis_artikla" type="text" class="form-control" placeholder="Opis artikla" value="<%=request.getAttribute("ops")%>" required>
        </div>

        <button type="submit" class="btn btn-primary">Izmjeni</button>
        
    </form>
</div>

</c:if>
<div style="margin-top: 30px;">
<footer class="container-fluid text-center">

</footer></div>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick-custom.js"></script>
<script src="js/main.js"></script>
<script>
function myFunctionx() {
    document.getElementById("mySelect").value = "<%=request.getAttribute("tip")%>";
    document.getElementById("selectResto").value = "<%=request.getAttribute("res")%>";
}
</script>
<script>
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function fank() {
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