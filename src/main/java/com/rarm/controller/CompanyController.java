package com.rarm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rarm.model.Company;
import com.rarm.services.CompanyService;

@Controller
public class CompanyController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

@Autowired
private CompanyService companyService;
	
	@RequestMapping(value="/addCompany", method=RequestMethod.GET)
	public String showHome(){
		LOGGER.debug("Rendering addCompany page");
		
		return "common/addCompany";		
	}
	
	@RequestMapping(value="/saveCompany", method=RequestMethod.POST)
	public String saveNewUser(WebRequest request,RedirectAttributes redirectAttributes){
		
		
		
		String name = request.getParameter("name");
		String codeNumber = request.getParameter("codeNumber");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String category = request.getParameter("category");
		
		Company company = new Company(name, codeNumber, address, mobile, category);
		companyService.save(company);
		
		switch (category) {
		case "purchase":
			return "redirect:/addPurchase";

		case "paddyPurchase":
			return "redirect:/paddyPurchase";
			
		case "riceSales":
			return "redirect:/addRiceSales";
		
		case "sales":
			return "redirect:/addSales";

		default:
			return "home";
		}
		
	}
	
	@RequestMapping(value = "/getAllCompanies", method = RequestMethod.GET)
	public String getAllPurchase(Model model){
		
		List<Company> companies = companyService.findAllItems();
		model.addAttribute("companies",companies);
		
		return "common/listOfCompanies";
		
	}

}
