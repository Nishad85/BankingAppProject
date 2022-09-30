package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Customer;
import com.lti.entity.User;
import com.lti.exception.NoAdminFoundException;
import com.lti.service.UserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	private UserService us;
	
	@PostMapping("/register")
	public User createUser(@RequestBody User u) {
		return us.createUser(u);
	}
	
	@GetMapping("/finduser/{userid}")
	public User getUser(@PathVariable("userid") long userid) throws NoAdminFoundException {
		return us.viewDetails(userid);
	}
	
	@GetMapping("/getuserbalance/{userid}")
	public User getUserBalance(@PathVariable("userid") long userid) throws NoAdminFoundException {
		return us.viewDetails(userid);
	}
	
	@GetMapping("/admindashboard")
    public List<User> getUsers(){
        return us.getUsers();
    }
	
	@GetMapping("/admindashboard/pendingusers")
	public List<User> getPendingUsers(){
		return us.getPendingUsers();
	}
	
	@PostMapping("/changenetbanking/{customerid}")
    public Customer changeNetStatus(@PathVariable("customerid") long customerid)
    {
        return us.changeNetStatus(customerid);
    }
	
	@PostMapping("/deleteuser/{userid}")
    public User deleteUser(@PathVariable("userid") long userid) {
        return us.deleteUser(userid);
    }
	
}
