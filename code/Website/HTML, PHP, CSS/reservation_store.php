<!doctype html>
<!-- Written/Tested/Debugged By: HARSHIL PATEL -->
<html>
<head>
<meta charset="utf-8">
<title>Reservation_Main</title>
<h1>Welcome to the Reservations Page!</h1>
<link href="reservation.css" rel="stylesheet">

<SCRIPT TYPE="text/javascript"> 



</SCRIPT>

</head>

<body>

<form method = "post" action = "reservation_store.php" id = "form">

<p> Please fill in the following fields: </p>
<fieldset>
<label> First Name: <input type="varchar" class = "form_control" name = "firstName" > </label> <br> <br>
<label> Last Name: <input type="varchar" class = "form_control" name = "lastName" > </label> <br> <br>
<label> Arrival Date and Time: <input type="timestamp" class = "form_control" name = "StartDateTime" > </label> <br> <br>
<label> Departure Date and Time: <input type="timestamp" class = "form_control" name = "EndDateTime" > </label> <br> <br>
<label> License Plate: <input type="varchar" class = "form_control" name = "LicensePlate" > </label> <br> <br>
<label> <input type="submit" value="Confirm"> </label> <label> <input type="Reset" >  </label>
<input type = "hidden" name = "confirmed" value = "true" />
<p> *Note: The format for Arrival and Departure fields must be: mm/dd/yyyy hh:mm:ss </p> <br>
<p> To CANCEL a Reservation, please click <a href= "cancellation.php">here</a> </p>
</fieldset>

</form>
</body>
</html>

<?php

// Database connection

$db_host = "localhost";
$db_username = "root";
$db_pass = "";
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
		die( 'Please enter a valid Time Stamp <br> The correct format is: 00/00/0000 00:00:00 <br>' );
	}
	if (isset($_POST['EndDateTime']) && !is_numeric($_POST['EndDateTime']))
	{
		$eDateTime = ($_POST['EndDateTime']);
	}
	else
	{
		die( 'Please enter a valid Time Stamp <br> The correct format is: 00/00/0000 00:00:00 <br>' );
	}
	
	// $sql = "INSERT INTO reservations (LP, ArrivalTime, DepartureTime, FirstName, LastName) VALUES (?, ?, ?, ?, ?)";
	
	// /* $err = mysqli_report(MYSQLI_REPORT_ALL);
	// echo '$err'; IMPORTANT ERROR CHECKING TOOL */
	
	// $statement = mysqli_prepare($conn, $sql) or die('insert error');
	// mysqli_stmt_bind_param($statement, 'sssss', $licenseplate, $sDateTime, $eDateTime, $firstname, $lastname) or die('Bind Param Failed');
	// mysqli_stmt_execute($statement) or die('Execute Failed');



	 if ($stmt = mysqli_prepare($conn, "INSERT INTO reservations (LP, ArrivalTime, DepartureTime, FirstName, LastName) VALUES (?, ?, ?, ?, ?)")) {

	 mysqli_stmt_bind_param($stmt,"sssss",$licenseplate, $sDateTime, $eDateTime, $firstname, $lastname);

	mysqli_stmt_execute($stmt);

	} //printf("Error: %s.\n", mysqli_stmt_error($stmt));



	// if( !(mysqli_query($conn, $sql)) )
	// {
	// 	die('could not insert in db');
	// }
	
	/*if ($conn->query($sql) === TRUE) 
	{*/
	
    $last_id = $conn->insert_id;
    echo "Your Confirmation Number is: " . $last_id;
	//} 
/*else 
{
    echo "Error: " . $sql . "<br>" . $conn->error;
}*/



$conn->close();

}


?>