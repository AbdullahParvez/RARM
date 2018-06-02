package com.rarm.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.rarm.model.Expense;
import com.rarm.model.RecordsExpense;
import com.rarm.model.RestExpense;
import com.rarm.services.ExpenseSectorService;
import com.rarm.services.ExpenseService;

@Controller
public class ExpenseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseController.class);
	
	@Autowired
	ExpenseSectorService expenseSectorService;
	
	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping(value="/addExpense", method=RequestMethod.GET)
	public String addExpense( Model model){
		LOGGER.debug("Rendering addExpense page");		
		List<String> expenseSectorList = expenseSectorService.findAllSectorName();
		model.addAttribute("expenseSectorList",expenseSectorList);
		for (int i = 0; i < expenseSectorList.size(); i++) {
			System.out.println(expenseSectorList.get(i));
		}		
		return "common/addExpense";		
	}
	
	@RequestMapping(value="/saveExpense", method=RequestMethod.POST)
	public @ResponseBody String saveExpense(@RequestBody RestExpense[] restExpense){
		List<Expense> allExpense =new ArrayList<>();
		for(RestExpense ex: restExpense){
			String memoNo = ex.getMemoNo();
			
			for(RecordsExpense r : ex.getRecordsExpense()){
				 String expenseSector = r.getExpenseSector();
				 BigDecimal amount = r.getAmount();
				 String description = r.getDescription();
				 Expense expense = new Expense(memoNo, expenseSector, amount, description);
				 allExpense.add(expense);
			}
		}
		expenseService.save(allExpense);
		
		return "home";
	}
	
}
