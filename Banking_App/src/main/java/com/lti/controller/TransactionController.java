package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Transaction;
import com.lti.service.TransactionService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TransactionController {

	@Autowired
    private TransactionService ts;

    @GetMapping("/viewalltransaction")
    public List<Transaction> getAllTransaction(){
        return ts.listOfTransactions();
    }

    @PostMapping("/neft/{customerid}")
    public Transaction addTransactionNeft(@RequestBody Transaction b,@PathVariable("customerid")long customerid) {
        return ts.createTransactionNeft(b,customerid);
    }
    
    @PostMapping("/rtgs/{customerid}")
    public Transaction addTransactionRtgs(@RequestBody Transaction b,@PathVariable("customerid")long customerid) {
        return ts.createTransactionRtgs(b,customerid);
    }
    
    @PostMapping("/imps/{customerid}")
    public Transaction addTransactionImps(@RequestBody Transaction b,@PathVariable("customerid")long customerid) {
        return ts.createTransactionImps(b,customerid);
    }
    
    @GetMapping("/viewalltransaction/{customerid}")
    public List<Transaction> findTransactionById(@PathVariable("customerid")long customerid){
        return (List<Transaction>) ts.findById(customerid);
    }
	
}
