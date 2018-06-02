package com.rarm.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rarm.model.RiceSales;
import com.rarm.repository.RiceSalesRepository;

@Service("RiceSalesService")
public class RiceSalesServiceImpl implements RiceSalesService {

	@Autowired
	RiceSalesRepository riceSalesrepository;

	@Transactional
	@Override
	public List<RiceSales> save(List<RiceSales> allRiceSales) {
		return riceSalesrepository.save(allRiceSales);
	}

	@Override
	public List<RiceSales> findAllRiceSales() {

		List<RiceSales> tempListRiceSales = riceSalesrepository.findAll();

		List<RiceSales> finalListRiceSales = new ArrayList<>();

		for (RiceSales r : tempListRiceSales) {

			String memoNo = r.getMemoNo();
			String companyCode = r.getCompanyCode();
			String itemName = r.getItemName();
			BigDecimal quantity = r.getQuantity();
			BigDecimal unitPrice = r.getUnitPrice();
			BigDecimal totalPrice = quantity.multiply(unitPrice);
			Date date = r.getDate();
			Date insertDate = r.getCreatedDate();
			RiceSales riceSales = new RiceSales(memoNo, companyCode, date, itemName, quantity, unitPrice, totalPrice,
					insertDate);
			finalListRiceSales.add(riceSales);

		}
		return finalListRiceSales;
	}

}
