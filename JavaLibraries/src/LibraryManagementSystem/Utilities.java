package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Utilities {
	private static User user;
	private static BookStore bookStore;

	public static Set<Book> addBooks()
	{
		Set<Book> booksList = new HashSet<>();
		booksList.add(new Book(123, "Programming with Java","John",800,20));
		booksList.add(new Book(345, "Programming with C","Doe",700,20));
		booksList.add(new Book(456, "Programming with C#","John",750,20));
		booksList.add(new Book(678, "Programming with C++","Wick",550,20));
		booksList.add(new Book(1234, "Programming with C","Jon",500,20));
		booksList.add(new Book(1235, "Programming with Web","Snow",650,20));
		booksList.add(new Book(1236, "Mobile Application Development","Shesha",800,20));
		booksList.add(new Book(134, "Cloud Technologies","Shankar",700,20));
		booksList.add(new Book(156, "Oracle SQL","Jean",700,20));
		booksList.add(new Book(1237, "Mongo DB","Sean",600,20));
		booksList.add(new Book(4567, "React JS","Ron",600,20));
		booksList.add(new Book(12345, "Xamarin.Forms","Shesha",750,20));
		return booksList;

	}
	public static void acceptUser()
	{
		Boolean flag= false;
		user = new User();
		System.out.println("Enter your name");
		user.setName(new Scanner(System.in).nextLine().toLowerCase());
		System.out.println("Enter mobile number");
		user.setMobileNo(new Scanner(System.in).nextLine());
		System.out.println("Enter your email ID");
		user.setEmailID(new Scanner(System.in).nextLine());
		Iterator iterator = user.getUsersMap().entrySet().iterator();
		while(iterator.hasNext())
		{
			flag = true;
			Map.Entry pair = (Map.Entry) iterator.next();
			if(pair.getKey().equals(user.getName()) && pair.getValue().equals(user.getMobileNo()))
			{
				System.out.println("Successfully Logged in");
				user.setUserName(generateUserName(user.getName(),user.getMobileNo(),user.getEmailID()));

				bookStore = new BookStore();
				bookStore.addBooks();
				System.out.println("List of Books:");
				bookStore.showBooks();
				addBooktoCart();
			}
		}
		if(!flag)
		{
			System.out.println("Login unsuccessful,please try again");
		}

	}

	public static String generateUserName(String name,String mobileNo,String emailID)
	{
		String userName="";
		userName= name.substring(0,4);
		userName+=mobileNo.substring(0,3);
		userName+=emailID.substring(0,4);
		return userName;

	}
	public static void addBooktoCart() {
		// TODO Auto-generated method stub
		Boolean flag = true;
		String choice="";
		while(flag)
		{
			System.out.println("Enter the book you want to take home");
			String bookName = new Scanner(System.in).nextLine();


			Book book = bookStore.checkAvailability(bookName);
			if(book!=null)
			{
				System.out.println("Book found");
				System.out.println("Do you want to add this book to your cart?");
				choice = new Scanner(System.in).nextLine();
				if(choice.equals("yes") || choice.equals("Yes"))
				{
					user.add(book);
					book.deduct();

					System.out.println("Do you want to search for more books?");
					String ch = new Scanner(System.in).next();
					if(ch.equals("yes") || ch.equals("Yes"))
					{
						//System.out.println("Here");

						flag = true;
					}
					else{
						//System.out.println("Here");
						user.displayCart();
						System.exit(0);
					}
				}
				else
				{
					System.out.println("Do you want to search for any other book?");
					choice = new Scanner(System.in).nextLine();
					if(choice.equals("yes") || choice.equals("Yes"))
					{

						flag = true;
					}
					else
					{
						flag = false;
					}

				}
			}

			else
			{
				System.out.println("Book not found or the book may have gone out of stock. Do you wish to search for other books?");
				if(new Scanner(System.in).nextLine().equals("Yes") || new Scanner(System.in).nextLine().equals("yes"))
				{
					flag = true;
				}
				else
				{
					flag = false;
				}
			}
		}
		user.displayCart();



	}
	public static void loginAdmin()
	{
		Admin admin = new Admin();
		Boolean flag=false; 
		while(!flag)
		{
			flag = admin.loginAdmin();
			if(flag==true)
			{
				adminFunctionalities(admin);



			}






			else
			{
				System.out.println("Incorrect username/password. Please try again.");
				flag = false;
			}
		}



	}
	public static void adminFunctionalities(Admin admin)
	{
		while(true)
		{
			System.out.println("1: Add Books 2: Delete a Book 3: Update Stock 4: Update Price 5: Find Book By Title 6: Exit");
			System.out.println("Enter your choice");
			int choice = new Scanner(System.in).nextInt();
			switch(choice)
			{
			case 1: addBooksByAdmin(admin); break;
			case 2: deleteBook(admin); break;
			case 3: updateStock(admin); break;
			case 4: updatePrice(admin); break;
			case 5: findBookByTitle(admin); break;
			case 6: System.exit(0); break;
			}
		}
	}
	public static void addBooksByAdmin(Admin admin)
	{
		System.out.println("Do you wish to add books?");
		if(new Scanner(System.in).nextLine().equals("yes"))
		{
			Boolean added =admin.addBook();
			if(added)
			{
				System.out.println("Book successfully added");
				admin.displayBooks();
			}
			else
			{
				System.out.println("Could not add book.");
			}
		}

	}
	public static void deleteBook(Admin admin)
	{
		Boolean deleted =admin.deleteBook();
		if(deleted)
		{
			admin.displayBooks();
		}
		else{
			System.out.println("Could not delete book");
		}

	}
	public static void updateStock(Admin admin)
	{
		admin.updateStock();

	}
	public static void updatePrice(Admin admin)
	{
		admin.updatePrice();

	}
	public static void findBookByTitle(Admin admin)
	{
		admin.findBookByTitle(admin);
	}

}
