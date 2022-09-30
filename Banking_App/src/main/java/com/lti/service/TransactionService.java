package com.lti.service;

import java.util.List;

import com.lti.entity.Transaction;

public interface TransactionService {


	Transaction createTransactionNeft(Transaction b,long customerid);

	List<Transaction> findById(long customerid);

	List<Transaction> listOfTransactions();

	Transaction createTransactionRtgs(Transaction b,long customerid);

	Transaction createTransactionImps(Transaction b,long customerid);

}
