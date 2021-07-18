package com.wesleycangussu.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleycangussu.mongodb.domain.User;
import com.wesleycangussu.mongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository uRepo;
	
	public List<User> findAll(){
		return uRepo.findAll();
	}
}
