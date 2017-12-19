package com.Main.Support;

/*required8 - stocks from stock market
 * params - none
 * brief -
 * returns - stock id, stock name, actual worth
 */
public class StockMarketResponse {
	
	private String stockId;
	private String stockName;
	private double actualWorth;

	public StockMarketResponse() {
	}
	
	public StockMarketResponse(String stockId, String stockName, double actualWorth) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.actualWorth = actualWorth;
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

	public double getActualWorth() {
		return actualWorth;
	}

	public void setActualWorth(double actualWorth) {
		this.actualWorth = actualWorth;
	}
	
	
}
