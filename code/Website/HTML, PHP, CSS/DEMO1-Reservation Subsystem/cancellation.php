<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Cancellation</title>
<link href="reservation.css" rel="stylesheet">
<h1>Cancellations</h1>
<h3> We are sorry you are unable to make it. </h3>
</head>
<body>

Please enter your Reservation Information: <br>
<form>
<br>
<label> Confirmation Number: <input type="varchar" class = "form_control" name = "ConfirmationNumber" > </label> <br> <br>
<label> First Name: <input type="varchar" class = "form_control" name = "FirstName" > </label> <br> <br>
<label> Last Name: <input type="varchar" class = "form_control" name = "LastName" > </label> <br> <br>
<label> <input type="submit" value="Cancel Reservation"> </label> <label> <input type="Reset" >  </label>
<input type = "hidden" name = "cancelled" value = "true" />
</form>

<?php

if (isset($_POST['cancelled']))
{
	if (isset($_POST['ConfirmationNumber']))
	{
		$cancellation = ($_POST['ConfirmationNumber']);
	}
	
	$sql2 = "DELETE FROM reservations WHERE ConfirmationNumber = $cancellation";
	$statement = mysqli_prepare($conn, $sql2) or die('delete error');
	mysqli_stmt_bind_param($statement, 's', $cancellation);
	mysqli_stmt_execute($statement);
}

?>
	

</body>
</html>
