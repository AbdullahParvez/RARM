package com.rarm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rarm.model.Company;
import com.rarm.repository.CompanyRepository;

@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Transactional
	@Override
	public Company save(Company company) {
		return companyRepository.save(company);
	}
	
	@Override
	public List<String> findCompanyCodeByCategory(String category) {
		return companyRepository.findCompanyCodeByCategory(category);
	}

	@Override
	public List<Company> findAllItems() {
		List<Company> companies = companyRepository.findAll();
		return companies;
	}

}
