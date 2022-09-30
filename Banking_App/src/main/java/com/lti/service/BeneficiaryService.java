package com.lti.service;

import java.util.List;

import com.lti.entity.Beneficiary;

public interface BeneficiaryService {

	List<Beneficiary> findById(long customerid);


	List<Beneficiary> listOfBeneficiary();

	Beneficiary createBeneficiary(Beneficiary b, long customerid);

}
