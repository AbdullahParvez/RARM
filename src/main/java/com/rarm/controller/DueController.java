package com.rarm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DueController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(DueController.class);
	
	@RequestMapping(value="/addDueCollection", method=RequestMethod.GET)
	public String showHome(){
		LOGGER.debug("Rendering addDueCollection page");
		
		return "common/addDueCollection";		
	}
	
	@RequestMapping(value="/addDuePayment", method=RequestMethod.GET)
	public String showHome2(){
		LOGGER.debug("Rendering addDuePayment page");
		
		return "common/addDuePayment";		
	}

}
