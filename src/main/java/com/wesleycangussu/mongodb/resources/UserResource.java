package com.wesleycangussu.mongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesleycangussu.mongodb.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User user1 = new User(null, "Wesley Cangussu", "Wesley@gmail.com");
		User user2 = new User(null, "Alexandre Ferreira", "Alexandre@gmail.com");
		User user3 = new User(null, "Renata cangussu", "Renata@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(user1,user2,user3));
		return ResponseEntity.ok().body(list);
	}
}
