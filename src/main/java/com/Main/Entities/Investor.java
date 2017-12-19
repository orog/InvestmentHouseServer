package com.Main.Entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Investor {

	/*
	 * private enum Status { APPROVED , PENDING};
	 * 
	 * private Status status;
	 */
	private Integer status;
	private double balance;

	private Long accId;
	private String accName;
	private String password;
	private String email;
	private Broker broker;

	private Collection<Command> commands;
	// @Column(name = "System_id")

	public Investor() {
		commands = new ArrayList<Command>();
	}

	public Investor(String name, String password, String email, Broker broker) {
		this.accName = name;
		this.password = password;
		this.email = email;
		this.broker = broker;
		//this.setStatus(0);
		this.status = 1 ;
		commands = new ArrayList<Command>();
	}

	public void setAccId(Long id) {
		this.accId = id;
	}

	public void setAccName(String name) {
		this.accName = name;
	}

	/*
	 * @Enumerated(EnumType.STRING) public Status getStatus() { return status; }
	 * 
	 * public void setStatus(Status status) { this.status = status; }
	 */

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@ManyToOne
	public Broker getBroker() {
		return broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Id
	@GeneratedValue
	@Column(name = "INV_ID")
	public Long getAccId() {
		return accId;
	}

	public String getAccName() {
		return accName;
	}

	public String getPassword() {
		return password;
	}

	@Column(unique = true)
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Investor [id=" + accId + ", name=" + accName + ", email=" + email + ", Broker=" + broker + "]";
	}

	@OneToMany
	public Collection<Command> getCommands() {
		return commands;
	}

	public void setCommands(Collection<Command> commands) {
		this.commands = commands;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
