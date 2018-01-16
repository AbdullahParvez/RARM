package com.rarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rarm.model.Purchase;

@Repository("purchaseRepository")
public interface PurchaseRepository  extends JpaRepository<Purchase , Long>{

}
