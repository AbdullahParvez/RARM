package com.rarm.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rarm.model.PaddyPurchase;
import com.rarm.repository.PaddyPurchaseRepository;

@Service("PaddyPurchaseService")
public class PaddyPurchaseServiceImpl implements PaddyPurchaseService {

	@Autowired
	private PaddyPurchaseRepository paddyPurchaseRepository;

	@Transactional
	@Override
	public PaddyPurchase save(PaddyPurchase paddyPurchase) {
		return paddyPurchaseRepository.save(paddyPurchase);
	}

	@Override
	public List<PaddyPurchase> findAllPaddyPurchase() {
		
		 
		List<PaddyPurchase> temporaryListPaddyPurchase = paddyPurchaseRepository.findAll();
		List<PaddyPurchase> finalListPaddyPurchase = new ArrayList<>();
		
		for (PaddyPurchase p : temporaryListPaddyPurchase) {
			String memoNo = p.getMemoNo();
			String companyCode = p.getCompanyCode();
			Date date = p.getDate();
			BigDecimal quantitySack = p.getQuantitySack();
			BigDecimal quantityKG = p.getQuantityKG();
			BigDecimal unitPricePerMon = p.getUnitPricePerMon();
			BigDecimal totalSackPrice = p.getTotalSackPrice();
			BigDecimal mon = new BigDecimal(40);
			BigDecimal totalMon = quantityKG.divide(mon, 5);
			BigDecimal totalPrice = totalMon.multiply(unitPricePerMon).add(totalSackPrice);
			Date insertDate = p.getCreatedDate();
			PaddyPurchase paddyPurchase = new PaddyPurchase(memoNo, companyCode, date, quantitySack, quantityKG,
					unitPricePerMon, totalSackPrice, totalPrice,insertDate);
			finalListPaddyPurchase.add(paddyPurchase);
		}
				
				return finalListPaddyPurchase;
	}

}
