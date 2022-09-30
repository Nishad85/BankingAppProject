package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Admin_Table")
public class Admin {
	
	@Id
	@SequenceGenerator(name = "adminSeqGen", sequenceName = "adminSeq", initialValue = 123, allocationSize = 1)
    @GeneratedValue(generator = "adminSeqGen")
	private int admin_id;
	private String password;

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", password=" + password + "]";
	}
	
	
	
}
