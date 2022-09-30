package com.lti.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.CustomerRepository;
import com.lti.dao.UserRepository;
import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.entity.User;
import com.lti.exception.NoAdminFoundException;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private CustomerRepository crepo;
	
	

	@Override
	@Transactional 
	public Customer addCustomer(Customer c, long userid) {

		Optional<User> ufind= urepo.findById(userid);
		User ugot=null;
		Random random = new Random();
		int min = 10000000;
		int max = 99999999;
		int accountNumber = min+random.nextInt(max);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		int length = 8;
		for(int i = 0; i < length; i++) {
		      int index = random.nextInt(alphabet.length());
		      char randomChar = alphabet.charAt(index);
		      sb.append(randomChar);
		    }
		String randomString = sb.toString();
		if(ufind.isPresent()) {
			ugot=ufind.get();
			ugot.setStatus("Approved");
			urepo.save(ugot);
			c.setUseridcust(userid);
			c.setUser(ugot);
			c.setAccno(accountNumber);
			c.setPassword(randomString);
			c.setAcctype("savings");
			c.setAccbal(ugot.getAnnincome());
		}
		return crepo.save(c);
	}


	@Override
	public Customer viewDetails(long customerid) {
		Optional<Customer> cust = crepo.findById(customerid);
		Customer custfind = null;
		if(cust.isPresent()) {
			custfind=cust.get();
			return custfind;
		}
		return custfind;
	}


	@Override
	public Customer validateUser(long customerid) {
		Optional<Customer> clFind = crepo.findById(customerid);
		Customer clGot = null;
		if(clFind.isPresent()) {
			clGot= clFind.get();
			
			
			
		}                
		
		return clGot;	}


	@Override
	public List<Customer> getCustomerList() {
		return crepo.findAll();
	}
	
}
