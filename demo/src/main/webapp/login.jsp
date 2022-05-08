<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Login</title>
		<link rel="stylesheet" href="style/style.css">
		</style>
	</head>
	
	<body>
		
		<h1>Benvenuto!</h1>
		<p>Inserisci i tuoi dati per accedere</p>

		<form class="loginform" action="/demo/login" method="post">
			<p>Username</p>
			<input type="text" name="username" required placeholder="Username">
			<br>
			<p>Password</p>
			<input type="password" name="password" required placeholder="Password">
			<br>
			<input type="submit" name="Submit" value="Accedi">

			<p>Non sei registrato? <a href="RegisterPage.jsp">Registrati qui!</a></p>
		</form>


	</body>
</html>