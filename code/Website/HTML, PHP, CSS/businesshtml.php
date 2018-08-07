<!doctype html>

<!-- Written/Tested/Debugged By: HARSHIL PATEL -->
<html>
<head>
<meta charset="utf-8">
<title>Business Reservations</title>
<h1> Reservations for your Company</h1>
<link href="reservation.css" rel="stylesheet">
</head>
<body>

<?php

$db_host = "localhost";
$db_username = "root";
$db_pass = "";
$db_name = "reservationdb";

// Connect to your database
$pdo = new PDO("mysql:host=$db_host;dbname=$db_name", $db_username, $db_pass);
$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

// Write out our query.
$fnquery = "SELECT first_name FROM user";

// Execute it, or let it throw an error message if there's a problem.
$fnstmt = $pdo->query( $fnquery );

// Write out our query.
$lnquery = "SELECT last_name FROM user";

// Execute it, or let it throw an error message if there's a problem.
$lnstmt = $pdo->query( $lnquery );

// Write out our query.
$lpquery = "SELECT LP FROM user";

// Execute it, or let it throw an error message if there's a problem.
$lpstmt = $pdo->query( $lpquery );

// Write out our query.
$cmquery = "SELECT company FROM user";

// Execute it, or let it throw an error message if there's a problem.
$cmstmt = $pdo->query( $cmquery );

?>

<form action="businesshtml.php" method="post" id="business" target= "businesshtml.php">

<fieldset>
	<legend> Information: </legend>
    
  First Name: <br>
  <?php
   $fndropdown = "<select name=firstname>";
foreach ($fnstmt as $fnrow) {
  $fndropdown .= "\r\n<option value='{$fnrow['first_name']}'>{$fnrow['first_name']}</option>";
}
$fndropdown .= "\r\n</select>";
echo $fndropdown;
?>

    <br><br>
    
    Last Name: <br>
  
 <?php
   $lndropdown = "<select name=lastname>";
foreach ($lnstmt as $lnrow) {
  $lndropdown .= "\r\n<option value='{$lnrow['last_name']}'>{$lnrow['last_name']}</option>";
}
$lndropdown .= "\r\n</select>";
echo $lndropdown;
?>

<br><br>
    
    License Plate:<br>
    
   <?php
   $lpdropdown = "<select name=licenseplate>";
foreach ($lpstmt as $lprow) {
  $lpdropdown .= "\r\n<option value='{$lprow['LP']}'>{$lprow['LP']}</option>";
}
$lpdropdown .= "\r\n</select>";
echo $lpdropdown;
?>

    <br><br>
    
    Start Date:<br>
    <input type="date" name="dates" required>
    
    <br><br>
    
    End Date:<br>
    <input type="date" name="datee" required>
    
    <br><br>
   Start Time:<br>
   <input type="text" name="starttime" pattern="([01]?[0-9]{1}|2[0-3]{1}):[0|3]{1}[0]{1}" id="24hs" required/> 24h-format
 <br> <br>
   End Time:<br>
  <input type="text" name="endtime" pattern="([01]?[0-9]{1}|2[0-3]{1}):[0|3]{1}[0]{1}" id="24he" required/> 24h-format
  <br> <br>
  
  Company Name: <br>
  
  <?php
   $cmdropdown = "<select name=company>";
foreach ($cmstmt as $cmrow) {
  $cmdropdown .= "\r\n<option value='{$cmrow['company']}'>{$cmrow['company']}</option>";
}
$cmdropdown .= "\r\n</select>";
echo $cmdropdown;
?>
  
  <br> <br>
  
  <input type="submit" value="Submit" onclick="alert('Your Reservation is being processed')">
  <input type = "hidden" name = "submitted" value = "true" />
  <br><br>
  *Note: Reservations can only be made in 30 Minute Intervals
  </fieldset>
  
</form> 


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
	
	if (isset($_POST['dates']) && !is_numeric($_POST['dates']))
	{
		$sDate = ($_POST['dates']);
	}
	else
	{
		die( 'Please enter a date' );
	}
	
	if (isset($_POST['datee']) && !is_numeric($_POST['datee']))
	{
		$eDate = ($_POST['datee']);
	}
	else
	{
		die( 'Please enter a date' );
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
	
	if (isset($_POST['company']) && !is_numeric($_POST['company']))
	{
		$company = ($_POST['company']);
	}
	else
	{
		die( 'Please select a company' );
	}
	
	$sql = "INSERT INTO business (FirstName, LastName, CompanyName, LP, StartDate, EndDate, StartTime, EndTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	$statement = mysqli_prepare($conn, $sql) or die('insert error');
	mysqli_stmt_bind_param($statement, 'ssssssss', $firstname, $lastname, $company, $licenseplate, $sDate, $eDate, $sTime, $eTime);
	mysqli_stmt_execute($statement);

    $last_id = $conn->insert_id;
    echo "Your Confirmation Number is: " . $last_id; echo "B";
	echo "\r\n";
	echo "Thank you for reserving!";

$conn->close();


}

?>

</body>
</html>
