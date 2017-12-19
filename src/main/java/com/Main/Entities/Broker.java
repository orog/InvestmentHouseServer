package com.Main.Entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Broker {

	private Long accId;
	private String accName;
	private String password;
	private String email;
	
	private Collection<Investor> investors;


    public Broker(String name, String password, String email) {
		this.accName = name;
		this.password = password;
		this.email = email;
		investors = new ArrayList<Investor>();
	}

	public Broker() { 
		investors = new ArrayList<Investor>();
    }

    @Id
    @GeneratedValue
    @Column(name = "BRK_ID")
	public Long getAccId() {
		return accId;
	}

	public void setAccId(Long id) {
		this.accId = id;
	}
	@OneToMany
	public Collection<Investor> getInvestors() {
		return investors;
	}

	public void setInvestors(Collection<Investor> investors) {
		this.investors = investors;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String name) {
		this.accName = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(unique = true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Broker [id=" + accId + ", name=" + accName + ", email=" + email + "]";
	}


    
}
