package com.rarm.services;

import java.util.List;

import com.rarm.model.ExpenseSector;

public interface ExpenseSectorService {
	
	ExpenseSector save(ExpenseSector expenseSector);
	
	List<String> findAllSectorName();

}
