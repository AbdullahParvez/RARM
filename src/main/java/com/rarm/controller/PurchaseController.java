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

import com.rarm.model.Purchase;
import com.rarm.model.Records;
import com.rarm.model.RestPurchase;
import com.rarm.services.CompanyService;
import com.rarm.services.ItemService;
import com.rarm.services.PurchaseService;

@Controller
public class PurchaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseController.class);

	@Autowired
	ItemService itemService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private PurchaseService purchaseService;

	//Item item = new Item();

	@RequestMapping(value = "/addPurchase", method = RequestMethod.GET)
	public String addPurchase(Model model) {
		LOGGER.debug("Rendering addPurchase page");
		String category = "Purchase";
		List<String> itemNameList = itemService.findItemNamebyCategory(category);
		model.addAttribute("itemNameList", itemNameList);
		for (int i = 0; i < itemNameList.size(); i++) {
			System.out.println(itemNameList.get(i));
		}

		List<String> companyList = companyService.findCompanyCodeByCategory(category);
		model.addAttribute("companyList", companyList);
		for (int i = 0; i < companyList.size(); i++) {
			System.out.println(companyList.get(i));
		}

		return "common/addPurchase";
	}

	@RequestMapping(value = "/addItem/purchase", method = RequestMethod.GET)
	public String showAddItem(String category, Model model) {
		LOGGER.debug("Rendering addItem page for adding purchase Item");
		//item.setCategory("purchase");
		//model.addAttribute("category", item.getCategory());
		category = "Purchase";
		model.addAttribute("category", category);
		
		return "common/addItem";
	}

	@RequestMapping(value = "/addCompany/purchase", method = RequestMethod.GET)
	public String addpurchaseCompany(String category, Model model) {
		LOGGER.debug("Rendering addCompany page for adding purchase Company");
		category = "Purchase";
		model.addAttribute("category", category);
		return "common/addCompany";
	}

	@RequestMapping(value = "/savePurchase", method = RequestMethod.POST)
	public @ResponseBody String savePurchase(@RequestBody RestPurchase[] restPurchase) throws ParseException {
		List<Purchase> allPurchase = new ArrayList<>();
		for (RestPurchase pur : restPurchase) {
			String memoNo = pur.getMemoNo();
			String companyCode = pur.getCompanyCode();
			Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(pur.getDate());
			for (Records r : pur.getRecords()) {
				String itemName = r.getItemName();
				BigDecimal quantity = r.getQuantity();
				BigDecimal unitPrice = r.getUnitPrice();
				Purchase purchase = new Purchase(memoNo, companyCode, date, itemName, quantity, unitPrice);
				allPurchase.add(purchase);
			}

		}
		purchaseService.save(allPurchase);
		return "home";
	}
	
	@RequestMapping(value = "/getAllPurchase", method = RequestMethod.GET)
	public String getAllPurchase(Model model){
		
		List<Purchase> purchase = purchaseService.findAllPurchase();
		model.addAttribute("purchase",purchase);
		
		return "common/listOfPurchase";
		
	}

}
