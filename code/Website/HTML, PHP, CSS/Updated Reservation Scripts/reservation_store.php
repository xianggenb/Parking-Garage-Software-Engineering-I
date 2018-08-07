<!doctype html>
<!-- Written/Tested/Debugged By: HARSHIL PATEL -->
<html>
<head>
<meta charset="utf-8">
<title>Regular Reservations</title>
<h1>Welcome to the Reservations Page!</h1>
<link href="reservation.css" rel="stylesheet">

</head>

<body>

<?php

	session_start();
	if (empty($_SESSION['Username']))
	{
		header('Location: error.php');
	}

//include("profile.php"):

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


<form method = "post" action = "reservation_store.php" id = "form">
<fieldset>
	<legend>Please fill in the following fields:</legend>
    
    Email Address: <input type="varchar" class = "form_control" name = "emailAddress" value="<?php echo $earow['emailaddress']; ?>" readonly required> <br> <br>
    
First Name: <input type="varchar" class = "form_control" name = "firstName" value="<?php echo $fnrow['first_name']; ?>" readonly required> <br> <br>
Last Name: <input type="varchar" class = "form_control" name = "lastName" value="<?php echo $lnrow['last_name']; ?>" readonly required> <br> <br>
Arrival Date and Time: <input type="timestamp" class = "form_control" name = "StartDateTime" required> <br> <br>
Departure Date and Time: <input type="timestamp" class = "form_control" name = "EndDateTime" required> <br> <br>
License Plate: <input type="varchar" class = "form_control" name = "LicensePlate" value="<?php echo $dvrow['default_vehicle']; ?>"required> <br> <br>
<input type="submit" value="Confirm"> </label> <label> <input type="Reset" >  </label>
<input type = "hidden" name = "confirmed" value = "true" />
<p> *Note: The format for Arrival and Departure fields must be: mm/dd/yyyy hh:mm </p> <br>
<p> To CANCEL a Reservation, please click <a href= "cancellation.php"> here</a> </p>
</fieldset>

</form>
</body>
</html>

<?php

// Database connection

$db_host = "localhost";
$db_username = "root";
$db_pass = "password";
$db_name = "reservationdb";

$conn = mysqli_connect("$db_host","$db_username","","$db_name") or die("MySQL Connection Failed");

if(!$conn)
{
	echo "no connection";
}

if (isset($_POST['confirmed']))
{
	if (isset($_POST['firstName']) && !is_numeric($_POST['firstName']))
	{
		$firstname = ($_POST['firstName']);
	}
	else
	{
		die( 'Please enter a first name' );
	}
	if (isset($_POST['lastName']) && !is_numeric($_POST['lastName']))
	{
		$lastname = ($_POST['lastName']);
	}
	else
	{
		die( 'Please enter a last name' );
	}
	
	if (isset($_POST['emailAddress']) && !is_numeric($_POST['emailAddress']))
	{
		$email = ($_POST['emailAddress']);
	}
	else
	{
		die( 'Please enter an email address' );
	}

	if (isset($_POST['LicensePlate']))
	{
		$licenseplate = ($_POST['LicensePlate']);
	}
	if (isset($_POST['StartDateTime']) && !is_numeric($_POST['StartDateTime']))
	{
		$sDateTime = ($_POST['StartDateTime']);
	}
	else
	{
		die( 'Please enter a valid Time Stamp <br> The correct format is: 00/00/0000 00:00 <br>' );
	}
	if (isset($_POST['EndDateTime']) && !is_numeric($_POST['EndDateTime']))
	{
		$eDateTime = ($_POST['EndDateTime']);
	}
	else
	{
		die( 'Please enter a valid Time Stamp <br> The correct format is: 00/00/0000 00:00 <br>' );
	}
	
	$sql = "INSERT INTO reservations (LP, ArrivalTime, DepartureTime, FirstName, LastName, EmailAddress) VALUES (?, ?, ?, ?, ?, ?)";
		
	$statement = mysqli_prepare($conn, $sql) or die('insert error');
	mysqli_stmt_bind_param($statement, 'ssssss', $licenseplate, $sDateTime, $eDateTime, $firstname, $lastname, $email);
	mysqli_stmt_execute($statement);
	
    $last_id = $conn->insert_id;
    echo "Your Confirmation Number is: " . $last_id;


$conn->close();

}


?>