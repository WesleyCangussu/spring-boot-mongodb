package com.wesleycangussu.mongodb.config;



import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.wesleycangussu.mongodb.domain.Post;
import com.wesleycangussu.mongodb.domain.User;
import com.wesleycangussu.mongodb.repository.PostRepository;
import com.wesleycangussu.mongodb.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {

	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "BobGrey", "bob@gmail.com");

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Vou viajar", "Viajar para são paulo", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom Dia","Acordei feliz hoje", maria);
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		postRepository.saveAll(Arrays.asList(post1,post2));
	}
	
	

}
