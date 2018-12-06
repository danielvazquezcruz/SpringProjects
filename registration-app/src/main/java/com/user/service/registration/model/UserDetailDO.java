package com.user.service.registration.model;

public class UserDetailDO {
	
	private String userName;
	private String password;
	private String dob;
	private String ssn;
	
	public UserDetailDO(String userName, String password, String dob, String ssn){
		super();
		this.userName = userName;
		this.password = password;
		this.dob = dob;
		this.ssn = ssn;
		
	}
	
	public UserDetailDO() {
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	

}
