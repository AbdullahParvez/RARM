package com.rarm.services;

import java.util.List;

import com.rarm.model.RiceSales;

public interface RiceSalesService {
	
	List<RiceSales> save(List<RiceSales> allRiceSales);
	List<RiceSales> findAllRiceSales();

}
