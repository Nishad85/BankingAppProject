package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Beneficiary_Table")
public class Beneficiary {

	@Id
	@SequenceGenerator(name = "benSeqGen", sequenceName = "benSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "benSeqGen")
	private long beneficiaryid;
	
	private String ben_name;
	private long ben_accno;
	private String nickname;
	
	@ManyToOne
	@JoinColumn(name="customerid")
	Customer customerid;

	public long getBeneficiaryid() {
		return beneficiaryid;
	}

	public void setBeneficiaryid(long beneficiaryid) {
		this.beneficiaryid = beneficiaryid;
	}

	public String getBen_name() {
		return ben_name;
	}

	public void setBen_name(String ben_name) {
		this.ben_name = ben_name;
	}

	public long getBen_accno() {
		return ben_accno;
	}

	public void setBen_accno(long ben_accno) {
		this.ben_accno = ben_accno;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Customer getCustid() {
		return customerid;
	}

	public void setCustid(Customer custid) {
		this.customerid = custid;
	}
	
	public Beneficiary() {}
	
	public Beneficiary(long beneficiaryid, String ben_name, long ben_accno, String nickname, Customer custid) {
		super();
		this.beneficiaryid = beneficiaryid;
		this.ben_name = ben_name;
		this.ben_accno = ben_accno;
		this.nickname = nickname;
		this.customerid = custid;
	}

	@Override
	public String toString() {
		return "Beneficiary [beneficiaryid=" + beneficiaryid + ", ben_name=" + ben_name + ", ben_accno=" + ben_accno
				+ ", nickname=" + nickname + ", custid=" + customerid + "]";
	}
	
}
