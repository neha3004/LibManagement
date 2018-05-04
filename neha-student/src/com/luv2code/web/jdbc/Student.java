package com.luv2code.web.jdbc;

public class Student {

	private int studId;
	private String studName;
	private String bookName;
	private int bookId;

	public Student(String studName, String bookName, int bookId) {
		this.studName = studName;
		this.bookName = bookName;
		this.bookId = bookId;
	}

	public Student(int studId, String studName, String bookName, int bookId) {
		this.studId = studId;
		this.studName = studName;
		this.bookName = bookName;
		this.bookId = bookId;
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int id) {
		this.studId = studId;
	}

	public String getstudName() {
		return studName;
	}

	public void setstudName(String studName) {
		this.studName = studName;
	}

	public String getbookName() {
		return bookName;
	}

	public void setbookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", bookName=" + bookName + ", bookId=" + bookId + "]";
	}	
}
