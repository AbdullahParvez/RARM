package com.rarm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rarm.model.Production;
import com.rarm.repository.ProductionRepository;

@Service("ProductionService")
public class ProductionServiceImpl implements ProductionService {

	@Autowired
	ProductionRepository productionRepository;

	@Transactional
	@Override
	public List<Production> save(List<Production> allProduction) {
		return productionRepository.save(allProduction);
	}

	@Override
	public List<Production> findAllProduction() {

		List<Production> listProduction =productionRepository.findAll();

		return listProduction;
	}

}
