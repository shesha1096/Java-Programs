package Clients;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Day3Programs.Account;

public class UserClient {
	public static void main(String[] args)
	{
		List<Account> usersList = new ArrayList<>();
		Boolean flag = true;
		do
		{
		Account account = new Account();
		account.readData();
		account.displayData();
		System.out.println("Do you wish to continue? (Yes or No)");
		String choice = new Scanner(System.in).next();
		if(choice.toLowerCase().equals("no"))
		{
			flag = false;
		}else
		{
			usersList.add(account);
		}
		}while(flag);
	}

}
