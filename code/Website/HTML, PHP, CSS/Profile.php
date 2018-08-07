<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"/>
		<link href="bootstrap.min.css" rel="stylesheet">
		<title>Profile</title>
		<meta name = "author" content = "Yufeng Liu"/>
	</head>

 <body>

    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="page-header">
				<?php
				session_start();
				$host = "localhost";
				$user = "root";
				$password = "";
				$db = "accountmanagement";
				$connect = mysqli_connect($host,$user,$password,$db);
				// Prevent user accesses this page without an account.
				if (empty($_SESSION['fname'])){
					header('Location:error.php');
				}
				$sql = "SELECT company FROM user WHERE emailaddress= '".$_SESSION['Username']."'LIMIT 1";
				$response = @mysqli_query($connect,$sql);
				if (mysqli_affected_rows($connect) == 1){
					$row = mysqli_fetch_array($response);
					$_SESSION['Company_N'] = $row['company'];
				}
				if (isset($row['company'])){
					echo'<h1>Park-A-Lot<h1> <small> Welcome <small>' .$_SESSION['fname']."(".$_SESSION['Company_N'].")";
				}
				else{
					echo'<h1>Park-A-Lot<h1> <small> Welcome <small>' .$_SESSION['fname'];
				}

				?>
			</div>
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="Profile.php">Home</a>
				</li>
				<li>
					<a href="Settings.html">Settings</a>
				</li>
				<li>
					<a href="ProfileEditting.html">Profile</a>
				</li>
				<li>
					<a href="homepage.html">Logout</a>
				</li>
				<li>
					<a href="ResetPassword.php">Change Password</a>
				</li>	
				<li>
					<a href="linkCompany.html">Link your account to your company</a>
				</li>			
			</ul>

			<div class="row">
				<div class="col-md-4">
					<h3 class="text-center">
						<img alt="make a reservation" src="make_a_reservation.png" height = 150 width = 200>
					</h3>
				</div>
				<div class="col-md-4">
					<h3 class="text-center">
						<img alt="Edit Vehicle Info" src="VehicleInfo.png" height = 152 width = 300>
					</h3>
				</div>
				<div class="col-md-4">
					<h3 class="text-center">
						<img alt="Edit Payment method" src="payment.jpg" height = 152 width = 190>
					</h3>
				</div>
			</div>


			<div class="row">
				<div class="col-md-4">
					<h3 class="text-center">
						Reservations
					</h3>
					<center> 
					<a href="reservation_store.php" class="btn" type="button">Active Reservations</a> 
					<a href="reservation_store.php" class="btn" type="button">New Reservation</a>
					</center>

				</div>
				<div class="col-md-4">
					<h3 class="text-center">
						Vehicles
					</h3>
					<center> 
					<a href="vehicleInfo.php" class="btn" type="button">Current Vehicles</a> 
					<a href="vehicleInfo.php" class="btn" type="button">New Vehicle</a>
					</center>

				</div>
				<div class="col-md-4">
					<h3 class="text-center">
						Payment
					</h3> 
					<center>
					<a href="PaymentMethod.php" class="btn" type="button">Current Payment Methods</a> 
					<a href="PaymentMethod.php" class="btn" type="button">New Payment Methods</a>
					</center>

				</div>
			</div>





			<div class="row">
				<div class="col-md-12">
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<center>
					<a href="#"><img alt="Special" class="img-circle" src="specialoffers.png" height = 400 width = 800></a>
					</center>
				</div>
			</div>



			

		</div>
	</div>
</div>
  </body>
</html>