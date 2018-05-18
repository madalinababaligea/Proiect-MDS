<?php include('server.php') ?>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Centru SPA</title>
		<!--<script src="./profil.js"></script>-->
		<link rel="stylesheet" type="text/css" href="./profil.css">
		<link rel="stylesheet" type="text/css" href="./meniupr.css">
	</head>
	<body>
		<div class="content">
			<?php if(isset($_SESSION["username"])): ?>
				<h1>Bine ai venit <strong><?php echo $_SESSION['username']; ?></strong>(<?php echo $_SESSION['utilizator']; ?>)!</h1>
				<p><a href="login.php?logout='1'" style="color: red; text-align: right;">Logout</a></p>
			<?php endif ?>

		</div>
		<?php if(isset($_SESSION['utilizator']) && $_SESSION['utilizator']=="client"):?>
			<nav id="client">
				<ul class="meniu">
					<li><a href="#">Rezerva loc</a></li>
					<li><a href="#">Portofel</a></li>
					<li><a href="./profilClient.php">Profil</a></li>
				</ul>
			</nav>
		<?php elseif (isset($_SESSION['utilizator']) && $_SESSION['utilizator']=="manager"): ?>
			<nav id="manager">
				<ul class="meniu">
					<li><a href="#">Persoane</a></li>
					<li><a href="#">Cheltuieli</a></li>
					<li><a href="./profilManager.php">Profil</a></li>
				</ul>
			</nav>
		<?php endif ?> 
		<div id="pagina">
		     
		</div>
	
</html>