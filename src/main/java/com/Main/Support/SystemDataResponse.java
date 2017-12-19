package com.Main.Support;

public class SystemDataResponse {
	
	private double revenue;
	private double commission;
	public double getRevenue() {
		return revenue;
	}
	public SystemDataResponse(double revenue, double commission) {
		super();
		this.revenue = revenue;
		this.commission = commission;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	
}
