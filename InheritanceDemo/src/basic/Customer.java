package basic;

public class Customer extends Person {
	private long customerID;
	private String mobNo;
	private static int count=0;
	public Customer( String mobNo,String name, int age) {
		super(name,age);
		this.mobNo = mobNo;
		this.customerID = ++count;
		
	}
	public Customer() {
		super();
		this.customerID = ++count;
	}
	public long getCustomerID() {
		return customerID;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	
	

}
