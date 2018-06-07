package com.rarm.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	public String addItem() {
		LOGGER.debug("Rendering addItem page");

		return "common/addItem";
	}
	
	@RequestMapping(value = "/addPaddyItem", method = RequestMethod.GET)
	public String addPaddyItem() {
		LOGGER.debug("Rendering addPaddyItem page");

		return "common/addPaddyItem";
	}

	@RequestMapping(value = "/saveItem", method = RequestMethod.POST)
	public String saveItem(@Valid ItemValidation itemValidation, BindingResult result, WebRequest request,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
		}

		String itemName = request.getParameter("itemName");
		String unitValue = request.getParameter("unitValue");
		String metricType = request.getParameter("metricType");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		Item item = new Item(itemName, unitValue, metricType, category, description);
		itemService.save(item);

		switch (category) {
		case "sales":
			return "redirect:/addSales";

		case "purchase":
			return "redirect:/addPurchase";
			
		case "riceSales":
			return "redirect:/addRiceSales";

		default:
			return "home";
		}

	}
	
	@RequestMapping(value = "/getAllItems", method = RequestMethod.GET)
	public String getAllPurchase(Model model){
		
		List<Item> items = itemService.findAllItems();
		model.addAttribute("items",items);
		
		return "common/listOfItems";
		
	}
}
