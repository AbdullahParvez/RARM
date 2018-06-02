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
import com.rarm.model.Item;
import com.rarm.model.Records;
import com.rarm.model.RestSales;
import com.rarm.model.Sales;
import com.rarm.services.CustomerService;
import com.rarm.services.ItemService;
import com.rarm.services.SalesService;

@Controller
public class SalesController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(SalesController.class);

@Autowired
ItemService itemService;

@Autowired
CustomerService customerService;

@Autowired
SalesService salesService;
	
	@RequestMapping(value="/addSales", method=RequestMethod.GET)
	public String addSales( Model model){
		LOGGER.debug("Rendering addSales page");		
		String category = "sales";
		List<String> itemNameList = itemService.findItemNamebyCategory(category);
		model.addAttribute("itemNameList",itemNameList);
		//for (int i = 0; i < itemNameList.size(); i++) {
			//System.out.println(itemNameList.get(i));
		//}
		
		List<String> customerList = customerService.findCustomerCodeByCategory(category);
		model.addAttribute("customerList",customerList);
		//for (int i = 0; i < customerList.size(); i++) {
			//System.out.println(customerList.get(i));
		//}
		
		return "common/addSales";		
	}
	
	@RequestMapping(value="/addItem/sales", method=RequestMethod.GET)
	public String showAddItem(String category, Model model){
		LOGGER.debug("Rendering addItem page for adding sales Item");
		Item item =new Item();
		item.setCategory("sales");
		model.addAttribute("category", item.getCategory());
		return "common/addItem";		
	}
	
	@RequestMapping(value="/addCustomer/sales", method=RequestMethod.GET)
	public String addSalesCustomer(String category, Model model){
		LOGGER.debug("Rendering addCustomer page for adding sales Customer");	
		category = "sales"; 
		model.addAttribute("category", category);
		return "common/addCustomer";		
	}
	
	@RequestMapping(value = "/saveSales", method = RequestMethod.POST)	
    public @ResponseBody String saveSales(@RequestBody RestSales[] restSales) throws ParseException{
		List<Sales> allSales = new ArrayList<>();
		for(RestSales sale : restSales){			
			String memoNo = sale.getMemoNo();
			String customerCode=sale.getCustomerCode();
			Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(sale.getDate());
			for(Records r: sale.getRecords()){
				String itemName=r.getItemName();
				BigDecimal quantity=r.getQuantity();
				BigDecimal unitPrice=r.getUnitPrice();
				Sales sales = new Sales(memoNo, customerCode, date, itemName, quantity, unitPrice);
				allSales.add(sales);
			}	
			
		}
		salesService.save(allSales);
		return "home";
    }

}
