package LibraryManagementSystem;

public class Book {
	private int isbn;
	private String bookName;
	private String authorName;
	private double price;
	private static int stock=0;
	public Book() {
		super();
	}
	public Book(int isbn, String bookName, String authorName, double price,int stock) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
		this.stock = stock;
	}
	
	public Book(String bookName) {
		super();
		this.bookName = bookName;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public static int getStock() {
		return stock;
	}
	public static void setStock(int stock) {
		Book.stock = stock;
	}
	public void deduct()
	{
		this.stock--;
	}
	public void updateValue(int value)
	{
		this.stock+=value;
	}
	public void updateValueOfPrice(int price)
	{
		this.price+=price;
	}
	

}
