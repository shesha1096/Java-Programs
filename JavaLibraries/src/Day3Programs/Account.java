package Day3Programs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Account {
	private String firstName;
	private SimpleDateFormat dateOfBirth;
	private String panNumber;
	private String userName;
	private String password;
	private String question;
	private String answer;
	private String confirmPassword;
	private String date;
	private int month;
	
	
	
	public Account() {
		super();
	}
	public Account(String firstName, SimpleDateFormat dateOfBirth, String panNumber, String userName, String password,
			String question, String answer) {
		super();
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.panNumber = panNumber;
		this.userName = userName;
		this.password = password;
		this.question = question;
		this.answer = answer;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public SimpleDateFormat getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(SimpleDateFormat dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public void readData()
	{
		
		System.out.println("Enter your first name");
		firstName = new Scanner(System.in).next();
		acceptMonth();
		System.out.println("Enter your PAN Card Number");
		panNumber = new Scanner(System.in).next();
		generateUserName(month);
		
		validateLength();
		
		System.out.println("Re-enter your password");
		confirmPassword = new Scanner(System.in).next();
		Boolean flag1 = checkValidity(password,confirmPassword);
		if(flag1==false)
		{
			System.out.println("Passwords do not match, please re-enter the password");
			confirmPassword = new Scanner(System.in).next();
		}
		System.out.println("Enter a question in case password is forgotton");
		question = new Scanner(System.in).next();
		System.out.println("Enter the answer for the corresponding question");
		answer = new Scanner(System.in).next();
		
	}
	private void validateLength() {
		// TODO Auto-generated method stub
		Boolean flag=false;
		do{
			System.out.println("Enter a password");
			password = new Scanner(System.in).next();
			if(password.length()<4)
			{
				System.out.println("Password length too short, please re-enter a new one");
				password = new Scanner(System.in).next();
				
			}
			else if(password.length()>8)
			{
				System.out.println("Password length too long, please re-enter a new one");
				password = new Scanner(System.in).next();
			}
			else
				flag=true;
			}while(!flag);
		
	}
	private void acceptMonth() {
		// TODO Auto-generated method stub
		System.out.println("Enter the date of birth in dd/MM/yy format");
		date = new Scanner(System.in).next();
		dateOfBirth = new SimpleDateFormat("dd/MM/yy");
		Date dateObj=null;
		try {
			dateObj = dateOfBirth.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateObj);
		 month = calendar.get(Calendar.MONTH)+1;
		
	}
	private Boolean checkValidity(String password2, String confirmPassword2) {
		// TODO Auto-generated method stub
		if(password2.equals(confirmPassword2))
		{
			return true;
		}
		else 
			return false;
		
	}
	public void generateUserName(int month)
	{
		
		userName=firstName.substring(0,3);
		userName+=month;
		userName+=panNumber;
	}
	public void displayData()
	{
		System.out.println("Username- "+userName);
		System.out.println("DOB- "+date);
	}

}
