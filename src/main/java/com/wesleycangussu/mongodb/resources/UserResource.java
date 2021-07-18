package com.wesleycangussu.mongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesleycangussu.mongodb.domain.User;
import com.wesleycangussu.mongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService	uServ;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = uServ.findAll() ;
		return ResponseEntity.ok().body(list);
	}
}
