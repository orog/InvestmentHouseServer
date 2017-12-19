package com.Main.Support;

/*required1
 * params - none.
 * method type GET
 * brief - show investor details
 * returns (using list of supporting class):id,name, email, status, balance, portfolio current value
 */

public class InvestorDetailsResponse {
	private Long accId;
	private String accName;
	private String email;
	private Integer statusId;
	private double balance;
	//private double currentWorth;
	
	
	public InvestorDetailsResponse(Long accId, String accName, String email, Integer statusId, double balance) {
		super();
		this.accId = accId;
		this.accName = accName;
		this.email = email;
		this.statusId = statusId;
		this.balance = balance;
	}

	public Long getAccId() {
		return accId;
	}

	public void setAccId(Long accId) {
		this.accId = accId;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String name) {
		this.accName = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


}
