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

import com.rarm.dto.RegistrationForm;
import com.rarm.model.User;
import com.rarm.services.AdminService;

@Controller
public class AdminController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;  
	
	@RequestMapping(value="/addNewUser", method=RequestMethod.GET)
	public String showHome(){
		LOGGER.debug("Rendering add user page");
		
		return "admin/addNewUser";		
	}
	
	@RequestMapping(value="/saveNewUser", method=RequestMethod.POST)
	public String saveNewUser(@Valid RegistrationForm registrationForm,
			BindingResult result, WebRequest request, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			System.out.println(result.getAllErrors());
			redirectAttributes.addAttribute("error","Password should be more than 4 character");
			return "redirect:/addNewUser";
		}
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		user.setphone(request.getParameter("phone"));
		user.setRole(request.getParameter("role"));
		
		adminService.save(user);
		
		return "home";
		
	}

}
