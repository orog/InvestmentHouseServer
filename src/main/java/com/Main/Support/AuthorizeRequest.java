package com.Main.Support;


public class AuthorizeRequest {
	private Long accId;
	private Integer statusID;
	private Double balance;
	public AuthorizeRequest(Long accId, Integer statusId, double balance) {
		super();
		this.accId = accId;
		this.statusID = statusId;
		this.balance = balance;
	}
	public AuthorizeRequest() {
		super();
	}
	public Long getAccId() {
		return accId;
	}
	public void setAccId(Long investorId) {
		this.accId = investorId;
	}
	public Integer getStatusId() {
		return statusID;
	}
	public void setStatusId(Integer status) {
		this.statusID = status;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}
