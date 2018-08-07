<!DOCTYPE html>
<html>
	<head>
		<title>
			Login
		</title>
	</head>
	<body>

	<?php
	session_start();
	$host = "localhost";
	$user = "root";
	$password = "12490824";
	$db = "accountmanagement";
	$connect = mysqli_connect($host,$user,$password,$db);

	$Username = $_POST['useremail'];
	$UserPassword = $_POST['userpassword'];


	if ((empty($Username))){
		echo "<p>Please type in the Username";
		echo '<a href = "..\homepage.html">' . "<p>Back to the login";
	}
	else if ((empty($UserPassword))){
		echo "<p>Please type in the password";
		echo '<a href = "..\homepage.html">' . "<p>Back to the login";
	}
	else if (isset($Username) and isset($UserPassword)){
		if (!$connect){
			echo "<p> Can't connect to the database!";
		}
		$sql = "SELECT * FROM logininfo WHERE Username= '".$Username."' AND password ='".$UserPassword."' LIMIT 1";
		$res = mysqli_query($connect,$sql);
		if (mysqli_affected_rows($connect) == 1){
			$sql = "SELECT first_name FROM user WHERE emailaddress= '".$Username."'LIMIT 1";
			$response = @mysqli_query($connect,$sql);
			if ($response){
				$row = mysqli_fetch_array($response);
			}
			$_SESSION['Username'] = $Username;
			$_SESSION['fname'] = $row['first_name'];
			header('Location:..\profile.php');
		}
		else{
			echo "Your username or password is wrong, please retype it!";
			echo '<a href = "..\homepage.html">' . "<p>Back to the login"; 
		}
		mysqli_close($connect);	
	}	
	?>  

	</body>
</html>