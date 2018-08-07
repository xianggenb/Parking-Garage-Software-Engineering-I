<!DOCTYPE html>
<html>
<head>
<style>
	label{display:inline-block;width:100px;margin-bottom:10px;}
</style>
<title>Delete Rate</title>
</head>
<body>
 
<form method="post" action="ratedelete.php">
<label>Rate Name</label>
<input type="text" name="ratename" />
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

//connection to the database
$link = mysqli_connect($hostname, $username, $password, $db);

$rate_name= $_POST['ratename'];

if (!$link){
	die("Connection Failed:".mysqli_connect_error());
}
 
// attempt delete query execution
$sql = "DELETE FROM rates WHERE ratename='$rate_name' ";
mysqli_query($sql);
if(mysqli_query($link, $sql)){
    echo "Records deleted successfully.";
} else{
    echo "ERROR: Was not able to execute $sql. " . mysqli_error($link);
}
 
// close connection
mysqli_close($link);
}
?>
</form>

</body>
</html>