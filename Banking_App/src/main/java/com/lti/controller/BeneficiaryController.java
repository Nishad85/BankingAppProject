package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Beneficiary;
import com.lti.service.BeneficiaryService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BeneficiaryController {
	
	@Autowired
    private BeneficiaryService bs;

    @GetMapping("/viewallbeneficiaries")
    public List<Beneficiary> getAllBeneficiary(){
        return bs.listOfBeneficiary();
    }

    @PostMapping("/createbeneficiary/{customerid}")
    public Beneficiary addBeneficiary(@RequestBody Beneficiary b,@PathVariable("customerid") long customerid) {
        return bs.createBeneficiary(b,customerid);
    }

    @GetMapping("/beneficiary/{customerid}")
    public List<Beneficiary> findBeneficiaryById(@PathVariable("customerid")long customerid){
        return (List<Beneficiary>) bs.findById(customerid);
    }
    
}
