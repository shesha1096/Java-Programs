package com.classes;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Book> bookList;

	public Cart() {
		super();
		bookList = new ArrayList<>();
	}

	public Cart(List<Book> bookList) {
		super();
		this.bookList = bookList;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	
	
}
