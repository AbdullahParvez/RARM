package com.rarm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rarm.model.ExpenseSector;
import com.rarm.repository.ExpenseSectorRepository;

@Service("ExpenseSectorService")
public class ExpenseSectorServiceImpl implements ExpenseSectorService{
	
	@Autowired
	ExpenseSectorRepository expenseSectorRepository;

	@Transactional
	@Override
	public ExpenseSector save(ExpenseSector expenseSector) {
		return expenseSectorRepository.save(expenseSector);
	}

	@Override
	public List<String> findAllSectorName() {
		return expenseSectorRepository.findAllSectorName();
	}
	

}
