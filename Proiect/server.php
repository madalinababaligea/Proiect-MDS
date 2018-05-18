<?php
	session_start();
	
	$nume= "";
	$prenume = "";
	$username = "";
	$adresa = "";
	$email = "";
	$errors = array();


	$db = mysqli_connect('localhost', 'root', 'adinaabc123', 'spa'); 


	if(isset($_POST['register'])){
		$nume = mysqli_real_escape_string($db,$_POST['nume']);
		$prenume = mysqli_real_escape_string($db,$_POST['prenume']);
		$username = mysqli_real_escape_string($db, $_POST['username']);
		$parola1 = mysqli_real_escape_string($db, $_POST['parola1']);
		$parola2 = mysqli_real_escape_string($db, $_POST['parola2']);
		$adresa = mysqli_real_escape_string($db, $_POST['adresa']);
		$email = mysqli_real_escape_string($db, $_POST['email']);
		$cod = mysqli_real_escape_string($db, md5(rand(0,1000)));
		$utilizator = $_POST['utilizator'];

		if(empty($nume)) {
			array_push($errors, "Numele este obligatoriu");
		}

		if(empty($prenume)) {
			array_push($errors, "Prenumele este obligatoriu");
		}

		if(empty($username)) {
			array_push($errors, "Username-ul este obligatoriu");
		}
		if(empty($parola1)) {
			array_push($errors, "Parola este obligatorie");
		}
		if($parola1 != $parola2) {
			array_push($errors, "Parolele difera");
		}
		if(empty($adresa)) {
			array_push($errors, "Adresa este obligatorie");
		}
		if(empty($email)) {
			array_push($errors, "Emailul este obligatoriu");
		}
		if(!isset($utilizator)) {
			array_push($errors, "Tipul utilizatorului este obligatoriu");
		}
		if(count($errors) == 0) {
			$query1 = "SELECT * FROM clienti WHERE Username='$username'";
			$query2 = "SELECT * FROM clienti WHERE Email='$email'";
			$rez1 = mysqli_query($db, $query1);
			$rez2 = mysqli_query($db, $query2);
			if(mysqli_num_rows($rez1)!=0){
				array_push($errors, "Acest username exista deja");
			}
			if(mysqli_num_rows($rez2)!=0){
				array_push($errors, "Acest email exista deja");
			}
			if(count($errors) == 0)
			{
				$parola = $parola1;
				$sql = "INSERT INTO clienti (Nume, Prenume, Username, Parola, Adresa, Email, Utilizator,Cod) VALUES ('$nume', '$prenume', '$username', '$parola', '$adresa', '$email', '$utilizator', '$cod')";
				$rezult=mysqli_query($db, $sql);
				if($rezult){
					$to = $email;
					$subject = 'Cod Spa';
					$message_body = 'Buna '.$prenume.' ,
					Iti multumim pentru ca ti-ai facut cont si doresti sa beneficiezi de serviciile noastre. Acesta este codul tau pentru SPA: '.$cod.'.
					Sa ai o zi frumoasa!';
					$headers = 'From: ursuadina98@yahoo.com';
					mail($to, $subject, $message_body, $headers);
					$_SESSION['username'] = $_POST['username'];//$username;
					$_SESSION['utilizator'] = $_POST['utilizator'];//$utilizator;
					header('location: profil.php');
				}
			}

		}
	}
	//logare din pagina de login
	if(isset($_POST['login'])){
		$username = mysqli_real_escape_string($db, $_POST['username']);
		$parola = mysqli_real_escape_string($db, $_POST['parola']);
		//$utilizator = $_GET['utilizator'];
		if(empty($username)) {
			array_push($errors, "Username-ul este obligatoriu");
		}
		if(empty($parola)) {
			array_push($errors, "Parola este obligatorie");
		}
		if(count($errors) == 0){
		//	$parola = md5($parola);
			$query = "SELECT * FROM clienti WHERE Username='$username' AND Parola='$parola'";
			$rez = mysqli_query($db, $query);
			if($rez==false){
				array_push($errors, "Userul sau parola sunt gresite");
			}
			else
				if(mysqli_num_rows($rez)==1){
					$_SESSION['username'] = $username;
					$sel="SELECT * FROM clienti WHERE Username='$username' AND Parola='$parola'";
					$rezultat1 = mysqli_query($db, $sel);
					$util = mysqli_fetch_assoc($rezultat1);
					echo $util;
					$utilizator = $util['Utilizator'];
					$_SESSION['utilizator'] = $utilizator;
					header('location: profil.php');
				}
		}
	}

	//logout
	if (isset($_GET['logout'])){
		session_destroy();
		unset($_SESSION['username']);
		unset($_SESSION['utilizator']);
		header('location: login.php');

	}
?>