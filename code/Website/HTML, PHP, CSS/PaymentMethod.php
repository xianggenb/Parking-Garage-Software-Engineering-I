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
					Park-A-Lot <small>Payment Management</small>
				</h1>
				<a href="profile.php" class="btn btn-info" role="button">Home</a>
			</div>
			<div class="row">
				<div class="col-md-4">
					
					<h3>
						<center>Current Payment Methods</center>
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

					//find the payment method which relates to the username. 
					$query_default = "SELECT default_payment FROM user WHERE emailaddress = '".$_SESSION['Username']."'";
					$res_default = mysqli_query($connect, $query_default);
					$payment_de = mysqli_fetch_array($res_default);
					$query = "SELECT Card_Number, Expiration_Date FROM payment WHERE Username = '".$_SESSION['Username']."'";
					$res = mysqli_query($connect,$query);

					// if can't any payment method which relate to the user
					// ehco following messages.
					if (mysqli_affected_rows($connect) == 0){
						echo "<center>You haven't added any card yet.";
					}
					else{
						// get the columns of payment method and print them out 
						while($row = mysqli_fetch_array($res)){
							// if the column found is default one, it will have "(default)" after the informaiton
							if ($payment_de['default_payment'] == $row['Card_Number']){
								echo '<center> <input type="radio" name="payment"'. "value = ".$row['Card_Number'].">";
								echo $row['Card_Number'].":[".$row['Expiration_Date']."](Default)</label><br />";
							}
							//otherwise just printout its information.
							else{
								echo '<center> <input type="radio" name="payment"'. "value = ".$row['Card_Number'].">";
								echo $row['Card_Number'].":[".$row['Expiration_Date']."]</label><br />";
							}
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
							if(isset($_POST['payment'])){
								$query = "UPDATE user SET default_payment = '".$_POST['payment']."' WHERE emailaddress = '".$_SESSION['Username']."'";
								$res = mysqli_query($connect,$query);
								if (mysqli_affected_rows($connect) == 1){
									header('Location: PaymentMethod.php');
								}
							}
						}
						// if click on the delete, this informaiton will be deleted under table payment
						// and refresh the page
						if(isset($_POST['delete'])){
							if(isset($_POST['payment'])){
								$query = "DELETE FROM payment WHERE Card_Number = '".$_POST['payment']."'";
								$res = mysqli_query($connect,$query);
								if (mysqli_affected_rows($connect) == 1){
								header('Location: PaymentMethod.php');
								}
							}
						}
						?>
						
					</div>
					</center>
				</div>
				<div class="col-md-7">
					<h3>
						Add New Payment Method
					</h3>
					<form role="form">
						<select name = "card_type" class="form-control">
    						<option value="one">Visa</option>
						    <option value="two">Mastercard</option>
						    <option value="three">Amex</option>
						    <option value="four">PayPal</option>
						</select>
						<br>
						<div class="form-group">
							 
							<label for="exampleInputEmail1">
								Name on Card
							</label>
							<input type="text" class="form-control" name="nameinput">
						</div>
						<div class="form-group">
							 
							<label for="exampleInputEmail1">
								Card Number
							</label>
							<input type="text" class="form-control" name="cardnumberinput">
						</div>
						<div class="form-group">
							 
							<label for="exampleInputEmail1">
								Expiration Date
							</label>
							<input type="text" class="form-control" name="dateinput">
						</div>
						<div class="form-group">
							 
							<label for="exampleInputEmail1">
								Security Code
							</label>
							<input type="int" class="form-control" name="securityinput">
						</div>
						<button type="submit" class="btn btn-default" name = "Submit">
							Submit
						</button>
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