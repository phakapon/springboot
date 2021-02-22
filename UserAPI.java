package com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class UserAPI {
	
	@Autowired
	UserRepository user;

	@GetMapping("/User")
	public List<User> getUser() {
		return user.findAll();
	}

	@GetMapping("/User/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		return user.findById(id);
	}
	
	@PostMapping("/User")
	public User saveUser(@RequestBody User User) {
		return user.save(User);
	}

	@PutMapping("/User")
	public User editUser(@RequestBody User User) {
		User editUser = user.findById(User.getUserId());
		editUser.setId(User.getId());
		editUser.setPassword(User.getPassword());
		editUser.setFavorite(User.getFavorite());
		editUser.setFollow(User.getFollow());
		return user.save(editUser);
	}
	
	@DeleteMapping("/User/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		User User = user.findById(id);
		user.delete(User);
	}
}
