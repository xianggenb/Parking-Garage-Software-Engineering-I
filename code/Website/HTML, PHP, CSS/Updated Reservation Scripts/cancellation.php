<!doctype html>
<!-- Written/Tested/Debugged By: HARSHIL PATEL -->
<html>
<head>
<meta charset="utf-8">
<title>Cancellation</title>
<link href="reservation.css" rel="stylesheet">
<h1>Cancellations</h1>
<h3> We are sorry you are unable to make it. </h3>
</head>
<body>

<?php
session_start();
//include("profile.php")

// Database connection

$db_host = "localhost";
$db_username = "root";
$db_pass = "";
$db_name = "reservationdb";

// Connect to your database
$pdo = new PDO("mysql:host=$db_host;dbname=$db_name", $db_username, $db_pass);
$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

//can only make reservation under your name only after you login with $Username and the password
$Username = $_SESSION['Username'];

$fnamestmt = $pdo->prepare("SELECT first_name FROM user WHERE emailaddress=?");
$fnamestmt->execute(array($Username));
$fnrow = $fnamestmt->fetch(PDO::FETCH_ASSOC);

$lnamestmt = $pdo->prepare("SELECT last_name FROM user WHERE emailaddress=?");
$lnamestmt->execute(array($Username));
$lnrow = $lnamestmt->fetch(PDO::FETCH_ASSOC);

$eastmt = $pdo->prepare("SELECT emailaddress FROM user WHERE emailaddress=?");
$eastmt->execute(array($Username));
$earow = $eastmt->fetch(PDO::FETCH_ASSOC);

$dvstmt = $pdo->prepare("SELECT default_vehicle FROM user WHERE emailaddress=?");
$dvstmt->execute(array($Username));
$dvrow = $dvstmt->fetch(PDO::FETCH_ASSOC);

?>

<p> Please enter your Reservation Information: </p>
<form method = "post" action = "cancellation.php" id = "form">
<fieldset>
Confirmation Number: <input type="varchar" class = "form_control" name = "confirmationnumber" > <br> <br>
Email Address: <input type="varchar" class = "form_control" name = "emailAddress" value="<?php echo $earow['emailaddress']; ?>" readonly required> <br> <br>
First Name: <input type="varchar" class = "form_control" name = "FirstName" value="<?php echo $fnrow['first_name']; ?>" readonly required> <br> <br>
Last Name: <input type="varchar" class = "form_control" name = "LastName" value="<?php echo $lnrow['last_name']; ?>" readonly required> <br> <br>
<input type="submit" value="Submit">
  <input type = "hidden" name = "submitted" value = "true" />
</fieldset>
</form>

</body>
</html>

<?php

if(isset($_POST['submitted']))
{
	
 $confirmation = $_POST['confirmationnumber'];
 
if (strpos($confirmation, 'R') !== false) 
{
	preg_match_all('!\d+!', $confirmation, $matches);
	$cnstmt = $pdo->prepare("DELETE FROM recurring WHERE ConfirmationNumber=?");
	$cnstmt->execute(array($matches));
	$cnrow = $cnstmt->fetch(PDO::FETCH_ASSOC);
}

else if (strpos($confirmation, 'B') !== false) 
{
	preg_match_all('!\d+!', $confirmation, $matches);
	$cnstmt = $pdo->prepare("DELETE FROM business WHERE ConfirmationNumber=?");
	$cnstmt->execute(array($matches));
	$cnrow = $cnstmt->fetch(PDO::FETCH_ASSOC);
}

 else
{
	preg_match_all('!\d+!', $confirmation, $matches);
	$cnstmt = $pdo->prepare("DELETE FROM reservations WHERE ConfirmationNumber=?");
	$cnstmt->execute(array($matches));
	$cnrow = $cnstmt->fetch(PDO::FETCH_ASSOC);
}

 echo "data deleted successfully";
 
}



?>