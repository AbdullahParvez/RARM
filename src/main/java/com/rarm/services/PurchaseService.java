package com.rarm.services;

import java.util.List;

import com.rarm.model.Purchase;

public interface PurchaseService {
	
	List<Purchase> save(List<Purchase> allPurchase);

}
