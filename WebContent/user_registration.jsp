<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Sign up</title>
<style type="text/css">
html,
body {
  height: 100%;
  width: 100%;
}

body {

  background-color: #99c2ff;
}
</style>
</head>
<body>

<div class="row" style="margin-top: 20px;">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form role="form" action="/Project_F_OPH/ServletSignUp" onsubmit="return phonenumber(telefon_korisnika, email_korisnika)">
			<h2>Registrujte se <small>Besplatno je i uvijek će biti.</small></h2>
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
                        <input type="text" name="ime_korisnika" id="first_name" class="form-control input-lg" placeholder="Ime" tabindex="1">
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="text" name="prezime_korisnika" id="last_name" class="form-control input-lg" placeholder="Prezime" tabindex="2">
					</div>
				</div>
			</div>
			<div class="form-group">
				<input type="text" name="user_name" id="display_name" class="form-control input-lg" placeholder="Korisničko ime" tabindex="3">
			</div>
			<div class="form-group">
				<input type="text" name="email_korisnika" id="email" class="form-control input-lg" placeholder="Email adresa" tabindex="4">
			</div>


					<div class="form-group">
						<input type="password" name="user_password" id="password" class="form-control input-lg" placeholder="Password" tabindex="5">
					</div>


					<div class="form-group">
                        <input type="text" name="uloga_korisnika" value="kupac" readonly="readonly" class="form-control input-lg" tabindex="1">
					</div>


					<div class="form-group">
                        <input type="text" name="telefon_korisnika" class="form-control input-lg" placeholder="Broj telefona" tabindex="1">
					</div>
			
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-md-6"><input type="submit" value="Register" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
				<div class="col-xs-12 col-md-6"><a href="user_login.jsp" class="btn btn-success btn-block btn-lg">Sign In</a></div>
			</div>
		</form>
	</div>
</div>


<script type="text/javascript" src="js/validacija.js"></script>
</body>
</html>