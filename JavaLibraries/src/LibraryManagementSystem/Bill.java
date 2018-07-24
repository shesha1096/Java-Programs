package LibraryManagementSystem;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class Bill {
	private String userName;
	private List<Book> bookList;
	private double cost;
	private String billDate;
	private int noOfBooks;
	public Bill() {
		super();
		bookList = new ArrayList<>();
		cost = 0.0;
	}
	public Bill(String userName, List<Book> bookList, double cost, String billDate,int noOfBooks) {
		super();
		this.userName = userName;
		this.bookList = bookList;
		this.cost = cost;
		this.billDate = billDate;
		this.noOfBooks = noOfBooks;
	}

	public int getNoOfBooks() {
		return noOfBooks;
	}
	public void setNoOfBooks(int noOfBooks) {
		this.noOfBooks = noOfBooks;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public void displayBill()
	{
		System.out.println("Username: "+userName);
		System.out.println("Number of books purchased: "+noOfBooks);
		System.out.println("List Of Books: ");
		for(Book book: bookList)
		{
			System.out.print(book.getBookName());
		}
		System.out.println();
		System.out.println("Date of Purchase: "+billDate);



	}
	



}
