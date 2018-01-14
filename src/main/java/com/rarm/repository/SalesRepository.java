package com.rarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rarm.model.Sales;

@Repository("salesRepository")
public interface SalesRepository extends JpaRepository<Sales, Long>{

}
