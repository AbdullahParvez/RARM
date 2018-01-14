package com.rarm.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rarm.dto.ItemValidation;
import com.rarm.model.Item;
import com.rarm.services.ItemService;

@Controller
public class ItemController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/addItem", method=RequestMethod.GET)
	public String showHome(){
		LOGGER.debug("Rendering addItem page");
		
		return "common/addItem";		
	}
	
	@RequestMapping(value="/saveItem", method=RequestMethod.POST)
	public String saveNewUser(@Valid ItemValidation itemValidation, BindingResult result, WebRequest request, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			System.out.println(result.getAllErrors());
		}
		Item item = new Item();
		item.setItemName(request.getParameter("itemName"));
		item.setUnitValue(request.getParameter("unitValue"));
		item.setMetricType(request.getParameter("metricType"));
		item.setCategory(request.getParameter("category"));
		item.setDescription(request.getParameter("description"));
		
		itemService.save(item);
		
		return "redirect:/addSales";
		
	}

}
