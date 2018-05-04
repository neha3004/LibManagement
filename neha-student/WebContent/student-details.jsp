<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Library Management</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Library</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			
			
			<table align="center" class="table table-hover">
			
				<tr class="heading">
					<th>Student Name</th>
					<th>Book Name</th>
					<th>Book ID</th>
					
				</tr>
				
				<c:forEach var="tempStudent" items="${BOOK_LIST}" >
					<tr>
						<td> ${tempStudent.studName} </td>
						<td> ${tempStudent.bookName} </td>
						<td> ${tempStudent.bookId} </td>
					</tr>
				</c:forEach>
				
			</table>
		<br/>
		<input type="button" value="Main Page" 
				   onclick="window.location.href='hello.html'; return false;"
				   class="add-student-button"
			/>
			
		</div>
	
	</div>
</body>


</html>








