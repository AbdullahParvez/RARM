package com.rarm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rarm.model.ExpenseSector;
import com.rarm.services.ExpenseSectorService;

@Controller
public class ExpenseSectorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseSectorController.class);

	@Autowired
	private ExpenseSectorService ExpenseSectorService;

	@RequestMapping(value = "/addExpenseSector", method = RequestMethod.GET)
	public String showHome() {
		LOGGER.debug("Rendering addExpenseSector page");

		return "common/addExpenseSector";
	}

	@RequestMapping(value = "/saveExpenseSector", method = RequestMethod.POST)
	public String saveNewUser(WebRequest request, RedirectAttributes redirectAttributes) {

		String sectorName = request.getParameter("sectorName");
		String description = request.getParameter("description");
		ExpenseSector ExpenseSector = new ExpenseSector(sectorName, description);
		ExpenseSectorService.save(ExpenseSector);

		return "redirect:/addExpense";

	}

}
