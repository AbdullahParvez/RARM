package com.rarm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BankAccountController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountController.class);
	
	@RequestMapping(value="/addBankAccount", method=RequestMethod.GET)
	public String showHome(){
		LOGGER.debug("Rendering addBankAccount page");
		
		return "common/addBankAccount";		
	}

}
