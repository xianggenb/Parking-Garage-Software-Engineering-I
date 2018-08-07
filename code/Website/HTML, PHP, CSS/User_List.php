<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"/>
		<link href="bootstrap.min.css" rel="stylesheet">
		<title>Payment</title>
		<meta name = "author" content = "Yufeng Liu"/>
	</head>

  	<body>
  	<form action = "" method ="post">
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="page-header">
				<h1>
					Park-A-Lot <small>User List</small>
				</h1>
				<a href="businessprofile.php" class="btn btn-info" role="button">Home</a>
			</div>
			<div class="row">
				<div class="col-md-4">
					
					<h3>
						<center>Current Linked User</center>
					</h3>
					<br>
					<?php
					session_start();
					// prevent user access without the account.
					if (empty($_SESSION['company_N'])){
					  header('Location:error.php');
				    }
					$host = "localhost";
					$user = "root";
					$password = "";
					$db = "accountmanagement";
					$connect = mysqli_connect($host,$user,$password,$db);

					//find the payment method which relates to the username. 
					$query = "SELECT first_name, last_name, emailaddress, company FROM user WHERE company = '".$_SESSION['company_N']."'";
					$res = mysqli_query($connect,$query);


					// if can't any payment method which relate to the user
					// ehco following messages.
					if (mysqli_affected_rows($connect) == 0){
						echo "<center>There isn't any users have linked to you!";
					}
					else{
						// get the columns of payment method and print them out 
						while($row = mysqli_fetch_array($res)){
							$query_deny = "SELECT * FROM deny_list WHERE company = '".$row['company']."' AND emailaddress ='".$row['emailaddress']."' LIMIT 1";
							$res_deny = mysqli_query($connect,$query_deny);
							if(mysqli_affected_rows($connect) == 1){
								echo '<center> <input type="radio" name="user"'. "value = ".$row['emailaddress'].">";
								echo $row['first_name']." ".$row['last_name'].":[".$row['emailaddress']."](DENIED)</label><br />";
							}
							else{
								echo '<center> <input type="radio" name="user"'. "value = ".$row['emailaddress'].">";
								echo $row['first_name']." ".$row['last_name'].":[".$row['emailaddress']."]</label><br />";
							}
						}
					}
					?>

					<center>
					<br>
					<div class="btn-group">
						<button class="btn btn-default" type="submit" name = "deny">
							Put to the deny list
						</button> 
						<button class="btn btn-default" type="submit" name = "right">
							Authorize the right
						</button>
						<?php
						// if click on the set defualt, this informaiton will be setted as default_payment under table user
						// and refresh the page
						if(isset($_POST['deny'])){
							if(isset($_POST['user'])){
							$sql = "INSERT INTO deny_list (emailaddress,company) VALUES(?,?)";
							$stmt = mysqli_prepare($connect, $sql);
							mysqli_stmt_bind_param($stmt,"ss",$_POST['user'], $_SESSION['company_N']);
							mysqli_stmt_execute($stmt);
								if (mysqli_affected_rows($connect) == 1){
									header('Location: User_List.php');
								}
							}
						}
						// if click on the delete, this informaiton will be deleted under table payment
						// and refresh the page
						if(isset($_POST['right'])){
							if(isset($_POST['user'])){
								$query = "DELETE FROM deny_list WHERE emailaddress = '".$_POST['user']."' AND company = '".$_SESSION['company_N']."'";
								$res = mysqli_query($connect,$query);
								if (mysqli_affected_rows($connect) == 1){
									header('Location: User_List.php');
								}
							}
						}

						?>
					</div>	
					</div>
					</center>
				</div>
						<?php
						if (isset($_POST['Submit'])){

							$user_name= $_POST['nameinput'];
							$user_number= $_POST['cardnumberinput'];
							$user_date = $_POST['dateinput'];
							$user_code = $_POST['securityinput'];

								if (empty($user_name)){
									echo "<p>Please type in the name.";
								}
								else if (empty($user_number)){
									echo "<p>Please type in the card number.";
								}
								else if (empty($user_date)){
									echo "<p>Please type in the expiration date.";
								}
								else if (empty($user_code)){
									echo "<p>Please type in the security code.";
								}
								else if (!$connect){
									echo "Can't connect to the database!";
								}
								else{
									$sql = "INSERT INTO payment (Name_On_Card, Expiration_Date, Security_Code, Username, Card_Number) VALUES(?,?,?,?,?)";
									$stmt = mysqli_prepare($connect, $sql);
									mysqli_stmt_bind_param($stmt,"ssiss",$user_name, $user_date, $user_code, $_SESSION['Username'], $user_number);
									mysqli_stmt_execute($stmt);
									if (mysqli_stmt_affected_rows($stmt) == 1){
										echo "You have submited your payment informaion successfully!";
										header('Location: PaymentMethod.php');
									}
									else{
										echo '<p>'.mysqli_error($connect);
									}
								}
							}
						?>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
	</form>
  </body>
</html>