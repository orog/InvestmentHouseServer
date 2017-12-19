package com.Main.Support;

/*required5 - update my details (investor)
 * params - investorId, name, email, password
 * brief - if error was detected - no update
 * returns - success
 */
public class UpdateInvestorRequest {
	private Long accId;
	private String accName;
	private String email;
	private String password;
	
	
	public UpdateInvestorRequest(Long investorId, String name, String email, String password) {
		this.accId = investorId;
		this.accName = name;
		this.email = email;
		this.password = password;
	}

	public UpdateInvestorRequest() {} 
	
	public Long getAccId() {
		return accId;
	}
	
	
	public void setAccId(Long investorId) {
		this.accId = investorId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
