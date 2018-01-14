package com.rarm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		
		
		Company company = new Company();
		company.setName(request.getParameter("name"));
		company.setCodeNumber(request.getParameter("codeNumber"));
		company.setAddress(request.getParameter("address"));
		company.setMobile(request.getParameter("mobile"));
		company.setCategory(request.getParameter("category"));
		
		
		companyService.save(company);
		
		return "redirect:/addSales";
		
	}

}
