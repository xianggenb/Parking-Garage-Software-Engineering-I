<!DOCTYPE html>
<html>
<head>
<style>
	label{display:inline-block;width:100px;margin-bottom:10px;}
</style>
<title>Delete Policy</title>
</head>
<body>
 
<form method="post" action="policydelete.php">
<label>Policy Number</label>
<input type="int" name="policynumber" />
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

if (!$link){
	die("Connection Failed:".mysqli_connect_error());
}
 
// attempt delete query execution
$sql = "DELETE FROM policies WHERE id=$policy_number ";
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