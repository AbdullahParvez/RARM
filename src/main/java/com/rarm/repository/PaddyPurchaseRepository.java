package com.rarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rarm.model.PaddyPurchase;

@Repository("paddyPurchaseRepository")
public interface PaddyPurchaseRepository  extends JpaRepository<PaddyPurchase , Long>{

}
