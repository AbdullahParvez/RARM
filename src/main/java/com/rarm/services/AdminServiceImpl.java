package com.rarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rarm.model.User;
import com.rarm.repository.AdminRepository;



@Service("AdminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Transactional
	@Override
	public User save(User user) {		
		return adminRepository.save(user);
	}
}
