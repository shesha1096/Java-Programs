package com.classes;

public class Book {
	private String bookName;
	private int bookIsbn;
	private String authorName;
	private double price;
	private int stock;
	public Book() {
		super();
	}
	public Book(String bookName, int bookIsbn, String authorName, double price, int stock) {
		super();
		this.bookName = bookName;
		this.bookIsbn = bookIsbn;
		this.authorName = authorName;
		this.price = price;
		this.stock = stock;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(int bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	
		
		

}
