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
				// Prevent user accesses this page without an account.
				if (empty($_SESSION['company_N'])){
					header('Location:error.php');
				}
				echo'<h1>Park-A-Lot<h1> <small> Welcome <small>' .$_SESSION['company_N'];

				?>
			</div>
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="businessrofile.php">Home</a>
				</li>
				<li>
					<a href="Settings.html">Settings</a>
				</li>
				<li>
					<a href="homepage.html">Logout</a>
				</li>
				<li>
					<a href="ResetPassword.php">Change Password</a>
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
						<img alt="Edit Payment method" src="user.png" height = 152 width = 190>
					</h3>
				</div>
			</div>


			<div class="row">
				<div class="col-md-4">
					<h3 class="text-center">
						Reservations
					</h3>
					<center> 
					<a href="newreservation.html" class="btn" type="button">Active Reservations</a> 
					<a href="newreservation.html" class="btn" type="button">New Reservation</a>
					</center>

				</div>
				<div class="col-md-4">
					<h3 class="text-center">
						Vehicles
					</h3>
					<center> 
					<a href="BusinessvehicleInfo.php" class="btn" type="button">Current Vehicles</a> 
					<a href="BusinessvehicleInfo.php" class="btn" type="button">New Vehicle</a>
					</center>

				</div>
				<div class="col-md-4">
					<h3 class="text-center">
						Company User
					</h3> 
					<center> 
					<a href="User_List.php" class="btn" type="button">Linked user</a> 
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