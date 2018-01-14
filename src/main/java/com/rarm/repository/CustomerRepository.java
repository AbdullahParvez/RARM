package com.rarm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rarm.model.Customer;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query("Select c.codeNumber from Customer c where c.category=:category")
	List<String>findCustomerCodeByCategory(@Param("category")String category);

}
