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

import com.Main.Service.AccountsManagmentService;
import com.Main.Service.InvestorDetailsService;
import com.Main.Service.StockMarketService;
import com.Main.Support.AuthorizeRequest;
import com.Main.Support.InvestorDetailsResponse;
import com.Main.Support.MyCommandsResponse;
import com.Main.Support.MyDetailsResponse;
import com.Main.Support.UpdateInvestorRequest;

@RestController
@RequestMapping("/myAccount")
public class AccountController {

	@Autowired
	private InvestorDetailsService investorDetailsService;
	@Autowired
	private AccountsManagmentService accountsManagmentService;
	@Autowired
	private StockMarketService stockMarketService;
	
	
	 @RequestMapping(path = "/details/{id}", produces = MediaType.APPLICATION_JSON_VALUE,method = {RequestMethod.GET} )
	 public @ResponseBody MyDetailsResponse showInvestorDetails(@PathVariable("id") Long investorId){
		 return investorDetailsService.showMyDetails(investorId);
		 
	 }
	 
	 @RequestMapping(path = "/updateDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,method = {RequestMethod.PUT} )
	 public @ResponseBody boolean updateInvestorDetails(@RequestBody UpdateInvestorRequest updateInvestorRequest){
		 return investorDetailsService.updateMyDetails(updateInvestorRequest);
	 }

	 @RequestMapping(path = "/commands/{id}", produces = MediaType.APPLICATION_JSON_VALUE,method = {RequestMethod.GET} )
	 public @ResponseBody List<MyCommandsResponse> showInvestorCommands(@PathVariable("id") Long investorId){
		 return investorDetailsService.myCommands(investorId);
	 }
	 
	 @RequestMapping(path="/allInvestors/{id}" , produces= MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	 public List<InvestorDetailsResponse> getAllInvestorsByBroker(@PathVariable("id") Long id){
		 return investorDetailsService.getAllInvestorsDetailsByBroker(id);
	 }
	 
	 @RequestMapping(path="/totalWorth/{id}" , produces= MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	 public double  getInvestorTotalWorth(@PathVariable("id") Long Investorid){
		 return stockMarketService.getTotalWorth(Investorid);
	 }
	 
	 @RequestMapping(path = "/updateInvestorByBroker", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	 public boolean updateInvestorByBroker(@RequestBody AuthorizeRequest authorizeRequest){
		 return accountsManagmentService.authorize(authorizeRequest);
	 }
}
