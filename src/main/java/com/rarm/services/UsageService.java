package com.rarm.services;

import java.util.List;

import com.rarm.model.Usage;



public interface UsageService {
	
	List<Usage> save(List<Usage> allUsage);
	List<Usage> findAllUsage();

}
