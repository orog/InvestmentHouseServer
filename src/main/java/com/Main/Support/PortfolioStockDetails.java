package com.Main.Support;

/*required3 - report portfolio
 * params - investorId
 * 
 * returns list of - stock id, stock name, current value, total purchase value, amount 
 */
public class PortfolioStockDetails {

	private String stockId;
	private String stockName;
	private double currentWorth;
	private double purchaseValue;
	private int amount;
	private int totalPurchased;

	public PortfolioStockDetails(String stockId, String stockName, double currentWorth, double totPurchaseVal,
			int amount) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.currentWorth = currentWorth;
		this.purchaseValue = totPurchaseVal;
		this.amount = amount;
	}

	public PortfolioStockDetails() {
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getCurrentWorth() {
		return currentWorth;
	}

	public void setCurrentWorth(double currentWorth) {
		this.currentWorth = currentWorth;
	}

	public double getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(double totPurchaseVal) {
		this.purchaseValue = totPurchaseVal;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTotalPurchased() {
		return totalPurchased;
	}

	public void setTotalPurchased(int totalPurchased) {
		this.totalPurchased = totalPurchased;
	}

}
