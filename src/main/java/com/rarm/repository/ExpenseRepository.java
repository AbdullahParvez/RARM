package com.rarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rarm.model.Expense;

@Repository("expenseRepository")
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
