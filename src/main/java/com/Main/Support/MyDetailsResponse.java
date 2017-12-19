package com.Main.Support;


/*required4 - my details (investor)
 * params - investor id
 * returns - name, email, balance, status
 */
public class MyDetailsResponse {
	
	private String accName;
	private String email;
	private double balance;
	private Integer statusId; 
	
public MyDetailsResponse(String name, String email, double balance, Integer status) {
		super();
		this.accName = name;
		this.email = email;
		this.balance = balance;
		this.statusId = status;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer status) {
		this.statusId = status;
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
