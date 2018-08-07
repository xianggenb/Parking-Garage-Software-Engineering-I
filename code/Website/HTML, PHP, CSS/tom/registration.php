<!DOCTYPE html>
<html>
	<head>
		<title>
			Registration
		</title>
	</head>
	<body>

	<?php

	$host = "localhost";
	$user = "root";
	$password = "12490824";
	$db = "accountmanagement";
	$connect = mysqli_connect($host,$user,$password,$db);

	$f_name = $_POST['fnameinput'];
	$l_name = $_POST['lnameinput'];
	$email = $_POST['emailinput'];
	$f_pass = $_POST['Password1'];
	$s_pass = $_POST['Password2'];
	$zipcode = $_POST['zipinput'];
	$phone = $_POST['phoneinput'];

	if (empty($f_name)){
		echo "<p>Please type in the first name";
		echo '<a href = "..\Registeration.html">' . "<p>Back to the Previous page";
	}
	else if (empty($l_name)){
		echo "<p>Please type in the last name";
		echo '<a href = "..\Registeration.html">' . "<p>Back to the Previous page";
	}
	else if (empty($email)){
		echo "<p>Please type in the email address";
		echo '<a href = "..\Registeration.html">' . "<p>Back to the Previous page";
	}
	else if (empty($f_pass) or empty($s_pass)){
		echo "<p>Please make sure you type in the password twice";
		echo '<a href = "..\Registeration.html">' . "<p>Back to the Previous page";
	}
	else if (empty($zipcode)){
		echo "<p>Please type in the zip code";
		echo '<a href = "..\Registeration.html">' . "<p>Back to the Previous page";
	}
	else if (empty($phone)){
		echo "<p>Please type in the mobile phone number";
		echo '<a href = "..\Registeration.html">' . "<p>Back to the Previous page";
	}
	else if ($f_pass != $s_pass){
		echo "<p>Please make sure the password you type in are the same";
		echo '<a href = "..\Registeration.html">' . "<p>Back to the Previous page";
	}
	
	if (!$connect){
		echo "Can't connect to the database!";
	}
	$sql = "INSERT INTO user (first_name, last_name, emailaddress, zip_code, phone) VALUES(?,?,?,?,?)";
	$stmt = mysqli_prepare($connect, $sql);
	mysqli_stmt_bind_param($stmt,"sssss",$f_name, $l_name, $email, $zipcode, $phone);
	mysqli_stmt_execute($stmt);
	if (mysqli_stmt_affected_rows($stmt) == 1){
		$sql2 = "INSERT INTO logininfo (password,Username) VALUES(?,?)";
		$stmt2 = mysqli_prepare($connect, $sql2);
		mysqli_stmt_bind_param($stmt2,"ss",$f_pass, $email);
		mysqli_stmt_execute($stmt2);
		if (mysqli_stmt_affected_rows($stmt2) == 1){
			echo 'You have successfully created your account!';
			echo '<a href = "..\homepage.html">' . "<p>Back to the login page";

		}

	}

	?>