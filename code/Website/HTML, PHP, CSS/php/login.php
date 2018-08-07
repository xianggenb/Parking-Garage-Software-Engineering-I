<!DOCTYPE html>
<html>
	<head>
		<title>
			Login
		</title>
	</head>
	<body>

	<?php
	// Connect to the database
	session_start();
	$host = "localhost";
	$user = "root";
	$password = "";
	$db = "accountmanagement";
	$connect = mysqli_connect($host,$user,$password,$db);

	$Username = $_POST['useremail'];
	$UserPassword = $_POST['userpassword'];

    // Check if the username or password has been filled,
    // if not provide a link helps user to get back to login page. 
	if ((empty($Username))){
		echo "<p>Please type in the Username";
		echo '<a href = "..\homepage.html">' . "<p>Back to the login";
	}
	else if ((empty($UserPassword))){
		echo "<p>Please type in the password";
		echo '<a href = "..\homepage.html">' . "<p>Back to the login";
	}
	else if (isset($Username) and isset($UserPassword)){
		// check if connect to the databse.
		if (!$connect){
			echo "<p> Can't connect to the database!";
		}
		//find the matched username and password in databse.
		$sql = "SELECT * FROM logininfo WHERE Username= '".$Username."' AND password ='".$UserPassword."' LIMIT 1";
		$res = mysqli_query($connect,$sql);
		//if find the column which matches, head user to the profile page
		if (mysqli_affected_rows($connect) == 1){
			$sql = "SELECT first_name FROM user WHERE emailaddress= '".$Username."'LIMIT 1";
			$response = @mysqli_query($connect,$sql);
			if (mysqli_affected_rows($connect) == 1){
				$row = mysqli_fetch_array($response);
				$_SESSION['Username'] = $Username;
				$_SESSION['fname'] = $row['first_name'];
				$_SESSION['Company_N'] = $row['company'];
				header('Location:..\profile.php');
			}
			else{
				$sql = "SELECT Company_name FROM company WHERE email= '".$Username."' LIMIT 1";
				$response2 = @mysqli_query($connect, $sql);
				if ($response2){
					$row2 = mysqli_fetch_array($response2);
					$_SESSION['company_N'] = $row2['Company_name'];
					$_SESSION['Username'] = $Username;
					header('Location:..\businessprofile.php');
				}
			}
		}
		// if can't find the matched column, provide a link let user get back to the login page.
		else{
			echo "Your username or password is wrong, please retype it!";
			echo '<a href = "..\homepage.html">' . "<p>Back to the login"; 
		}
		mysqli_close($connect);	
	}	
	?>  

	</body>
</html>