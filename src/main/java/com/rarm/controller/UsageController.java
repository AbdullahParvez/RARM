package com.rarm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rarm.services.ItemService;

@Controller
public class UsageController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsageController.class);

	@Autowired
	ItemService itemService;
	
	@RequestMapping(value = "/addUsage", method = RequestMethod.GET)
	public String addUsage(Model model) {
		LOGGER.debug("Rendering addRiceSales page");
		String category = "riceSales";
		List<String> itemNameList = itemService.findItemNamebyCategory(category);
		model.addAttribute("itemNameList", itemNameList);
		for (int i = 0; i < itemNameList.size(); i++) {
			System.out.println(itemNameList.get(i));
		}
		
		return null;
	}

}
