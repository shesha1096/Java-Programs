package InterfacesDemo;

public class MySortedList implements MyList {
	private int arr[];
	public MySortedList(int[] arr)
	{
		this.arr = arr;
	}

	@Override
	public void add(int a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get(int index) {
		// TODO Auto-generated method stub
		return arr[index];
	}
	public void sort(int a[])
	{
		for(int i=0;i<10;i++)
		{
			for(int j=i+1;j<10;j++)
			{
				if(a[i]>a[j])
				{
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("The sorted elements are:");
		for(int k=0;k<10;k++)
		{
			System.out.print(a[k]+" ");
		}
	}
	

}
