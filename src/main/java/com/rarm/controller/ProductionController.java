package com.rarm.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rarm.model.Production;
import com.rarm.model.RecordsStorage;
import com.rarm.model.RestStorage;
import com.rarm.services.ItemService;
import com.rarm.services.ProductionService;


@Controller
public class ProductionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductionController.class);
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ProductionService productionService;
	
	@RequestMapping(value = "/addProduction", method = RequestMethod.GET)
	public String addProduction(Model model){
		LOGGER.debug("Rendering addproduction page");
		
		String category1 = "Rice";
		String category2 = "Sales";
		List<String> itemNameList = itemService.findItems(category1,category2);
		model.addAttribute("itemNameList", itemNameList);
		for (int i = 0; i < itemNameList.size(); i++) {
			System.out.println(itemNameList.get(i));
		}
		
		return "common/addProduction";

	}
	
	@RequestMapping(value = "/saveProduction", method = RequestMethod.POST)
	public @ResponseBody String saveProduction(@RequestBody RestStorage[] restProduction) throws ParseException {
		List<Production> allProduction = new ArrayList<>();
		for (RestStorage rp : restProduction) {
	
			Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(rp.getDate());
			for (RecordsStorage r : rp.getRecords()) {
				String itemName = r.getItemName();
				BigDecimal quantity = r.getQuantity();
				Production production = new Production(itemName, quantity, date);
				allProduction.add(production);
			}

		}
		productionService.save(allProduction);
		return "redirect:/getAllProduction";
	}
	
	@RequestMapping(value = "/getAllProduction", method = RequestMethod.GET)
	public String getAllRiceSales(Model model) {
		List<Production> production = productionService.findAllProduction();

		model.addAttribute("production", production);

		return "common/listOfProduction";
	}


}
