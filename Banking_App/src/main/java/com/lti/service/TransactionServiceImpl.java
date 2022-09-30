package com.lti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.BeneficiaryRepository;
import com.lti.dao.CustomerRepository;
import com.lti.dao.TransactionRepository;
import com.lti.entity.Beneficiary;
import com.lti.entity.Customer;
import com.lti.entity.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository trepo;
	
	@Autowired
	private BeneficiaryRepository brepo;
	
	@Autowired
	private CustomerRepository crepo;
	
	@Override
	public List<Transaction> findById(long customerid) {
		return trepo.getTransactionByCustomerId(customerid);
	}

	@Override
	public List<Transaction> listOfTransactions() {
		
		return trepo.findAll();
	}

	
	

	@Override
	
	//IMPS Transaction
	public Transaction createTransactionImps(Transaction t,long customerid) {
		List<Beneficiary> bfind = brepo.getBeneficiaryByCustomerId(customerid);
		Optional<Customer> cfind = crepo.findById(customerid);
		Customer c= cfind.get();
		
		for(Beneficiary b : bfind) {
			if(t.getTo_accno() == b.getBen_accno()) {
				c.setAccbal(c.getAccbal()-t.getTrans_amount());
				t.setCustid(c);
				crepo.save(c);
				break;
			}
		}	
		return trepo.save(t);
	}
	
	//NEFT Transaction
		@Override
		public Transaction createTransactionNeft(Transaction t,long customerid) {
			List<Beneficiary> bfind = brepo.getBeneficiaryByCustomerId(customerid);
			Optional<Customer> cfind = crepo.findById(customerid);
			Customer c= cfind.get();
			
			for(Beneficiary b : bfind) {
				if(t.getTo_accno() == b.getBen_accno()) {
					c.setAccbal(c.getAccbal()-t.getTrans_amount());
					t.setCustid(c);
					crepo.save(c);
					break;
				}
			}
			return trepo.save(t);
		}
		
		//RTGS Transaction
		@Override
		public Transaction createTransactionRtgs(Transaction t,long customerid) {
			List<Beneficiary> bfind = brepo.getBeneficiaryByCustomerId(customerid);
			Optional<Customer> cfind = crepo.findById(customerid);
			Customer c= cfind.get();
			
			for(Beneficiary b : bfind) {
				if(t.getTo_accno() == b.getBen_accno()) {
					c.setAccbal(c.getAccbal()-t.getTrans_amount());
					t.setCustid(c);
					crepo.save(c);
					break;
				}
			}	
			return trepo.save(t);
		}

}
