package com.Main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Main.Service.AccountsManagmentService;
import com.Main.Support.LoginRequest;
import com.Main.Support.LoginValidation;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private AccountsManagmentService loginService;
		
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,method = {RequestMethod.POST} )
    public @ResponseBody LoginValidation loginRequest(@RequestBody LoginRequest loginRequest ){
    	return loginService.loginRequest(loginRequest);
    	
    }

}
