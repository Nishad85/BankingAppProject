package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Customer_Table")
public class Customer {
	
	@Id
	@SequenceGenerator(name = "customerSeqGen", sequenceName = "customerSeq", initialValue = 1001, allocationSize = 1)
    @GeneratedValue(generator = "customerSeqGen")
	private long customerid;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accno;
	private String acctype;
	private double accbal;
	private String password;
	private long useridcust;
	
	@OneToOne
	@JoinColumn(name="userid")
	User user;
	
	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public double getAccbal() {
		return accbal;
	}

	public void setAccbal(double accbal) {
		this.accbal = accbal;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getUseridcust() {
		return useridcust;
	}

	public void setUseridcust(long useridcust) {
		this.useridcust = useridcust;
	}

	public Customer() {}
	
	
	public Customer(long customerid, long accno, String acctype, double accbal, String password, long useridcust,
			User user) {
		super();
		this.customerid = customerid;
		this.accno = accno;
		this.acctype = acctype;
		this.accbal = accbal;
		this.password = password;
		this.useridcust = useridcust;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", accno=" + accno + ", acctype=" + acctype + ", accbal=" + accbal
				+ ", password=" + password + ", useridcust=" + useridcust + ", user=" + user + "]";
	}

	
	
	
}
