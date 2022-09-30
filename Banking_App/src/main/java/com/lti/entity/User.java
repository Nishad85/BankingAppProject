package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="User_Table")
public class User {
	
	@Id
	@SequenceGenerator(name = "userSeqGen", sequenceName = "userSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "userSeqGen")
	private long userid;
	
	private String title;
	private String firstname;
	private String middlename;
	private String lastname;
	private String fathername;
	private long mobile;
	private String email;
	private long aadhar;
	private String dob;
	private String resaddrlane1;
    private String resaddrlane2;
    private String reslandmark;
    private String resstate;
    private String rescity;
    private String respincode;
    private String peraddrlane1;
    private String peraddrlane2;
    private String perlandmark;
    private String perstate;
    private String percity;
    private String perpincode;
    private String occutype;
    private String incsource;
    private long annincome;
	private boolean netbanking;
	private String status;
	
	
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getResaddrlane1() {
		return resaddrlane1;
	}
	public void setResaddrlane1(String resaddrlane1) {
		this.resaddrlane1 = resaddrlane1;
	}
	public String getResaddrlane2() {
		return resaddrlane2;
	}
	public void setResaddrlane2(String resaddrlane2) {
		this.resaddrlane2 = resaddrlane2;
	}
	public String getReslandmark() {
		return reslandmark;
	}
	public void setReslandmark(String reslandmark) {
		this.reslandmark = reslandmark;
	}
	public String getResstate() {
		return resstate;
	}
	public void setResstate(String resstate) {
		this.resstate = resstate;
	}
	public String getRescity() {
		return rescity;
	}
	public void setRescity(String rescity) {
		this.rescity = rescity;
	}
	public String getRespincode() {
		return respincode;
	}
	public void setRespincode(String respincode) {
		this.respincode = respincode;
	}
	public String getPeraddrlane1() {
		return peraddrlane1;
	}
	public void setPeraddrlane1(String peraddrlane1) {
		this.peraddrlane1 = peraddrlane1;
	}
	public String getPeraddrlane2() {
		return peraddrlane2;
	}
	public void setPeraddrlane2(String peraddrlane2) {
		this.peraddrlane2 = peraddrlane2;
	}
	public String getPerlandmark() {
		return perlandmark;
	}
	public void setPerlandmark(String perlandmark) {
		this.perlandmark = perlandmark;
	}
	public String getPerstate() {
		return perstate;
	}
	public void setPerstate(String perstate) {
		this.perstate = perstate;
	}
	public String getPercity() {
		return percity;
	}
	public void setPercity(String percity) {
		this.percity = percity;
	}
	public String getPerpincode() {
		return perpincode;
	}
	public void setPerpincode(String perpincode) {
		this.perpincode = perpincode;
	}
	public String getOccutype() {
		return occutype;
	}
	public void setOccutype(String occutype) {
		this.occutype = occutype;
	}
	public String getIncsource() {
		return incsource;
	}
	public void setIncsource(String incsource) {
		this.incsource = incsource;
	}
	public long getAnnincome() {
		return annincome;
	}
	public void setAnnincome(long annincome) {
		this.annincome = annincome;
	}
	public boolean isNetbanking() {
		return netbanking;
	}
	public void setNetbanking(boolean netbanking) {
		this.netbanking = netbanking;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public User() {}
	
	public User(long userid, String title, String firstname, String middlename, String lastname, String fathername,
			long mobile, String email, long aadhar, String dob, String resaddrlane1, String resaddrlane2,
			String reslandmark, String resstate, String rescity, String respincode, String peraddrlane1,
			String peraddrlane2, String perlandmark, String perstate, String percity, String perpincode,
			String occutype, String incsource, long annincome, boolean netbanking, String status) {
		super();
		this.userid = userid;
		this.title = title;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.fathername = fathername;
		this.mobile = mobile;
		this.email = email;
		this.aadhar = aadhar;
		this.dob = dob;
		this.resaddrlane1 = resaddrlane1;
		this.resaddrlane2 = resaddrlane2;
		this.reslandmark = reslandmark;
		this.resstate = resstate;
		this.rescity = rescity;
		this.respincode = respincode;
		this.peraddrlane1 = peraddrlane1;
		this.peraddrlane2 = peraddrlane2;
		this.perlandmark = perlandmark;
		this.perstate = perstate;
		this.percity = percity;
		this.perpincode = perpincode;
		this.occutype = occutype;
		this.incsource = incsource;
		this.annincome = annincome;
		this.netbanking = netbanking;
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", title=" + title + ", firstname=" + firstname + ", middlename="
				+ middlename + ", lastname=" + lastname + ", fathername=" + fathername + ", mobile=" + mobile
				+ ", email=" + email + ", aadhar=" + aadhar + ", dob=" + dob + ", resaddrlane1=" + resaddrlane1
				+ ", resaddrlane2=" + resaddrlane2 + ", reslandmark=" + reslandmark + ", resstate=" + resstate
				+ ", rescity=" + rescity + ", respincode=" + respincode + ", peraddrlane1=" + peraddrlane1
				+ ", peraddrlane2=" + peraddrlane2 + ", perlandmark=" + perlandmark + ", perstate=" + perstate
				+ ", percity=" + percity + ", perpincode=" + perpincode + ", occutype=" + occutype + ", incsource="
				+ incsource + ", annincome=" + annincome + ", netbanking=" + netbanking + ", status=" + status + "]";
	}
	
	
}
