package com.rarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rarm.model.Production;

@Repository("productionRepository")
public interface ProductionRepository  extends JpaRepository<Production , Long>{

}
