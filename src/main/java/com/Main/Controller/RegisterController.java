package com.Main.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Main.Entities.Investor;
import com.Main.Service.AccountsManagmentService;
import com.Main.Support.AuthorizeRequest;
@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private AccountsManagmentService accMngService;
	
	
	//shall return Investor object?
	@RequestMapping(value = "/register" , method = RequestMethod.PUT ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody boolean register(@RequestBody Investor newInvestorAccount){
		return accMngService.register(newInvestorAccount);
    }
	
	@RequestMapping(value = "/authorize" , method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody boolean authorize(@RequestBody AuthorizeRequest authorizeRequest){
		return accMngService.authorize(authorizeRequest);
    }
}
