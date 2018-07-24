package com.bean;

import java.io.Serializable;
import java.sql.Date;

public class Book implements Serializable{
	private String bookIsbn;
	private String bookName;
	private String bookAuthor;
	private Double price;
	private Long stock;
	private Date datOfPublication;
	public Book() {
		super();
	}
	public Book(String bookIsbn, String bookName, String bookAuthor, Double price, Long stock, Date datOfPublication) {
		super();
		this.bookIsbn = bookIsbn;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.price = price;
		this.stock = stock;
		this.datOfPublication = datOfPublication;
	}
	public String getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public Date getDatOfPublication() {
		return datOfPublication;
	}
	public void setDatOfPublication(Date datOfPublication) {
		this.datOfPublication = datOfPublication;
	}
	

}
