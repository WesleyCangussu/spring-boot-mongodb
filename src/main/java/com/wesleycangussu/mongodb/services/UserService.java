package com.wesleycangussu.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleycangussu.mongodb.domain.User;
import com.wesleycangussu.mongodb.dto.UserDTO;
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
	
	public User insert(User obj) {
		
		return uRepo.insert(obj);
	}
	
	public User FromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(),objDto.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		uRepo.deleteById(id);
	}
	
	
	public User update(User obj) {
		Optional<User> user = uRepo.findById(obj.getId());
		User newUser = user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		updateData (newUser,obj);
		return uRepo.save(newUser);
	}

	private void updateData(User newUser, User obj) {
		newUser.setName(obj.getName());
		newUser.setEmail(obj.getEmail());
	
	}
}
