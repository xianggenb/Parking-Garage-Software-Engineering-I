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
				<a href="profile.php" class="btn btn-info" role="button">Home</a>
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
					if (empty($_SESSION['fname'])){
					  header('Location:error.php');
				    }
					$host = "localhost";
					$user = "root";
					$password = "";
					$db = "accountmanagement";
					$connect = mysqli_connect($host,$user,$password,$db);
					//find the vehicle which relates to the username. 
					$query_business = "SELECT Make, Model, year, License_Plate_Number FROM vehicle WHERE Username = '".$_SESSION['Company_N']."'";
					$res_business = mysqli_query($connect, $query_business );
					$query_default = "SELECT default_vehicle FROM user WHERE emailaddress = '".$_SESSION['Username']."'";
					$res_default = mysqli_query($connect, $query_default);
					$vehicle_de = mysqli_fetch_array($res_default);
					$query = "SELECT Make, Model, year, License_Plate_Number FROM vehicle WHERE Username = '".$_SESSION['Username']."'";
					$res = mysqli_query($connect,$query);

					// if can't find any vehicles which relate to the user
					// ehco following messages.
					if (mysqli_affected_rows($connect) == 0){
						echo "<center>You haven't added any your own vehicles yet.";
					}
					// get the columns of vehicle and print them out 
					else{
						while($row = mysqli_fetch_array($res)){
							// if the column found is default one, it will have "(default)" after the informaiton
							if ($vehicle_de['default_vehicle'] == $row['License_Plate_Number']){
								echo '<center> <input type="radio" name="vehicle"'. "value = ".$row['License_Plate_Number'].">";
								echo $row['Make']." ".$row['Model']."-".$row['year']." : ".$row['License_Plate_Number']."(Default)</label><br />";
							}
							//otherwise just printout its information.
							else{
								echo '<center> <input type="radio" name="vehicle"'. "value = ".$row['License_Plate_Number'].">";
								echo $row['Make']." ".$row['Model']."-".$row['year']." : ".$row['License_Plate_Number']."</label><br />";
							}
						}
					}
					$query_deny = "SELECT * FROM deny_list WHERE emailaddress = '".$_SESSION['Username']."'AND company = '".$_SESSION['Company_N']."'LIMIT 1";
					$res_deny = mysqli_query($connect, $query_deny);
					if (mysqli_affected_rows($connect) == 0){
						while ($row = mysqli_fetch_array($res_business)){
							echo '<center> <input type="radio" name="vehicle"'. " value = ".$row['License_Plate_Number'].">";
							echo $row['Make']." ".$row['Model']."-".$row['year']." : ".$row['License_Plate_Number']."(Company)</label><br />";
						}
					}
					?>
					<center>
					<br>
					<div class="btn-group">
						<button class="btn btn-default" type="submit" name = "delete">
							Delete Selected
						</button> 
						<button class="btn btn-default" type="submit" name = "default">
							Set As Default
						</button>
						<?php
						// if click on the set defualt, this informaiton will be setted as default_payment under table user
						// and refresh the page
						if(isset($_POST['default'])){
							if(isset($_POST['vehicle'])){
								$query = "UPDATE user SET default_vehicle = '".$_POST['vehicle']."' WHERE emailaddress = '".$_SESSION['Username']."'";
								$res = mysqli_query($connect,$query);
								if (mysqli_affected_rows($connect) == 1){
									header('Location: VehicleInfo.php');
								}
							}
						}
						// if click on the delete, this informaiton will be deleted under table payment
						// and refresh the page
						if(isset($_POST['delete'])){
							if(isset($_POST['vehicle'])){
								$query = "DELETE FROM vehicle WHERE License_Plate_Number = '".$_POST['vehicle']."' AND Username = '".$_SESSION['Username']."'";
								$res = mysqli_query($connect,$query);
								if (mysqli_affected_rows($connect) == 1){
								header('Location: VehicleInfo.php');
								}
								else{
									echo '<br><br>You do not have right to change the company vehicle!';
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
									mysqli_stmt_bind_param($stmt,"sssss",$user_make, $user_model, $user_year, $_SESSION['Username'], $user_number);
									mysqli_stmt_execute($stmt);
									if (mysqli_stmt_affected_rows($stmt) == 1){
										header('Location: VehicleInfo.php');
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