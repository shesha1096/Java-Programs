package com.dao.interfaces;

import com.classes.User;

public interface CustomerLoginDao {
	public User checkUser(String username,String password);
	public boolean loginUser();

}
