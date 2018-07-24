package basic;

public class Utility {
	public static void printDetails(Person person)
	{
		if(person instanceof Customer)
		{
			System.out.println("Your name is: "+ person.getName()+
					" and you are eligible for 10 points");
			System.out.println(((Customer) person).getMobNo());
		}
		else if(person instanceof Manager)
		{
			System.out.println(person.toString());
		}
		
	}

}
