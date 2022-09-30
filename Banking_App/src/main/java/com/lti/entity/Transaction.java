package com.lti.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Transaction_Table")
public class Transaction {

	@Id
	@SequenceGenerator(name = "transactionSeqGen", sequenceName = "transactionSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "transactionSeqGen")
	private long trans_id;
	
	private String trans_type;
	private double trans_amount;
	//private Date date;
	private long from_accno;
	private long to_accno;
	private String remarks;
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name="customerid")
	Customer customerid;

	public long getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(long trans_id) {
		this.trans_id = trans_id;
	}

	public String getTrans_type() {
		return trans_type;
	}

	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}

	public double getTrans_amount() {
		return trans_amount;
	}

	public void setTrans_amount(double trans_amount) {
		this.trans_amount = trans_amount;
	}

//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}

	public long getFrom_accno() {
		return from_accno;
	}

	public void setFrom_accno(long from_accno) {
		this.from_accno = from_accno;
	}

	public long getTo_accno() {
		return to_accno;
	}

	public void setTo_accno(long to_accno) {
		this.to_accno = to_accno;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Customer getCustid() {
		return customerid;
	}

	public void setCustid(Customer custid) {
		this.customerid = custid;
	}

	public Transaction() {}
	
	public Transaction(long trans_id, String trans_type, double trans_amount, long from_accno, long to_accno,
			String remarks, boolean status, Customer custid) {
		super();
		this.trans_id = trans_id;
		this.trans_type = trans_type;
		this.trans_amount = trans_amount;
//		this.date = date;
		this.from_accno = from_accno;
		this.to_accno = to_accno;
		this.remarks = remarks;
		this.status = status;
		this.customerid = custid;
	}

	@Override
	public String toString() {
		return "Transaction [trans_id=" + trans_id + ", trans_type=" + trans_type + ", trans_amount=" + trans_amount
				+ ", from_accno=" + from_accno + ", to_accno=" + to_accno + ", remarks=" + remarks
				+ ", status=" + status + ", custid=" + customerid + "]";
	}
	
	
}
