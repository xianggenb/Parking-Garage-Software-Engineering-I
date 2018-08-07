<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Park-A-Lot</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="bootstrap.min.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">

  </head>
  <body>

    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">

			<div class="page-header">
				<h1>
					Park-A-Lot <small>Active Rates</small>
				</h1>
				<a href="managehome.html" class="btn btn-info" role="button">Home</a>
			</div>
			
			<table class="table">
				
				
	
			 
				<?php
$username = "root";
$password = "";
$hostname = "localhost";
$db = "Rates";

//connection to the database
$link = mysqli_connect($hostname, $username, $password, $db);

if (!$link){
	die("Connection Failed:".mysqli_connect_error());
}
 
$sql = "SELECT ratename, activeperiod, cost FROM rates";
$result = $link->query($sql);

if ($result->num_rows > 0) {
    
    while($row = $result->fetch_assoc()) {
        echo  "Rate Name:" . $row["ratename"] . "<br>";
        echo "Active Period:" . $row["activeperiod"]."<br>";
        echo "Cost($): " . $row["cost"] . "<br>"."<br>";
    }
} else {
    echo "0 results";
}
$link->close();
?>


			</table>
			

			<center>
			<div class="btn-group">
				<br>
				
				<a href="ratedelete.php" class="btn btn-default" type="button">
					<em class="glyphicon glyphicon-trash"></em> Delete Current Rate
				</a> 
				<a href="rateadd.php" class="btn btn-default" type="button">
					<em class="glyphicon glyphicon-plus"></em> New Rate
				</a> 

			</div>
			</center>
		</div>

		



	</div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>