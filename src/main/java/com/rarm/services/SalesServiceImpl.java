package com.rarm.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
	
	@Override
	public List<Sales> findAllSales() {

		List<Sales> tempListSales = salesRepository.findAll();

		List<Sales> finalListSales = new ArrayList<>();

		for (Sales s : tempListSales) {

			String memoNo = s.getMemoNo();
			String companyCode =s.getCompanyCode();
			String itemName = s.getItemName();
			BigDecimal quantity = s.getQuantity();
			BigDecimal unitPrice = s.getUnitPrice();
			BigDecimal totalPrice = quantity.multiply(unitPrice);
			Date date = s.getDate();
			Date insertDate = s.getCreatedDate();
			Sales sales = new Sales(memoNo, companyCode, date, itemName, quantity, unitPrice, totalPrice,
					insertDate);
			finalListSales.add(sales);
		}
		return finalListSales;
	}

}
