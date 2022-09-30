                                                                                                                                                           package com.lti.service;

import com.lti.entity.Admin;
import com.lti.exception.NoAdminFoundException;

public interface AdminService{

	
	public Admin createAdmin(Admin al);

	
	public Admin validate(int adminId) throws NoAdminFoundException;
}
