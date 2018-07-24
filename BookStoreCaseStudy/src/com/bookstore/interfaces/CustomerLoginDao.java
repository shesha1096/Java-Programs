package com.bookstore.interfaces;

public interface CustomerLoginDao {
	public boolean checkUser(String username,String password);
	public boolean loginUser();

}
