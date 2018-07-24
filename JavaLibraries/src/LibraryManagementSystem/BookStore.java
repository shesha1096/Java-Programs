package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookStore {
	
	private Map<Integer,String> booksMap;
	private Set<Book> bookList;
	

	public BookStore() {
		super();
		
		booksMap = new HashMap<>();
		bookList = new HashSet<>();
	}
	

	public Map<Integer, String> getBooksMap() {
		return booksMap;
	}


	public void setBooksMap(Map<Integer, String> booksMap) {
		this.booksMap = booksMap;
	}


	public Set<Book> getBookList() {
		return bookList;
	}


	public void setBookList(Set<Book> bookList) {
		this.bookList = bookList;
	}


	public void addBooks()
	{
		bookList = Utilities.addBooks();
		
		booksMap.put(123, "programmingwithjava");
		booksMap.put(345, "programmingwithc");
		booksMap.put(456, "programmingwithc#");
		booksMap.put(678, "programmingwithc++");
		booksMap.put(1234, "programmingwithangular ");
		booksMap.put(1235, "programmingwithweb");
		booksMap.put(1236, "mobileapplicationdevelopment");
		booksMap.put(134, "cloudtechnologies");
		booksMap.put(156, "oraclesql");
		booksMap.put(1237, "mongodb");
		booksMap.put(4567, "reactjs");
		booksMap.put(12345, "xamarin.forms");
		
		
	}
	public void showBooks()
	{
		for(Book book: bookList)
		{
			System.out.println(book.getIsbn()+ " " + book.getBookName() + " " + book.getAuthorName() + " " + book.getPrice() + " " + book.getStock());
		}
	}
	public Book checkAvailability(String name)
	{
		//System.out.println(name.replaceAll("\\s+","").toLowerCase());
		if(booksMap.containsValue(name.replaceAll("\\s+","").toLowerCase()))
			
		{
			//System.out.println("Here");
			for(Book book:bookList)
			{
				//System.out.println(book.getBookName().replaceAll("\\s+", ""));
				if(book.getBookName().replaceAll("\\s+","").toLowerCase().equals(name.replaceAll("\\s+","").toLowerCase()) && book.getStock()>0)
				{
					
					return book;
				}
			}
		}
		return null;
	}
	public Boolean addBook(Book book)
	{
		for(Book book1: bookList)
		{
			if(book1.getIsbn() == book.getIsbn())
			{
				//System.out.println("Here also");
				return false;
			}
		}
		bookList.add(book);
		String bookName = book.getBookName().replaceAll("\\s+","").toLowerCase();
		booksMap.put(book.getIsbn(), bookName);
		return true;
		
	}
	public Book removeFromList(int isbn)
	{
		for(Book book: bookList)
		{
			if(book.getIsbn()==isbn)
			{
				bookList.remove(book);
				return book;
			}
		}
		return null;
		
	}
 

	
		
	
	
	

}
