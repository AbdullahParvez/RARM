package com.rarm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rarm.model.Expense;
import com.rarm.repository.ExpenseRepository;

@Service("ExpenseService")
public class ExpenseServiceImpl implements ExpenseService{
	
	@Autowired
	private ExpenseRepository expenseRepository;

	@Transactional
	@Override
	public List<Expense> save(List<Expense> allExpense) {
		return expenseRepository.save(allExpense);
	}

}
