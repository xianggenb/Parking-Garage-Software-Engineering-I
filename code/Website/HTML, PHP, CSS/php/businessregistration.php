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
	$name = $_POST['nameinput'];
	$email = $_POST['emailinput'];
	$address = $_POST['addressinput'];
	$state = $_POST['stateinput'];
	$f_pass = $_POST['Password1'];
	$s_pass = $_POST['Password2'];
	$f_lpass = $_POST['LPassword1'];
	$s_lpass = $_POST['LPassword2'];
	$zipcode = $_POST['zipinput'];
	$phone = $_POST['phoneinput'];

	//check if every thing has been filled.
	if (empty($name)){
		echo "<p>Please type in the company name";
		echo '<a href = "..\BusinessRegisteration.html">' . "<p>Back to the Previous page";
	}
	else if (empty($email)){
		echo "<p>Please type in the email address";
		echo '<a href = "..\BusinessRegisteration.html">' . "<p>Back to the Previous page";
	}
	else if (empty($address)){
		echo "<p>Please type in the company address";
		echo '<a href = "..\BusinessRegisteration.html">' . "<p>Back to the Previous page";
	}
	else if (empty($state)){
		echo "<p>Please type in the state name";
		echo '<a href = "..\BusinessRegisteration.html">' . "<p>Back to the Previous page";
	}
	else if (empty($zipcode)){
		echo "<p>Please type in the zip code";
		echo '<a href = "..\BusinessRegisteration.html">' . "<p>Back to the Previous page";
	}
	else if (empty($phone)){
		echo "<p>Please type in the company phone number";
		echo '<a href = "..\BusinessRegisteration.html">' . "<p>Back to the Previous page";
	}
	else if (empty($f_pass) or empty($s_pass)){
		echo "<p>Please make sure you type in the password twice";
		echo '<a href = "..\BusinessRegisteration.html">' . "<p>Back to the Previous page";
	}
	else if ($f_pass != $s_pass){
		echo "<p>Please make sure the password you type in are the same";
		echo '<a href = "..\BusinessRegisteration.html">' . "<p>Back to the Previous page";
	}
	else if (empty($f_lpass) or empty($s_lpass)){
		echo "<p>Please make sure you type in the password twice";
		echo '<a href = "..\BusinessRegisteration.html">' . "<p>Back to the Previous page";
	}
	else if ($f_lpass != $s_lpass){
		echo "<p>Please make sure the password you type in are the same";
		echo '<a href = "..\BusinessRegisteration.html">' . "<p>Back to the Previous page";
	}
	// check if databse has connected.
	else if (!$connect){
		echo "Can't connect to the database!";
	}
	// insert the value to the userinfo table, which emailaddress is a primary key.
	else{
		$account_type = "B";
		$sql = "INSERT INTO company (Company_name, email, address, state, zipcode, phone, link_password) VALUES(?,?,?,?,?,?,?)";
		$stmt = mysqli_prepare($connect, $sql);
		mysqli_stmt_bind_param($stmt,"sssssss",$name, $email, $address, $state, $zipcode, $phone, $f_lpass);
		mysqli_stmt_execute($stmt);
		// if inserting user table successfully, then insert the logininfo table which username(emailaddress) is a primary key as well.
		if (mysqli_stmt_affected_rows($stmt) == 1){
			$sql = "INSERT INTO logininfo (password,Username,account_type) VALUES(?,?,?)";
			$stmt = mysqli_prepare($connect, $sql);
			mysqli_stmt_bind_param($stmt,"sss",$f_pass, $email, $account_type);
			mysqli_stmt_execute($stmt);
			if (mysqli_stmt_affected_rows($stmt) == 1){
				echo 'You have successfully created your account!';
				echo '<a href = "..\homepage.html">' . "<p>Back to the login page";
			}
			else{
				echo "<p>".mysqli_error($connect);
			}
		}
		else{
			echo "<p>".mysqli_error($connect);
		}
	}
	?>