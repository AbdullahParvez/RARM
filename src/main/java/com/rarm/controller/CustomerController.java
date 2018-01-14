package com.rarm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rarm.model.Customer;
import com.rarm.services.CustomerService;

@Controller
public class CustomerController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

@Autowired
private CustomerService customerService;
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.GET)
	public String showHome(){
		LOGGER.debug("Rendering addCustomer page");
		
		return "common/addCustomer";		
	}
	
	@RequestMapping(value="/saveCustomer", method=RequestMethod.POST)
	public String saveNewUser(WebRequest request,RedirectAttributes redirectAttributes){
		
		
		Customer customer = new Customer();
		customer.setName(request.getParameter("name"));
		customer.setCodeNumber(request.getParameter("codeNumber"));
		customer.setCompanyName(request.getParameter("companyName"));
		customer.setAddress(request.getParameter("address"));
		customer.setMobile(request.getParameter("mobile"));
		customer.setCategory(request.getParameter("category"));
		
		
		customerService.save(customer);
		
		return "redirect:/addSales";
		
	}

}
