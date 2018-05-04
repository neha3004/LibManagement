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
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Add Book" 
				   onclick="window.location.href='add-student-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table align="center" class="table table-hover">
			
				<tr >
					<th>Student ID</th>
					<th>Student Name</th>
					<th>Book Name</th>
					<th>Book ID</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempStudent" items="${STUDENT_LIST}">
					
					<!-- set up a link for each student -->
					
					
					<c:url var="tempLink" value="StudentControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="bookId" value="${tempStudent.bookId}" />
					</c:url>
					
					<c:url var="deleteLink" value="StudentControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="bookId" value="${tempStudent.bookId}" />
					</c:url>
																		
					<tr>
						<td> ${tempStudent.studId}</td>
						<td> ${tempStudent.studName} </td>
						<td> ${tempStudent.bookName} </td>
						<td> ${tempStudent.bookId} </td>
						<td> 
							<a href="${tempLink}">Update</a> 
							<a href="${deleteLink}">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
			
			<br/><br/>
			<input type="button" value="Main Page" 
				   onclick="window.location.href='hello.html'; return false;"
				   class="add-student-button"
			/>
			
		
		</div>
	
	</div>
</body>


</html>








