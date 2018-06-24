package com.rarm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rarm.model.Usage;
import com.rarm.repository.UsageRepository;

@Service("UsageService")
public class UsageServiceImpl implements UsageService {

	@Autowired
	UsageRepository usageRepository;

	@Transactional
	@Override
	public List<Usage> save(List<Usage> allUsage) {
		return usageRepository.save(allUsage);
	}


	@Override
	public List<Usage> findAllUsage() {

		List<Usage> listProduction =usageRepository.findAll();

		return listProduction;
	}

	
}
