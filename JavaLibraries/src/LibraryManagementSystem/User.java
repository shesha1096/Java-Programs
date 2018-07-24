package LibraryManagementSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class User {
	private String name;
	private List<Book> userCart;
	private Double cost;
	private String userName;
	private String mobileNo;
	private String emailID;
	private Map<String,String> usersMap ;

	public User() {
		super();
		userCart = new ArrayList<>();
		usersMap = new HashMap<>();
		usersMap.put("shesha", "9686225035");
		usersMap.put("shankar","9901900362");
		usersMap.put("satish", "9900106892");
		usersMap.put("alan", "1234566789");
		usersMap.put("walker", "9538502574");
		
	}


	public User(String name,String userName, String mobileNo,String emailID) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.userName = userName;
		this.emailID = emailID;
	}
	
	


	public Map<String, String> getUsersMap() {
		return usersMap;
	}


	public void setUsersMap(Map<String, String> usersMap) {
		this.usersMap = usersMap;
	}


	public String getEmailID() {
		return emailID;
	}


	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	public List<Book> getUserCart() {
		return userCart;
	}


	public void setUserCart(List<Book> userCart) {
		this.userCart = userCart;
	}


	public Double getCost() {
		return cost;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void add(Book book)
	{
		userCart.add(book);

	}
	public void displayCart()
	{
		if(userCart.size()==0)
		{
			System.out.println("You have no books in your cart.");
			System.exit(0);
		}else
		{
			for(Book book: userCart)
			{
				System.out.println("Book Name: "+book.getBookName()+ " Price: "+ book.getPrice());
			}
		}
		System.out.println("Do you want to generate a bill?");
		String ch = new Scanner(System.in).nextLine();
		if(ch.equals("yes"))
		{
			Admin.generateBill(this);
		}
	}
	


}
