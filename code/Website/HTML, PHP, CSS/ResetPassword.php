<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"/>
		<link href="bootstrap.min.css" rel="stylesheet">
		<title>Welcome to Park-A-Lot</title>
		<meta name = "author" content = "Yufeng Liu"/>
	</head>

  <body>
  <form action = "" method = "post">
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-3" align=center>
			<img alt="Park-A-Lot" src="VehicleInfo.png" height = 150 width = 350>
		</div>
		<div class="col-md-6">
			<h1 class="text-center">
				Park-A-Lot
			</h1>
			<h3 class="text-center">
				Reset the Password
			</h3>
			<div class="row">
				<div class="col-md-12">
					<form role="form">
						<div class="form-group">
							<label for="emailinput">
								Registered Email Address
							</label>
							<input type="email" class="form-control" name ="inputemail">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">
								The Current Password
							</label>
							<input type="password" class="form-control" name ="OldInputPassword1">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">
								Confirm the Current Password
							</label>
							<input type="password" class="form-control" name ="OldInputPassword2">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">
								The New Password
							</label>
							<input type="password" class="form-control" name ="NewInputPassword1">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">
								Confirm the New Password
							</label>
							<input type="password" class="form-control" name ="NewInputPassword2">
						</div>
						
						<button type="submit" class="btn btn-default" name = "Submit">
							Submit
						</button>
						<?php
						session_start();
						//Information connect to the database.
						$host = "localhost";
						$user = "root";
						$password = "";
						$db = "accountmanagement";
						$connect = mysqli_connect($host,$user,$password,$db);
						//Check if user clicks on the submit button.
						if (isset($_POST['Submit'])){
							//check if password is the same both time.
							if ($_POST['OldInputPassword1'] != $_POST['OldInputPassword2']){
								echo "<P>The current password are not the same!";
							}
							else if ($_POST['NewInputPassword1'] != $_POST['NewInputPassword2']){
								echo "<P>The new password are not the same!";
							}
							//changed the column which matches the old password.
							else{
								$sql = "SELECT * FROM logininfo WHERE Username= '".$_POST['inputemail']."' AND password = '".$_POST['OldInputPassword2']."' LIMIT 1";
								$res = mysqli_query($connect,$sql);
								if (mysqli_affected_rows($connect) == 1){
									$sql = "UPDATE logininfo SET password = '".$_POST['NewInputPassword2']."' WHERE Username= '".$_POST['inputemail']."'  LIMIT 1";
									$response = @mysqli_query($connect,$sql);
									if ($response){
										echo "<p>You have changed the password successfully!";
										echo '<a href="profile.php"><br>'. "<br>Go to Your profile page</a><br>";
									}
									else{
										// if not response output the error reason.
										echo '<p>'.mysqli_error($connect);
									}
								}
								else{
									echo "<p> Your username or password is wrong";
								}
							}
						}
						?>
						<a href="homepage.html"><br><br>Back to login page</a><br>
						</form>
					</form>
				</div>
			</div>
		</div>
		<div class="col-md-3" align = center>
			<img alt="Park-A-Lot" src="VehicleInfo.png" height = 150 width = 350>
		</div>
	</div>
</div>
  </form>
  </body>
</html>