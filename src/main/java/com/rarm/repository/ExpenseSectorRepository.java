package com.rarm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rarm.model.ExpenseSector;

@Repository("expenseSectorRepository")
public interface ExpenseSectorRepository extends JpaRepository<ExpenseSector, Long>{
	
	@Query("Select e.sectorName from ExpenseSector e")
	List<String> findAllSectorName();	
}
