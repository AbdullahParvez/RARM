package com.rarm.services;

import java.util.List;

import com.rarm.model.Expense;

public interface ExpenseService {
	
	List<Expense> save(List<Expense> allExpense);

}
