<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"/>
		<link href="bootstrap.min.css" rel="stylesheet">
		<title>Vehicle</title>
		<meta name = "author" content = "Yufeng Liu"/>
	</head>
 	<body>
 	<form action="" method="post">
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="page-header">
				<h1>
					Park-A-Lot <small>Vehicle Management</small>
				</h1>
				<a href="businessprofile.php" class="btn btn-info" role="button">Home</a>
			</div>
			<div class="row">
				<div class="col-md-4">
					
					<h3>
						<center>Registered Vehicles</center>
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
					//find the vehicle which relates to the username. ;
					$query = "SELECT Make, Model, year, License_Plate_Number FROM vehicle WHERE Username = '".$_SESSION['company_N']."'";
					$res = mysqli_query($connect,$query);
					// if can't find any vehicles which relate to the user
					// ehco following messages.
					if (mysqli_affected_rows($connect) == 0){
						echo "<center>You haven't added any vehicles yet.";
					}
					// get the columns of vehicle and print them out 
					else{
						while($row = mysqli_fetch_array($res)){
							// if the column found is default one, it will have "(default)" after the informaiton
							echo '<center> <input type="radio" name="vehicle"'. "value = ".$row['License_Plate_Number'].">";
							echo $row['Make']." ".$row['Model']."-".$row['year']." : ".$row['License_Plate_Number']."</label><br />";
						}
					}
					?>
					<center>
					<br>
					<div class="btn-group">
						<button class="btn btn-default" type="submit" name = "delete">
							Delete Selected
						</button> 
						<?php
						// if click on the delete, this informaiton will be deleted under table payment
						// and refresh the page
						if(isset($_POST['delete'])){
							if(isset($_POST['vehicle'])){
								$query = "DELETE FROM vehicle WHERE License_Plate_Number = '".$_POST['vehicle']."'";
								$res = mysqli_query($connect,$query);
								if (mysqli_affected_rows($connect) == 1){
								header('Location: BusinessvehicleInfo.php');
								}
							}
						}
						?>
					</div>
					</center>
				</div>
				<div class="col-md-7">
					<h3>
						Add New Vehicle
					</h3>
					<form role="form">
						
						<br>
						<div class="form-group">
							 
							<label for="exampleInputEmail1">
								Make
							</label>
							<input type="text" class="form-control" name="makeinput">
						</div>
						<div class="form-group">
							 
							<label for="exampleInputEmail1">
								Model
							</label>
							<input type="text" class="form-control" name="modelinput">
						</div>
						<div class="form-group">
							 
							<label for="exampleInputEmail1">
								Year
							</label>
							<input type="int" class="form-control" name="yearinput">
						</div>
						<div class="form-group">
							 
							<label for="exampleInputEmail1">
								License Plate Number
							</label>
							<input type="text" class="form-control" name="licensenumberinput">
						</div>
						<button type="submit" class="btn btn-default" name = "Submit">
							Submit
						</button>
						<?php
							if (isset($_POST['Submit'])){

								$user_make= $_POST['makeinput'];
								$user_model= $_POST['modelinput'];
								$user_year = $_POST['yearinput'];
								$user_number = $_POST['licensenumberinput'];

								if (empty($user_make)){
									echo "<p>Please type in the vehicle make.";
								}
								else if (empty($user_model)){
									echo "<p>Please type in the vehicle model.";
								}
								else if (empty($user_year)){
									echo "<p>Please type in the vehicle year.";
								}
								else if (empty($user_number)){
									echo "<p>Please type in the license plate number.";
								}
								else if (!$connect){
									echo "Can't connect to the database!";
								}
								else{
									// add the new payment information into the table payment which use card number as a primary key
									$sql = "INSERT INTO vehicle (Make, Model, year, Username, License_Plate_Number) VALUES(?,?,?,?,?)";
									$stmt = mysqli_prepare($connect, $sql);
									mysqli_stmt_bind_param($stmt,"sssss",$user_make, $user_model, $user_year, $_SESSION['company_N'], $user_number);
									mysqli_stmt_execute($stmt);
									if (mysqli_stmt_affected_rows($stmt) == 1){
										header('Location: BusinessvehicleInfo.php');
									}
									else{
										echo '<p>'.mysqli_error($connect);
									}
								}
							}
						?>
				</div>
			</div>
		</div>
	</div>
	</div>
  	</form>
  	</body>
</html>