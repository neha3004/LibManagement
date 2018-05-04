package com.luv2code.web.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {

	private DataSource dataSource;

	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Student> getStudents() throws Exception {
		
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from student order by stud_name";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int studId = myRs.getInt("stud_id");
				String studName = myRs.getString("stud_name");
				String bookName = myRs.getString("book_name");
				int bookId = myRs.getInt("book_id");
				
				// create new student object
				Student tempStudent = new Student(studId, studName, bookName, bookId);
				
				// add it to the list of students
				students.add(tempStudent);				
			}
			
			return students;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addStudent(Student theStudent) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into student "
					   + "(stud_id,stud_name, book_name, book_id) "
					   + "values (?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setInt(1, theStudent.getStudId());
			myStmt.setString(2, theStudent.getstudName());
			myStmt.setString(3, theStudent.getbookName());
			myStmt.setInt(4, theStudent.getBookId());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}
	public Student getRec(String bookId) throws Exception{
	
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int book;
		try{
			book = Integer.parseInt(bookId);
			myConn = dataSource.getConnection();
			String sql = "select * from student where book_id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, book);
			myRs = myStmt.executeQuery();
			myRs.next();
			int studId = myRs.getInt("stud_id");
			String studName = myRs.getString("stud_name");
			String bookName = myRs.getString("book_name");
			int booknum = myRs.getInt("book_id");
			
			// create new student object
			Student tempStudent = new Student(studId, studName, bookName, booknum);
			return tempStudent;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public List<Student> getStudent(String theStudentId) throws Exception {

		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int studentId;
		
		try {
			// convert student id to int
			studentId = Integer.parseInt(theStudentId);
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from student where stud_id=?";			
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);			
			
			// set params
			myStmt.setInt(1, studentId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			while(myRs.next()) {
				int studId = myRs.getInt("stud_id");
				String studName = myRs.getString("stud_name");
				String bookName = myRs.getString("book_name");
				int bookId = myRs.getInt("book_id");
				System.out.println(bookId+" "+bookName);
				// create new student object
				Student tempStudent = new Student(studId, studName, bookName, bookId);
				
				// add it to the list of students
				students.add(tempStudent);				
			}
			
			return students;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateStudent(Student theBook) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update student "
						+ "set stud_id=?, stud_name=?, book_name=? "
						+ "where book_id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(2, theBook.getstudName());
			myStmt.setString(3, theBook.getbookName());
			myStmt.setInt(4, theBook.getBookId());
			myStmt.setInt(1, theBook.getStudId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteStudent(String theBookId) throws Exception {
	Connection myConn=null;
	PreparedStatement myStmt=null;
	int bookId;
	try {
		bookId=Integer.parseInt(theBookId);
		myConn=dataSource.getConnection();
		 String sql="delete from student where book_id=?";
		 myStmt=myConn.prepareStatement(sql);
		 myStmt.setInt(1,bookId);
		 
		 myStmt.execute();
	
	}
	finally {
		close(myConn,myStmt,null);
	}
	}
}















