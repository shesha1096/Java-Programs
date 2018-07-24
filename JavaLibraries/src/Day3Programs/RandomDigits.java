package Day3Programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class RandomDigits {
	public static String readData()
	{
		FileReader fileReader=null;
		String data="";
		try{
			fileReader = new FileReader("data.txt");
		}catch(FileNotFoundException e){

		}

		BufferedReader br = new BufferedReader(fileReader);

		try{

			data = br.readLine();
			if(data.isEmpty())
			{
				return null;
			}
		}catch(IOException e)
		{

		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data;
	}
	public static void main(String[] args)
	{
		int number=0;
		try{
			//number = Integer.parseInt(args[0]);
			number = Integer.parseInt(readData());
			if(number<0)
			{
				throw new NoNegativeException();
			}
			Random random = new Random();
			int randomNumber = random.nextInt(10);
			System.out.println(randomNumber);
			int result = number/randomNumber;
			System.out.println(result);
		}catch(ArithmeticException e)
		{
			System.out.println(e.toString());
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e.toString());
		}catch(NoNegativeException e)
		{
			//	System.out.println("Do not enter negative inputs");
			System.out.println(e.toString());

		}catch(NullPointerException e)
		{
			e.printStackTrace();
		}
	}

}
