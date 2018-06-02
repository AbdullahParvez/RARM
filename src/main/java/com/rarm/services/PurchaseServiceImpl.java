package com.rarm.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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

	@Override
	public List<Purchase> findAllPurchase() {
		List<Purchase> tempListPurchase = purchaseRepository.findAll();
		List<Purchase> finalListPurchase = new ArrayList<>();
		for(Purchase p : tempListPurchase){
			String memoNo = p.getMemoNo();
			String companyCode = p.getCompanyCode();
			String itemName = p.getItemName();
			BigDecimal quantity = p.getQuantity();
			BigDecimal unitPrice = p.getUnitPrice();
			BigDecimal totalPrice = quantity.multiply(unitPrice);
			Date date = p.getDate();
			Date insertDate = p.getCreatedDate();
			
			Purchase purchase = new Purchase(memoNo, companyCode, date, itemName, quantity, unitPrice, totalPrice,
					insertDate); 
			finalListPurchase.add(purchase);
		}
		return finalListPurchase;
	}

}
