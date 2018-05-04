<!DOCTYPE html>
<html>
<head>
<title>
Add Student
</title>
				<link type="text/css" rel="stylesheet" href="css/style.css">
				<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>
<body>
	<div id="wrapper">
	<div id="header">
	<h2>CBIT College</h2>
	</div>
	
	<div id="container">
	<h3>Add book</h3>
	
	<form action="StudentControllerServlet" method="GET">
	<input type="hidden" name="command" value ="ADD" />
	<table>
	<tbody>
	<tr>
	<td><label>Student Id:</label></td>
	<td><input type="text" name="studId" /></td>	
	</tr>
	<tr>
	<td><label>Student name:</label></td>
	<td><input  type="text" name="studName" /></td> 	
	</tr>
	<tr>
	<td><label>Book name:</label></td>
	<td><input  type="text" name="bookName" /></td> 	
	</tr>
	<tr>
	<td><label>Book Id:</label></td>
	<td><input  type="text" name="bookId" /></td> 	
	</tr>
	
	<tr>
	<td><label></label></td>
	<td><input type="submit" value="Save" class="save"/></td>

	

		</tbody>
	</table>
	
	</form>
		<div style="clear:both;"></div>
	<p>
	<a href="StudentControllerServlet" >Back to List</a>
	</p>
	</div>
	</div>
</body>
</html>