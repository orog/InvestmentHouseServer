package com.Main.Support;

/*required7 - bid/ask
 * params - investor id, command type, stock id, min price, max price, amount
 * brief - send command to stock market
 * returns - command
 */
public class BidAskRequest {
	private Long accId;
	private Integer commandType;
	private String stockId;
	private String stockName;
	private double minPrice;
	private double maxPrice;
	private int amount;

	public BidAskRequest(Long accId, Integer commandType, String stockId, String stockName, double minPrice,
			double maxPrice, int amount) {
		super();
		this.accId = accId;
		this.commandType = commandType;
		this.stockId = stockId;
		this.stockName = stockName;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.amount = amount;
	}

	public BidAskRequest() {
	}

	public Long getAccId() {
		return accId;
	}

	public void setAccId(Long investorId) {
		this.accId = investorId;
	}

	public Integer getCommandType() {
		return commandType;
	}

	public void setCommandType(Integer commandType) {
		this.commandType = commandType;
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

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

}
