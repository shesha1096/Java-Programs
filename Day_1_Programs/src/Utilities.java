
public class Utilities {
	public  Boolean isprime(int number)
	{
		Boolean flag = true;
		for(int i=2;i<number;i++)
		{
			if(number%i==0)
			{
				flag = false;
			}
		}
		return flag;
		
	}
	public int[] maxElement(int numbers[]){
		int max = numbers[0];int elepos=-1;
		int[] values = new int[2];
		for(int i=1;i<numbers.length; i++)
		{
			if(numbers[i]>max)
			{
				max = numbers[i];
				elepos = i;
			}
		}
		values[0] = max;
		values[1] = elepos;
		return values;
		
	}
	
	public int[] minElement(int numbers[]){
		int min = numbers[0];int elepos=-1;
		int[] values = new int[2];
		for(int i=1;i<numbers.length; i++)
		{
			if(numbers[i]<min)
			{
				min = numbers[i];
				elepos = i;
			}
		}
		values[0] = min;
		values[1] = elepos+1;
		return values;
		
	}

}
