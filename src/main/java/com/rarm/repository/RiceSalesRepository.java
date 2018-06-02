package com.rarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rarm.model.RiceSales;

@Repository("riceSalesRepository")
public interface RiceSalesRepository  extends JpaRepository<RiceSales , Long>{

}
