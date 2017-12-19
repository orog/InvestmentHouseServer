package com.Main.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Command {
    
	private Investor investor;
    private Long commandId;
    private Integer commandType;
    private String stockId;
    private String stockName;
    private Integer status;
    private int initAmount;
    private int actualAmount;
    private double finalPrice;
    private double minPrice;
    private double maxPrice;
    private Date lastModified;

 


    public Command(){}

    public Command(Investor investor, int initAmount, Integer commandType, Long commandId,
			/*CommandType commandType,*/ double minPrice, double maxPrice, String stockId, String stockName) {
		this.setInvestor(investor);
		this.initAmount = initAmount;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.commandType = commandType;
		this.commandId = commandId; 
		this.finalPrice = 0;
		this.stockId = stockId;
		this.stockName = stockName;
		this.status = 1;
		this.actualAmount = 0;
		this.lastModified = new Date();
    }

	@Override
	public String toString() {
		return "Command [investor=" + investor + ", commandId=" + commandId + ", commandType=" + commandType
				+ ", stockId=" + stockId + ", status=" + status + ", amount=" + initAmount + ", finalPrice=" + finalPrice
				+ ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + "]";
	}

	@Id
	public Long getCommandId() {
		return commandId;
	}

	public void setCommandId(Long transactionId) {
		this.commandId = transactionId;
	}


	public int getInitAmount() {
		return initAmount;
	}

	public void setInitAmount(int initAmount) {
		this.initAmount = initAmount;
	}

	public Integer getCommandType() {
		return commandType;
	}

	public void setCommandType(Integer commandType) {
		this.commandType = commandType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	@ManyToOne
	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(int actualAmount) {
		this.actualAmount = actualAmount;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}
