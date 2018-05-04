<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Update Student</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CBIT University</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Book</h3>
		
		<form action="StudentControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="bookId" value="${THE_STUDENT.bookId}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Student ID:</label></td>
						<td><input type="text" name="studId" value="${THE_STUDENT.studId}" /></td>
					</tr>

					<tr>
						<td><label>Student name:</label></td>
						<td><input type="text" name="studName" 
								   value="${THE_STUDENT.studName}" /></td>
					</tr>

					<tr>
						<td><label>Book Name:</label></td>
						<td><input type="text" name="bookName" 
								   value="${THE_STUDENT.bookName}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>	
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="StudentControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











