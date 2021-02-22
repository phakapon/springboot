package com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class JoinAPI {
	@Autowired
	JoinRepository repo;

	@GetMapping("/Join")
	public List<Join_event> getJoin_event(){
		return repo.findAll();
	}
   
	@GetMapping("/Join/{id}")
	public Join_event getOneJoin_event(@PathVariable("id") Integer id) {
		return repo.getJoin_event(id);
	}
}
