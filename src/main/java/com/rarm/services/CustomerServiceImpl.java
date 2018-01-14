package com.rarm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rarm.model.Customer;
import com.rarm.repository.CustomerRepository;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Override
	public List<String> findCustomerCodeByCategory(String category) {
		return customerRepository.findCustomerCodeByCategory(category);
	}

}
