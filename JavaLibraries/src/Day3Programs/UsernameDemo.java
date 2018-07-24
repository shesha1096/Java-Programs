package Day3Programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class UsernameDemo {
	static int count=0;
	public static void main(String[] args)
	{
		Map<String,String> usersMap = new HashMap<>();
		Boolean flag = false;
		String user_name="";
		BufferedReader bufferedReader=null;
		String s=null;
		while(count<=3)
		{
			System.out.println("Enter the username that you want to search for");
			user_name = new Scanner(System.in).next();
			System.out.println("Enter the password");
			String password = new Scanner(System.in).next();
			FileReader fileReader = null;
			try {
				fileReader = new FileReader("userinfo.txt");
				bufferedReader = new BufferedReader(fileReader);


				while( (s=bufferedReader.readLine())!=null)
				{

					String[] tokens= s.split(" ");
					
					usersMap.put(tokens[0],tokens[1]);
					
				}
					 Iterator it = usersMap.entrySet().iterator();
					    while (it.hasNext()) {
					        Map.Entry pair = (Map.Entry)it.next();
					       // System.out.println(pair.getKey());
					        if(pair.getKey().equals(user_name.toLowerCase()) && pair.getValue().toString().equals(password))
					        {
					        	flag = true;
					        }



				}

				if(flag==false)
				{
					count++;
					if(count==3)
					{
						System.out.println(count);
						System.out.println("You are allowed a maximum of 3 tries, program will terminate now.");
						System.exit(0);
					}
				}else{
					System.out.println("Username- "+user_name+" found");
					System.exit(1);
				}
				}
			
			



			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			catch(NullPointerException e)
			{
				e.printStackTrace();
			}
			finally{
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
