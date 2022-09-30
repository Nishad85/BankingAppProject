package com.lti.service;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.lti.entity.Customer;
import com.lti.entity.User;
import com.lti.exception.NoAdminFoundException;

public interface UserService {

	public User createUser(User data);
	
	public User viewDetails(long userid);
	public User getUserBalance(@PathVariable("userid") long userid) throws NoAdminFoundException;

	public List<User> getUsers();

	public List<User> getPendingUsers();

	public Customer changeNetStatus(long customerid);

	public User deleteUser(long userid); 
	
}
