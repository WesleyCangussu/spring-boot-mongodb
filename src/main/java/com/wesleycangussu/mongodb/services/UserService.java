package com.wesleycangussu.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleycangussu.mongodb.domain.User;
import com.wesleycangussu.mongodb.repository.UserRepository;
import com.wesleycangussu.mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository uRepo;
	
	public List<User> findAll(){
		return uRepo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = uRepo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")) ;
	}
}
