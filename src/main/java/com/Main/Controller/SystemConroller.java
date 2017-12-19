package com.Main.Controller;

import com.Main.Service.SystemService;
import com.Main.Support.SystemDataResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/systemData")

public class SystemConroller {
	@Autowired
	private SystemService systemService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SystemDataResponse getSystemData() {
		return systemService.getSystemData();
	}

	@RequestMapping(path = "/updateCommission", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean setSystemDataCommision(@RequestBody Double commission) {
		return systemService.setCommission(commission);
	}

}
