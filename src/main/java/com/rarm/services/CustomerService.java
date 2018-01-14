package com.rarm.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.rarm.model.Customer;

public interface CustomerService {
	
	Customer save(Customer customer);
	
	List<String>findCustomerCodeByCategory(@Param("category")String category);

}
