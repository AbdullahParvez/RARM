package com.rarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rarm.model.User;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<User, Long>{	

}
