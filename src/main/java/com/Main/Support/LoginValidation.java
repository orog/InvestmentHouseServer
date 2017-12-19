package com.Main.Support;



public class LoginValidation {

	private Long accID;
	private boolean valid;
	private String accName;
	private Integer accountType; // 1- investor, 2- broker
	private Integer accountStatus; // 1- pending, 2- authorized
	public LoginValidation(Long id, String accName, Integer accountType, boolean valid , Integer accountStatus) {
		super();
		this.accID = id;
		this.accName=accName;
		this.accountType = accountType;
		this.valid = valid;
		this.accountStatus = accountStatus;
		
	}

	public void setType(Integer type) {
		this.accountType = type;
	}

	public LoginValidation(boolean valid) {
		super();
		if (!valid) {
			this.accID = -1L;
			this.accName = "";
			this.accountType = -1;
			this.valid = false;
			this.accountStatus = -1;
		}
	}

	public LoginValidation() {
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int type) {
		this.accountType = type;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String name) {
		this.accName = name;
	}

	public Long getAccId() {
		return accID;
	}

	public void setAccId(Long id) {
		this.accID = id;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Integer getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}

}
