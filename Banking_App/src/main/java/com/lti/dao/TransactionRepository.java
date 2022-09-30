package com.lti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.lti.entity.Transaction;


@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, Long>  {

	@Query(value="Select t from Transaction t where t.customerid.customerid= :customerid")
	public List<Transaction> getTransactionByCustomerId(long customerid);
}
