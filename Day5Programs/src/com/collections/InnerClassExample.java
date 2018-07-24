package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.models.Book;

public class InnerClassExample {
	public static void main(String[] args)
	{
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("1","Programming with Java","Shesha"));
		bookList.add(new Book("9","Programming with C#","Shankar"));
		bookList.add(new Book("10","Programming with Android","Shesha"));
		bookList.add(new Book("7","Programming with Xamarin.Forms","Shesha"));
		bookList.add(new Book("8","Programming with C++","Shesha"));
		bookList.add(new Book("5","Programming with Kotlin","Shesha"));
		
		Collections.sort(bookList,new Comparator<Book>()
				{

					@Override
					public int compare(Book b1, Book b2) {
						// TODO Auto-generated method stub
						
						return b1.getTitle().compareTo(b2.getTitle()) ;
						
					}
			
			
				});
		for(Book book: bookList)
		{
		System.out.println(book.getTitle());
		}
		
	}

}
