package com.lti.service;

import java.util.List;

import com.lti.entity.Customer;

public interface CustomerService {


	public Customer addCustomer(Customer c, long userid);

	public Customer viewDetails(long customerid);

	public Customer validateUser(long customerid);

	public List<Customer> getCustomerList();
	
}
