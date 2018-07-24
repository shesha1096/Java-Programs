package InterfacesDemo;

public class MyArrayList implements MyList{
	private int arr[];
	private static int i=0;
	public MyArrayList()
	{
		arr = new int[12];
	}
	@Override
	public void add(int a) {
		// TODO Auto-generated method stub
		arr[++i] = a;
		
	}

	@Override
	public int get(int index) {
		// TODO Auto-generated method stub
		return arr[index];
	}

}
