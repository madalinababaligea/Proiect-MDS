<?php include('server.php');?>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Centru SPA</title>
		
		<link rel="stylesheet" type="text/css" href="./stil.css">
		<link rel="stylesheet" type="text/css" href="./meniu.css">
	</head>
	<body>
		<h1> Bine ati venit <b> </b>!</h1>
		<div class="login-page" id="login-page">
			<div class="form">
				<form class="login-form" action="login.php" method="POST">
					<?php include('errors.php'); ?>
					<input type="text" placeholder="username" id="user" name="username"/>
					<input type="password" placeholder="password" id="pas" name="parola"/>
					<button id="log" name='login'>login</button>
					<p class="message">Not registered? <a href="register.php">Create an account</a></p>
				</form>
			</div>
		</div>
	</body>
</html>