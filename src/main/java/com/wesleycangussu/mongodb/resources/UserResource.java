package com.wesleycangussu.mongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesleycangussu.mongodb.domain.User;
import com.wesleycangussu.mongodb.dto.UserDTO;
import com.wesleycangussu.mongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService	uServ;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = uServ.findAll() ;
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()) ;
		return ResponseEntity.ok().body(listDto);
		
		
		}
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		
		User obj = uServ.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	
			
	}
}
