<?php
	$nume = $_POST['nume'];
	$prenume = $_POST['prenume'];
	$username = $_POST['username'];
	$parola = $_POST['parola'];
	$adresa = $_POST['adresa'];
	$email = $_POST['email'];
	$utilizator = $_POST['utilizator'];
	if(!empty($nume) || !empty($prenume) || !empty(username) || !empty($parola) || !empty($adresa) || !empty($email) || !empty(utilizator))
	{
		
	}
	else
	{
		echo "Toate campurile sunt obligatorii";
		die();
	}
?>