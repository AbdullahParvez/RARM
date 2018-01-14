package com.rarm.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.rarm.model.Company;

public interface CompanyService {
	
	Company save(Company company);
	
	List<String>findCompanyCodeByCategory(@Param("category")String category);

}
