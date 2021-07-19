package com.wesleycangussu.mongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleycangussu.mongodb.domain.Post;
import com.wesleycangussu.mongodb.repository.PostRepository;
import com.wesleycangussu.mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository pRepo;
	
	public List<Post> findAll(){
		return pRepo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> post = pRepo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")) ;
	}
	
	public List<Post> findByTitle(String text){
		return pRepo.FindByTittle(text);
	}
	
	public List<Post> searchAll(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
		return pRepo.searchAll(text, minDate, maxDate);
	}
}
