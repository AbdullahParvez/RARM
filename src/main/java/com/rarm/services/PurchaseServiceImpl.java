package com.rarm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rarm.model.Purchase;
import com.rarm.repository.PurchaseRepository;

@Service("PurchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Transactional
	@Override
	public List<Purchase> save(List<Purchase> allPurchase) {
		return purchaseRepository.save(allPurchase);
	}

}
