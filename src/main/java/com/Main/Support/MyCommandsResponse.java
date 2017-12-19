package com.Main.Support;

public class MyCommandsResponse {
	private Long myCommandId;
	private Integer cmdType;
	private String stockName;
	private String stockId;
	private double minPrice; 
	private double maxPrice;
	private int amount;
	private Integer cmdStatusId;
	
	
	public MyCommandsResponse(Long cmdId, Integer cmdType, String stockName, String stockId, double minPrice,
			double maxPrice, int amount, Integer cmdStatusId) {
		super();
		this.myCommandId = cmdId;
		this.cmdType = cmdType;
		this.stockName = stockName;
		this.stockId = stockId;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.amount = amount;
		this.cmdStatusId = cmdStatusId;
	}
	
	
	public MyCommandsResponse() {
		super();
	}


	public Long getMyCommandId() {
		return myCommandId;
	}
	public void setMyCommandId(Long cmdId) {
		this.myCommandId = cmdId;
	}
	public Integer getCmdType() {
		return cmdType;
	}
	public void setCmdType(Integer cmdType) {
		this.cmdType = cmdType;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Integer getCmdStatusId() {
		return cmdStatusId;
	}
	public void setCmdStatusId(Integer cmdStatusId) {
		this.cmdStatusId = cmdStatusId;
	}
	
	
}
