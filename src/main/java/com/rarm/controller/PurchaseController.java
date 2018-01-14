package com.rarm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PurchaseController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseController.class);
	
	@RequestMapping(value="/addPurchase", method=RequestMethod.GET)
	public String showHome(){
		LOGGER.debug("Rendering addPurchase page");
		
		return "common/addPurchase";		
	}

}
