package com.lti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;
import com.lti.entity.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value="select c from Customer c where c.useridcust = : userid")
	public Customer findByUserId(@Param ("userid") long userid );
}
