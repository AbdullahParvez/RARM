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
public class ProductionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RiceSalesController.class);
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(value = "/addProduction", method = RequestMethod.GET)
	public String addProduction(Model model){
		LOGGER.debug("Rendering addproduction page");
		
		String category1 = "riceSales";
		String category2 = "sales";
		List<String> itemNameList = itemService.findProductionItem(category1,category2);
		model.addAttribute("itemNameList", itemNameList);
		for (int i = 0; i < itemNameList.size(); i++) {
			System.out.println(itemNameList.get(i));
		}
		
		return "common/addProduction";

	}

}
