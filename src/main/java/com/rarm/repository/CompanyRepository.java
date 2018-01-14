package com.rarm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rarm.model.Company;

@Repository("companyRepository")
public interface CompanyRepository extends JpaRepository<Company, Long>{
	
	@Query("Select c.codeNumber from Company c where c.category=:category")
	List<String>findCompanyCodeByCategory(@Param("category")String category);

}
