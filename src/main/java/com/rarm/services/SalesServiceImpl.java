package com.rarm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rarm.model.Sales;
import com.rarm.repository.SalesRepository;

@Service("SalesService")
public class SalesServiceImpl implements SalesService{
	
	@Autowired
	private SalesRepository salesRepository;
	
	@Transactional
	@Override
	public List<Sales> save(List<Sales> allSales) {
		return salesRepository.save(allSales);
	}

}
