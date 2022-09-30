package com.lti.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminRepository;
import com.lti.entity.Admin;
import com.lti.exception.NoAdminFoundException;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository arepo;

	@Override
	@Transactional
	public Admin createAdmin(Admin al) {
		return arepo.save(al);
	}

	@Override
	public Admin validate(int adminId) throws NoAdminFoundException{
		
		Optional<Admin> alFind = arepo.findById(adminId);
		Admin alGot = null;
		if(alFind.isPresent()) {
			alGot= alFind.get();
		}                             
		else{
			throw new NoAdminFoundException("Admin Not Present in Database.");
		}
		
		return alGot;
}

}