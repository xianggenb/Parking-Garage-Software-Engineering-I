<!DOCTYPE html>
<html>
	<head>
		<title>
			Registration
		</title>
	</head>
	<body>

	<?php
	// Varibale which used to link the database.
	$host = "localhost";
	$user = "root";
	$password = "";
	$db = "accountmanagement";
	$connect = mysqli_connect($host,$user,$password,$db);
  	// Variables which got from the webpage.
	$f_name = $_POST['fnameinput'];
	$l_name = $_POST['lnameinput'];
	$email = $_POST['emailinput'];
	$f_pass = $_POST['Password1'];
	$s_pass = $_POST['Password2'];
	$zipcode = $_POST['zipinput'];
	$phone = $_POST['phoneinput'];

	//check if every thing has been filled.
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
	// check if databse has connected.
	if (!$connect){
		echo "Can't connect to the database!";
	}
	// insert the value to the userinfo table, which emailaddress is a primary key.
	$account_type = "P";
	$sql = "INSERT INTO logininfo (password,Username,account_type) VALUES(?,?,?)";
	$stmt = mysqli_prepare($connect, $sql);
	mysqli_stmt_bind_param($stmt,"sss",$f_pass, $email, $account_type);
	mysqli_stmt_execute($stmt);
	// if inserting user table successfully, then insert the logininfo table which username(emailaddress) is a primary key as well.
	if (mysqli_stmt_affected_rows($stmt) == 1){
		$sql = "INSERT INTO user (first_name, last_name, emailaddress, zip_code, phone) VALUES(?,?,?,?,?)";
		$stmt = mysqli_prepare($connect, $sql);
		mysqli_stmt_bind_param($stmt,"sssss",$f_name, $l_name, $email, $zipcode, $phone);
		mysqli_stmt_execute($stmt);
		//if inserting successfully, inform user and let him get back to login page to login.
		if (mysqli_stmt_affected_rows($stmt) == 1){
			echo 'You have successfully created your account!';
			echo '<a href = "..\homepage.html">' . "<p>Back to the login page";

		}

	}

	?>