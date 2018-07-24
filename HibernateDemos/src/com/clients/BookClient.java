package com.clients;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Book;
import com.utils.Utility;

public class BookClient {
	private static SessionFactory sessionFactory;
	static{
		Configuration config = new Configuration();
		config.configure("/hibernate.cfg.xml");
		sessionFactory = config.buildSessionFactory();
	}
	public  boolean addBook(String bookIsbn,String authorName,String bookName,Long stock,Double price,Date dateOfPublication)
	{
		Session session = sessionFactory.openSession();
		Book book = new Book(bookIsbn,bookName,authorName,price,stock,dateOfPublication);
		session.save(book);
		session.flush();
		return true;
	}
	public List<Book> getBooks()
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Book");
		return query.list();
	}
	public boolean deleteBook(String isbn)
	{
		Session session = sessionFactory.openSession();
		Book bookDeleted = (Book) session.get(Book.class, isbn);
		if(bookDeleted!=null)
		{
			session.delete(bookDeleted);
			session.flush();
			
			return true;
		}
		return false;
	}
	public boolean updateBook(String isbn)
	{
		Session updateSession = sessionFactory.openSession(); 
		String query = "from Book as book where book.bookIsbn=?";
		Query queryObject = updateSession.createQuery(query);
		queryObject.setParameter(0, isbn);
		List<Book> books = queryObject.list();
		for(Book updateBook: books)
		{
		if(updateBook!=null)
		{
			updateBook.setBookAuthor("Smith");
			updateSession.update(updateBook);
			updateSession.flush();
			return true;
		}
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		BookClient bookClient = new BookClient();
		//bookClient.addBook("3216", "John", "Programming with Java", 50L, 700.00, null);
		System.out.println(bookClient.getBooks());
		Boolean update = bookClient.updateBook("3215");
		if(update)
		{
			System.out.println("Book updated");
		}
		else
		{
			System.out.println("Book details could not be updated");
		}
		System.out.println("Enter date");
		String dateString = new Scanner(System.in).nextLine();
		Date date = Utility.convertDate(dateString);
		System.out.println(date);
		
        
	}

}
