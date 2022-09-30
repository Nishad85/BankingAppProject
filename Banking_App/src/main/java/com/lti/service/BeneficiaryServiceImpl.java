package com.lti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.BeneficiaryRepository;
import com.lti.dao.CustomerRepository;
import com.lti.entity.Beneficiary;
import com.lti.entity.Customer;
import com.lti.entity.User;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService{

	@Autowired
	private BeneficiaryRepository brepo;
	
	@Autowired
	private CustomerRepository crepo;
	    

    @Override
    public List<Beneficiary> listOfBeneficiary() {
        return brepo.findAll();
    }

    @Override
    public List<Beneficiary> findById(long customerid){
    	List<Beneficiary> bfind = brepo.getBeneficiaryByCustomerId(customerid);
        
        return bfind;
    }

	@Override
	@Transactional
	public Beneficiary createBeneficiary(Beneficiary b, long customerid) {
		Optional<Customer> cfind= crepo.findById(customerid);
		Customer cgot=null;
		if(cfind.isPresent()) {
			cgot= cfind.get();
			b.setCustid(cgot);
		}
		return brepo.save(b);
	}

	
	
}
