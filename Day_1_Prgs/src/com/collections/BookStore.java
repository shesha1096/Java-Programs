package com.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;



public class BookStore {
	 
	
	//set of Books
	//static Set<Book> bookSet=new HashSet<Book>();
	static Set<Book> bookSet=new TreeSet<Book>( new Comparator<Book>()
	 {
@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getTitle().compareTo(o2.getTitle());
	}


	 });
	public static Set<Book> getBookSet() {
		return bookSet;
	}

	static{
		
		bookSet.add(new Book("1", "C", "YK", 200, 100l));
		bookSet.add(new Book("2", "C++", "PK", 300, 500l));
		bookSet.add(new Book("3", "Java", "Patrick", 100, 550l));
		bookSet.add(new Book("6", "CSharp", "xyz", 200, 100l));
		bookSet.add(new Book("7", "Html", "RVK", 100, 100l));
		bookSet.add(new Book("12", "android", "RVK", 100, 100l));
	}
	public static void main(String[] args)
	{
		new BookStore();
		System.out.println(bookSet);
	}

	
}
