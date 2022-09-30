package com.lti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.entity.Beneficiary;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
	
	@Query(value="Select b from Beneficiary b where b.customerid.customerid= :customerid")
	public List<Beneficiary> getBeneficiaryByCustomerId(long customerid);
}
