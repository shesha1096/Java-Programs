package Day3Programs;

public class NoNegativeException extends Exception {
	public NoNegativeException()
	{
		
	}
	public String toString()
	{
		return getClass().getName()+ ":"+"No negative inputs";
	}

}
