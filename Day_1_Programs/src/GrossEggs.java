
public class GrossEggs {
	public static void calculate(int number)
	{
		
		int ngross=0,ndozens=0, temp;
		ngross = number/144;
		temp = number%144;
		ndozens = temp/12;
		int temp1 = temp%12;
		System.out.println(ngross+" "+ndozens + " "+temp1);
		
		
	}

}
