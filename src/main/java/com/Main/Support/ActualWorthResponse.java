package com.Main.Support;

/*required6 - total worth (investor)
 * params - investor id
 * brief -
 * returns - portfolio current worth
 */
public class ActualWorthResponse {
	
	private double actualWorth;

	public ActualWorthResponse(double actualWorth) {
		super();
		this.actualWorth = actualWorth;
	}

	public ActualWorthResponse() {
		super();
	}
	
	public double getCurrentWorth() {
		return actualWorth;
	}

	public void setCurrentWorth(double actualWorth) {
		this.actualWorth = actualWorth;
	}
	
	
}
