package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.entity.User;
import com.lti.exception.NoAdminFoundException;
import com.lti.service.CustomerService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CustomerController {

	
	@Autowired
	private CustomerService cs;
	
	@GetMapping("/viewdetails/{customerid}")
	public Customer viewDetails(@PathVariable("customerid") long customerid) {
		return cs.viewDetails(customerid);
	}
	
	@PostMapping("/createcustomer/{userid}")
	public Customer createUser(@RequestBody Customer c, @PathVariable("userid") long userid) {
		return cs.addCustomer(c,userid);
	}
	
	@GetMapping("/customerlogin/{customerid}")
	public Customer validateUser(@PathVariable("customerid") long customerid) throws NoAdminFoundException {
		return cs.validateUser(customerid);
	}
	@GetMapping("/getcustomerlist")
    public List<Customer> getCustomerList(){
        return cs.getCustomerList();
    }
}
