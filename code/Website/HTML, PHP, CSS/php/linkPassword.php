<!DOCTYPE html>
<html>
	<head>
		<title>
			Link company
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

	$companyname = $_POST['companyname'];
	$LinkPassword1 = $_POST['userpassword1'];

    // Check if the username or password has been filled,
    // if not provide a link helps user to get back to login page. 
	if ((empty($companyname))){
		echo "<p>Please type in the Username";
		echo '<a href = "..\linkCompany.html">' . "<p>Back to the link";
	}
	else if ((empty($LinkPassword1))){
		echo "<p>Please type in the password";
		echo '<a href = "..\linkCompany.html">' . "<p>Back to the link";
	}
	else if (isset($companyname) and isset($LinkPassword1)){
		// check if connect to the databse.
		if (!$connect){
			echo "<p> Can't connect to the database!";
		}
		//find the matched username and password in databse.
		$sql = "SELECT * FROM company WHERE Company_name= '".$companyname."' AND link_password ='".$LinkPassword1."' LIMIT 1";
		$res = mysqli_query($connect,$sql);
		//if find the column which matches, head user to the profile page
		if (mysqli_affected_rows($connect) == 1){
			$query = "UPDATE user SET company = '".$companyname."' WHERE emailaddress = '".$_SESSION['Username']."'";
			$res = mysqli_query($connect,$query);
			if (mysqli_affected_rows($connect) == 1){
				header('Location: ..\profile.php');
			}
			else{
				header('Location: ..\profile.php');
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