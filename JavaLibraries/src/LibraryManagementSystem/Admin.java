package LibraryManagementSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Admin {
	private Map<String,String> adminMap;
	private String user_name;
	private String password;
	private BookStore bookStore;
	private Map<String,String> usersMap;
	public Admin() {
		super();
		usersMap = new HashMap<>();
		adminMap = new HashMap<>();
		adminMap.put("shesha","shesha1096");
		adminMap.put("shankar","shankar1096");
		adminMap.put("sam","sam1096");
		adminMap.put("monte","monte1096");
		adminMap.put("carlo","carlo1096");
		adminMap.put("california","california1096");
		
		usersMap.put("9686225035", "shesha");
		usersMap.put("9901900362","shankar");
		usersMap.put("9900106892", "satish");
		usersMap.put("1234566789", "alan");
		usersMap.put("9538502574", "walker");
		bookStore = new BookStore();
		bookStore.addBooks();

	}




	public Admin(Map<String, String> adminMap, String user_name, String password) {
		super();
		this.adminMap = adminMap;
		this.user_name = user_name;
		this.password = password;
	}
	
	public BookStore getBookStore() {
		return bookStore;
	}




	public void setBookStore(BookStore bookStore) {
		this.bookStore = bookStore;
	}




	public Map<String, String> getUsersMap() {
		return usersMap;
	}




	public void setUsersMap(Map<String, String> usersMap) {
		this.usersMap = usersMap;
	}




	public Map<String, String> getAdminMap() {
		return adminMap;
	}
	public void setAdminMap(Map<String, String> adminMap) {
		this.adminMap = adminMap;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean loginAdmin()
	{
		System.out.println("Enter username");
		user_name=new Scanner(System.in).nextLine();
		System.out.println("Enter password");
		password=new Scanner(System.in).nextLine();
		if(adminMap.containsKey(user_name) && adminMap.containsValue(password))
		{
			return true;
		}
		return false;

	}
	public Boolean addBook()
	{
		Book book = new Book();
		System.out.println("Enter book ISBN");
		book.setIsbn(new Scanner(System.in).nextInt());
		System.out.println("Enter book name");
		book.setBookName(new Scanner(System.in).nextLine());
		System.out.println("Enter book author name");
		book.setAuthorName(new Scanner(System.in).nextLine());
		System.out.println("Enter the price");
		book.setPrice(new Scanner(System.in).nextDouble());
		System.out.println("Enter the stock");
		book.setStock(new Scanner(System.in).nextInt());
		Boolean flag =bookStore.addBook(book);
		if(flag)
		{
			return true;
		}
		else
		{
			return false;
		}


	}
	public void displayBooks()
	{
		bookStore.showBooks();
	}
	public Boolean deleteBook()
	{
		System.out.println("Enter the book ISBN that you want to delete");
		int isbn = new Scanner(System.in).nextInt();
		Iterator it = bookStore.getBooksMap().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if(pair.getKey().equals(isbn))
			{
				bookStore.getBooksMap().remove(pair.getKey());
				Book book = bookStore.removeFromList(isbn);
				if(book!=null)
				{
					System.out.println("Successfully deleted");
					return true;
				}
				else
				{
					System.out.println("Book not found");

				}

			}
		}
		return false;


	}
	public void updateStock()
	{
		System.out.println("Enter the ISBN of whose stock you want to update");
		int isbn = new Scanner(System.in).nextInt();
		Book book = checkExistance(isbn);
		if(book!=null)
		{
			System.out.println("Enter the stock value to be updated");
			int stock = new Scanner(System.in).nextInt();
			book.updateValue(stock);
			bookStore.showBooks();
		}
		else
		{
			System.out.println("Book not found");
		}

	}
	public void updatePrice()
	{
		System.out.println("Enter the ISBN of whose price you want to update");
		int isbn = new Scanner(System.in).nextInt();
		Book book = checkExistance(isbn);
		if(book!=null)
		{
			System.out.println("Enter the price value to be updated");
			int price = new Scanner(System.in).nextInt();
			book.updateValueOfPrice(price);
			bookStore.showBooks();
		}
		else{
			System.out.println("Book not found");
		}

	}
	public Book checkExistance(int isbn)
	{
		Iterator it = bookStore.getBooksMap().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if(pair.getKey().equals(isbn))
			{
				Set<Book> books =bookStore.getBookList();
				for (Iterator<Book> iterator = books.iterator(); iterator.hasNext(); ) {
					Book book = iterator.next();
					if (book.getIsbn()==isbn)
					{
						return book;
					}
				}
			}

		}
		return null;

	}
	public static void generateBill(User user)
	{
		Bill bill = new Bill();
		List<Book> booksList = new ArrayList<>();
		if(user.getUserCart().isEmpty())
			return;
		else
		{
			Double cost = 0.0;
			// System.out.println("Username: "+user.getUserName());
			bill.setUserName(user.getUserName());
			//System.out.println("Total number of books bought: "+user.getUserCart().size());
			bill.setNoOfBooks(user.getUserCart().size());
			//System.out.println("List of books bought:");
			for(Book book: user.getUserCart())
			{
				//System.out.print(book.getBookName()+" ");
				booksList.add(book);

				cost+=book.getPrice()*1;
			}
			bill.setBookList(booksList);
			bill.setCost(cost);
			System.out.println();
			System.out.println("Total Cost: "+cost);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			//System.out.println("Date and time of purchase: "+dateFormat.format(date));
			bill.setBillDate(dateFormat.format(date));
			bill.displayBill();
			user.setUserCart(null);
		}
	}
	public void findBookByTitle(Admin admin)
	{
		System.out.println("Enter the title of the book that you are looking for");
		String title= new Scanner(System.in).nextLine().replaceAll("\\s+", "").toLowerCase();
		Map<Integer,String> booksMap = bookStore.getBooksMap();
		if(booksMap.containsValue(title))
		{
			System.out.println("Book found");
		}
		else
			System.out.println("Book not found");
	}


}
