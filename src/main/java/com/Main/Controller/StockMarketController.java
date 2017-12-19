package com.Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Main.Service.StockMarketService;
import com.Main.Support.BidAskRequest;
import com.Main.Support.PortfolioStockDetails;
import com.Main.Support.StockMarketResponse;
@RestController
public class StockMarketController {
	
	@Autowired
	private StockMarketService stockMarketService;
	
	 @RequestMapping(path = "/stocks", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	 public @ResponseBody List<StockMarketResponse> getStocks(){
		 return stockMarketService.getStocks();		 
	 }
	 
	 @RequestMapping(path = "/commandRequest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	 public @ResponseBody Long newCommandRequest(@RequestBody BidAskRequest newCommand){
		return stockMarketService.newCommandRequest(newCommand);
		 
	 }
	 
	 @RequestMapping(path = "/myPortfolio/{id}", produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
	 public @ResponseBody List<PortfolioStockDetails> reportPortfolio(@PathVariable("id") Long investorId){
		return stockMarketService.reportPortfolio(investorId);
	 }
	 
	/* @RequestMapping(path = "/checkMatching", method = RequestMethod.GET)
	 public void checkMatching(@PathVariable("id") Long investorId){
		 stockMarketService.checkMatching();
	 }	 */

}
