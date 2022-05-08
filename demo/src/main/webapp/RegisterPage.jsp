<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Login</title>
		<link rel="stylesheet" href="style/style.css">
	</head>
	
	<body>
		
		<h1>Benvenuto!</h1>
		<p>Inserisci i tuoi dati per accedere</p>
		
		<form class="loginform" action="register" method="POST">
			<p>Username</p>
			<input type="text" name="username" required minlength="4" maxlength="20" placeholder="Username">
			<br>
			<p>Password</p>
			<input type="password" name="password" minlength="6" maxlength="20" required placeholder="Password">
			<br>
            <p>Nome</p>
            <input type="text" name="firstname" required placeholder="Nome">
            <br>
            <p>Cognome</p>
            <input type="text" name="lastname" required placeholder="cognome">
            <br>
			<input type="submit" value="Registrati">
		</form>


	</body>
</html>