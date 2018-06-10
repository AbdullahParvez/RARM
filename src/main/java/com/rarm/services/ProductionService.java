package com.rarm.services;

import java.util.List;

import com.rarm.model.Production;

public interface ProductionService {
	
	List<Production> save(List<Production> allProduction);
	List<Production> findAllProduction();

}
