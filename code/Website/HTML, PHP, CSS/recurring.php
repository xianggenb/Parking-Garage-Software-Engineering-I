<?php

// Written/Tested/Debugged By: HARSHIL PATEL 

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

if (isset($_POST['submitted']))
{
	if (isset($_POST['firstname']) && !is_numeric($_POST['firstname']))
	{
		$firstname = ($_POST['firstname']);
	}
	else
	{
		die( 'Please enter a first name' );
	}
	if (isset($_POST['lastname']) && !is_numeric($_POST['lastname']))
	{
		$lastname = ($_POST['lastname']);
	}
	else
	{
		die( 'Please enter a last name' );
	}

	if (isset($_POST['licenseplate']))
	{
		$licenseplate = ($_POST['licenseplate']);
	}
	
	if (isset($_POST['starttime']) && !is_numeric($_POST['starttime']))
	{
		$sTime = ($_POST['starttime']);
	}
	else
	{
		die( 'Please enter a valid Time <br> The correct format is: 00:00 <br>' );
	}
	if (isset($_POST['endtime']) && !is_numeric($_POST['endtime']))
	{
		$eTime = ($_POST['endtime']);
	}
	else
	{
		die( 'Please enter a valid Time <br> The correct format is: 00:00 <br>' );
	}
	
	if (isset($_POST['restype']) && !is_numeric($_POST['restype']))
	{
		$subType = ($_POST['restype']);
	}
	else
	{
		die( 'Please select a reservation type' );
	}
	
	$sql = "INSERT INTO recurring (LP, FirstName, LastName, SubscriptionStartTime, SubscriptionEndTime, SubscriptionType) VALUES (?, ?, ?, ?, ?, ?)";
	
	$statement = mysqli_prepare($conn, $sql) or die('insert error');
	mysqli_stmt_bind_param($statement, 'ssssss', $licenseplate, $firstname, $lastname, $sTime, $eTime, $subType);
	mysqli_stmt_execute($statement);

    $last_id = $conn->insert_id;
    echo "Your Confirmation Number is: " . $last_id; echo "R";
	echo "\r\n";
	echo "Thank you for subscribing!";

$conn->close();


}


?>