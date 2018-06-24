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

import com.rarm.model.RecordsStorage;
import com.rarm.model.RestStorage;
import com.rarm.model.Usage;
import com.rarm.services.ItemService;
import com.rarm.services.UsageService;

@Controller
public class UsageController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsageController.class);

	@Autowired
	ItemService itemService;
	
	@Autowired
	UsageService usageService;
	
	@RequestMapping(value = "/addUsage", method = RequestMethod.GET)
	public String addUsage(Model model) {
		LOGGER.debug("Rendering addUsage page");
		
		String category1 = "Paddy";
		String category2 = "Purchase";
		List<String> itemNameList = itemService.findItems(category1,category2);
		model.addAttribute("itemNameList", itemNameList);
		for (int i = 0; i < itemNameList.size(); i++) {
			System.out.println(itemNameList.get(i));
		}
		
		return "common/addUsage";
	}
	
	@RequestMapping(value = "/saveUsage", method = RequestMethod.POST)
	public @ResponseBody String saveProduction(@RequestBody RestStorage[] restUsage) throws ParseException {
		List<Usage> allUsage = new ArrayList<>();
		for (RestStorage ru : restUsage) {
	
			Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(ru.getDate());
			for (RecordsStorage r : ru.getRecords()) {
				String itemName = r.getItemName();
				BigDecimal quantity = r.getQuantity();
				Usage usage = new Usage(itemName, quantity, date);
				allUsage.add(usage);
			}

		}
		usageService.save(allUsage);
		return "redirect:/getAllUsage";
	}
	
	@RequestMapping(value = "/getAllUsage", method = RequestMethod.GET)
	public String getAllRiceSales(Model model) {
		List<Usage> usage = usageService.findAllUsage();

		model.addAttribute("usage", usage);

		return "common/listOfUsage";
	}

}
