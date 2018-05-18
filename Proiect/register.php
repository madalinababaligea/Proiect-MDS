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
				<form class="register-form" action="register.php" method="POST">
					<?php include('errors.php'); ?>
					<input type="text" placeholder="nume" id="nume" name="nume" value="<?php echo $nume; ?>" />
					<input type="text" placeholder="prenume" id="prenume" name="prenume" value="<?php echo $prenume; ?>"/>
					<input type="text" placeholder="username" id="name" name="username" value="<?php echo $username; ?>"/>
					<input type="password" placeholder="password" id="pass" name="parola1"/>
					<input type="password" placeholder="confirm password" id="conf" name="parola2"/>
					<input type="text" placeholder="adresa" id="adresa" name="adresa" value="<?php echo $adresa; ?>"/>
					<input type="text" placeholder="email address" id="email" name="email" value="<?php echo $email; ?>"/>
						<input type="radio" name="utilizator" value="client" id="c"><label for="c" checked>Client</label>
						<input type="radio" name="utilizator" value="manager" id="m"><label for="m">Manager</label>
					<button id="reg" name='register'>create</button>
					<p class="message">Already registered? <a href="login.php">Sign In</a></p>
				</form>
			</div>
		</div>
	</body>
</html>