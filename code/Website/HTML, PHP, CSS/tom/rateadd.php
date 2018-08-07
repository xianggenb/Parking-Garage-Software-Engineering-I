<!DOCTYPE html>
<html>
<head>
<style>
	label{display:inline-block;width:100px;margin-bottom:10px;}
</style>
<title>Add Rate</title>
</head>
<body>

 
<form method="post" action="rateadd.php">
<label>Rate Name</label>
<input type="text" name="ratename" />
<br />
<label>Active Period</label>
<input type="text" name="activeperiod" />
<br />
<label>Cost($)</label>
<input type="int" name="cost" /> 
<br />

<br />
<button type="submit" class="btn btn-default" name = "Submit">	
Submit
</button>
<br />
<br />
<a href="rates.php" type="button" class="btn btn-default" name = "Back">	
Back
</a>


<?php
if (isset($_POST['Submit'])){
$username = "root";
$password = "";
$hostname = "localhost";
$db = "Rates";

try {


//connection to the database
$link = mysqli_connect($hostname, $username, $password, $db);

$rate_name= $_POST['ratename'];
$active_period= $_POST['activeperiod'];
$cost= $_POST['cost'];

if (!$link){
	die("Connection Failed:".mysqli_connect_error());
}

// attempt insert query execution
$sql = "INSERT INTO rates (ratename, activeperiod, cost) VALUES ('$rate_name', '$active_period', '$cost')";
@mysqli_query($sql);
if(mysqli_query($link, $sql)){
    echo "Records added successfully.";
} else{
    echo "ERROR: Was not able to execute $sql. " . mysqli_error($link);
}

}catch(Exception $e){

echo $e;

}

 
// close connection
mysqli_close($link);
}
?>

</form>

</body>
</html>
