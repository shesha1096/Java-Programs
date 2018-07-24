import java.util.Scanner;



public class OperatorsDemo {
	public static void main(String args[])
	{
		byte b1 =10;
		int i1 = 10;
		byte b3 = (byte) i1;
		float f1 = 3.15f; //By default 3.14 is interpreted as double
		float f2 = 10; //Automatic promotion
		char ch = '\u0041';
		System.out.println(ch);
		int y=0;
		System.out.println(y+10);

		String name;;
		Scanner sc = new Scanner(System.in);
		/*System.out.println("Enter your name");
		name =sc.next();
		System.out.println("Your name is:"+name);
		try{
		System.out.println("Enter a number");
		i1 = sc.nextInt();
		String numbers[] = {"zero","one","two","three"};
		System.out.println("Entered number is:"+ numbers[i1]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.toString());
		}*/
		 
		/*int number;
		System.out.println("Enter a number");
		number = sc.nextInt();
		Utilities utility = new Utilities();
		Boolean flag = utility.isprime(number);
		if(flag)
		{
			System.out.println(number+ " is a prime number");
		}
		else
			System.out.println(number+" is not a prime number");
		
		int values[] = new int[2];
		int num[] = {4,5,6,10,9};
		 values = utility.minElement(num);
		System.out.println("The minimum element is "+ values[0]+" found at position "+values[1]);
		values = utility.maxElement(num);
		System.out.println("The maximum element is "+ values[0]+" found at position "+values[1]);
		
		int i=0;
		int j=0;
		Boolean bool = (i>=j) && (j++>i);
		System.out.println(j);*/
		int i=4;
		int j = 5;
		int k = (i>j)?10:5;
		System.out.println(k);
		int b = -1;
		System.out.println(b>>>2);
		System.out.println(Integer.toBinaryString(b));
		System.out.println(2<<31);
		byte b2 = 10;
		b2+=1;
		System.out.println(b2);
		int ii=65;
		char c=(char) ii;
		System.out.println(c);
		GrossEggs.calculate(1442);


	}


}
