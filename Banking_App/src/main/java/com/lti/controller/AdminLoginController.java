package com.lti.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Admin;

import com.lti.exception.NoAdminFoundException;
import com.lti.service.AdminService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AdminLoginController {

	@Autowired                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	 private AdminService as;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	
	@PostMapping("/adminregister")
	public Admin addAdmin(@RequestBody Admin al) {
		return as.createAdmin(al);
	}
	
	@GetMapping("/adminlogin/{adminId}")
	public Admin validateAdmin(@PathVariable("adminId") int adminId) throws NoAdminFoundException {
		return as.validate(adminId);
	}
	
}