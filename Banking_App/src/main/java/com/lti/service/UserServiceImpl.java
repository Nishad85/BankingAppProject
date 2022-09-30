package com.lti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.CustomerRepository;
import com.lti.dao.UserRepository;
import com.lti.entity.Customer;
import com.lti.entity.User;
import com.lti.entity.EmailDetails;
import com.lti.exception.NoAdminFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private CustomerRepository crepo;
	
	@Autowired
	private EmailService es;
	
	@Autowired private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}") private String sender;
	
	@Override
	@Transactional
	public User createUser(User data) {
		return urepo.save(data);
	}

	@Override
	public User viewDetails(long userid) {
		Optional<User> ufind = urepo.findById(userid);
	    User ugot= null;
	    if(ufind.isPresent()) {
	    	ugot=ufind.get();
	    }
	    return ugot;
	}

	@Override
	public User getUserBalance(long userid) throws NoAdminFoundException {
		Optional<User> ufind = urepo.findById(userid);
	    User ugot= null;
	    if(ufind.isPresent()) {
	    	ugot=ufind.get();
	    }
	    return ugot;
	}
	
	@Override
    @Transactional
    public List<User> getUsers() {
		
        return urepo.findAll();
    }

	@Override
	public List<User> getPendingUsers() {
		
		return urepo.getPendingUsers();
	}
	
	@Override
    @Transactional
    public Customer changeNetStatus(long customerid)
    {
		
        Optional<Customer> cfind = crepo.findById(customerid);
        Customer cgot= cfind.get();
        EmailDetails details = new EmailDetails();
        details.setRecipient(cgot.getUser().getEmail());
        details.setUsername(cgot.getCustomerid());
        details.setPassword(cgot.getPassword());
        es.sendSimpleMail(details);
        
        return cgot;
    }

	@Override
    @Transactional
    public User deleteUser(long userid) {
        Optional<User> ufind=urepo.findById(userid);
        User ugot=ufind.get();
        urepo.delete(ugot);
        return ugot;
    }
	
}
