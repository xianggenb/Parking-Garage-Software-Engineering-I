<!DOCTYPE html>
<html>
<head>
<style>
	label{display:inline-block;width:100px;margin-bottom:10px;}
</style>
<title>Add Policy</title>
</head>
<body>
 
<form method="post" action="policyadd.php">
<label>Policy Number</label>
<input type="int" name="policynumber" />
<br />
<label>Policy</label>
<input type="text" name="policy" />
<br />

<br />
<button type="submit" class="btn btn-default" name = "Submit">	
Submit
</button>
<br />
<br />
<a href="Policy_Decision.php" type="button" class="btn btn-default" name = "Back">	
Back
</a>

<?php
if (isset($_POST['Submit'])){
$username = "root";
$password = "root";
$hostname = "localhost";
$db = "Policies";

//connection to the database
$link = mysqli_connect($hostname, $username, $password, $db);

$policy_number= $_POST['policynumber'];
$policy= $_POST['policy'];

if (!$link){
	die("Connection Failed:".mysqli_connect_error());
}
 
// attempt insert query execution
$sql = "INSERT INTO policies (id, policy) VALUES ('$policy_number', '$policy')";
mysqli_query($sql);
if(mysqli_query($link, $sql)){
    echo "Records added successfully.";
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