<!doctype html>
<!-- Written/Tested/Debugged By: HARSHIL PATEL -->
<html>
<head>
<meta charset="utf-8">
<title>Recurring Reservations</title>
<h1> Here you can subsribe to our program! </h1>
<link href="reservation.css" rel="stylesheet">
</head>
<body>


<?php
session_start();
//include("profile.php");

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
//echo $fnrow['first_name'];

$lnamestmt = $pdo->prepare("SELECT last_name FROM user WHERE emailaddress=?");
$lnamestmt->execute(array($Username));
$lnrow = $lnamestmt->fetch(PDO::FETCH_ASSOC);
//echo $fnrow['first_name'];

$eastmt = $pdo->prepare("SELECT emailaddress FROM user WHERE emailaddress=?");
$eastmt->execute(array($Username));
$earow = $eastmt->fetch(PDO::FETCH_ASSOC);
//echo $fnrow['first_name'];

$dvstmt = $pdo->prepare("SELECT default_vehicle FROM user WHERE emailaddress=?");
$dvstmt->execute(array($Username));
$dvrow = $dvstmt->fetch(PDO::FETCH_ASSOC);

?>




<form  method="post" action="recurring.php" id="subscriptions" >

<fieldset>
	<legend> Information: </legend>
    
    Email Address: <br>
    <input type="text" name = "emailAddress" value="<?php echo $earow['emailaddress']; ?>" readonly required> 
    <br> <br>
    
    First Name:<br>
    <input type="text" name="firstname" value="<?php echo $fnrow['first_name']; ?>" readonly required>
    <br><br>
    Last Name:<br>
    <input type="text" name="lastname" value="<?php echo $lnrow['last_name']; ?>" readonly required>
    <br><br>
    License Plate:<br>
    <input type="text" name="licenseplate" value="<?php echo $dvrow['default_vehicle']; ?>"required>
    
    <br><br>
   Start Time:<br>
   <input type="text" name="starttime" pattern="([01]?[0-9]{1}|2[0-3]{1}):[0|3]{1}[0]{1}" id="24hs" required/> 24h-format
 <br> <br>
   End Time:<br>
  <input type="text" name="endtime" pattern="([01]?[0-9]{1}|2[0-3]{1}):[0|3]{1}[0]{1}" id="24he" required/> 24h-format
  <br> <br>
  
  Subscription Type: <br>
  
  <input type="radio" name="restype" value="daily" checked> Daily<br>
   <input type="radio" name="restype" value="weeklyMon"> Weekly - Monday<br>
   <input type="radio" name="restype" value="weeklyTue"> Weekly - Tuesday<br>
   <input type="radio" name="restype" value="weeklyWed"> Weekly - Wednesday<br>
   <input type="radio" name="restype" value="weeklyThu"> Weekly - Thursday<br>
   <input type="radio" name="restype" value="weeklyFri"> Weekly - Friday<br>
   <input type="radio" name="restype" value="weeklySat"> Weekly - Saturday<br>
   <input type="radio" name="restype" value="weeklySun"> Weekly - Sunday<br>
  <!--<input type="radio" name="restype" value="monthly"> Monthly -->
  
  <br> <br>
  
  <input type="submit" value="Submit">
  <input type = "hidden" name = "submitted" value = "true" />
  <br><br>
  *Note: Reservations can only be made in 30 Minute Intervals
  
  <p> To CANCEL a Reservation, please click <a href= "cancellation.php"> here</a> </p>
  </fieldset>
  
</form> <script type="text/javascript"> 

var subForm = document.forms["subscriptions"];
var subPrices = new Array();
subPrices["daily"] = 10;
subPrices["weekly"] = 8;
subPrices["monthly"] = 6;

function getSubtypePrice()
{
	var subTypePrice = 0;
	var subForm = document.forms["subscriptions"];
	var selectedSub = subForm.elements["restype"];
	
	for(var i = 0; i < selectedSub.length; i++)
	{
		if(selectedSub[i].checked)
		{
			subTypePrice = subPrices[selectedSub[i].value];
			break;
		}
	}
	return subTypePrice;
}

var startTime = document.getElementsByName("starttime")[0].value;
var endTime = document.getElementsByName("endtime")[0].value;

var strStart = startTime.split(":");
var strEnd = endTime.split(":");

document.write(startTime);

</script>




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