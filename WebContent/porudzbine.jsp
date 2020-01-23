<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Model.Porudzbina"%>
<%@page import="Model.Korisnik"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Porudzbine</title>
<style type="text/css">
body {
      background-color: maroon;
      color: white;
}
tr:hover
{
	  background-color: silver;
}
</style>
</head>
<body>
<c:if test="${!empty sessionScope.korisnik}">

<br>
<br>
  <div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table">
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
                    <tr>
                    <c:if test="${!porudzbina.getPorudzbina_status().equals('Dostavljeno') && !porudzbina.getPorudzbina_status().equals('Otkazano')}">
                        
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <div class="media-body">
                                <h4 class="media-heading"><c:out value="${porudzbina.ispis_mape()}"/></h4>
                                <span class="text-success"><strong><c:out value="${porudzbina.getPorudzbina_status()}" /></strong></span>
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
                       	<td class="col-sm-1 col-md-1">

                        <a class="btn btn-danger" href="/Project_F_OPH/KorisnikKreiranjePorudzbine?otkazi_porudzbu=${porudzbina.getPorudzbina_datumivrijeme()}">
                             Otkaži
                        </a></td>
                        </c:if>
                    </tr>
                    </c:forEach>  
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <a type="button" class="btn btn-default" href="artikli_korisnik.jsp">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Nastavi poručivanje
                        </a></td>
                        <td>
                        
                        <a type="button" class="btn btn-success" href="index.jsp">
                            Završi poručivanje<span class="glyphicon glyphicon-play"></span>
                        </a></td>
                    </tr>
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