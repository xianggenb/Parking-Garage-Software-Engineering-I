<!DOCTYPE html>
<html>
<head>
<style>
	label{display:inline-block;width:100px;margin-bottom:10px;}
</style>
<title>Delete Special</title>
</head>
<body>
 
<form method="post" action="specialsdelete.php">
<label>Special Name</label>
<input type="text" name="specialname" />
<br />
<br />
<button type="submit" class="btn btn-default" name = "Submit">	
Submit
</button>
<br />
<br />
<a href="specials.php" type="button" class="btn btn-default" name = "Back">	
Back
</a>

<?php
if (isset($_POST['Submit'])){
$username = "root";
$password = "";
$hostname = "localhost";
$db = "Specials";

//connection to the database
$link = mysqli_connect($hostname, $username, $password, $db);

$special_name= $_POST['specialname'];

if (!$link){
	die("Connection Failed:".mysqli_connect_error());
}
 
// attempt delete query execution
$sql = "DELETE FROM specials WHERE specialname='$special_name' ";
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