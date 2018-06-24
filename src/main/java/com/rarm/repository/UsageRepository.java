package com.rarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rarm.model.Usage;

@Repository("usageRepository")
public interface UsageRepository  extends JpaRepository<Usage , Long>{

}
