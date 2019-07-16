package com.pg.testapps.usermgmt.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import com.pg.testapps.usermgmt.controller.Exceptions.UserNotFoundException;
import com.pg.testapps.usermgmt.domain.User;
import com.pg.testapps.usermgmt.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("serviceinfo")
	public String getServiceInformation() {
		return "This is User Related service.";
	}
	
	@GetMapping("getalluser")
	public List<User> getAllUserService() {
		return userService.getAllUser();
	}
	
	@PostMapping("saveuser")
	public ResponseEntity<Object> saveUserService(@Valid @RequestBody User user) {
		User savedUser = userService.saveUser(user);
		//return savedUser;
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("getuser/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id) {
		User user = userService.findUser(id);
		if(null == user) {
			throw new UserNotFoundException("id-" + id);
		}
		
		EntityModel<User> entityModel = new EntityModel<User>(user);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUserService());
		entityModel.add(linkTo.withRel("All-User"));
		
		return entityModel;
	}
	
	@DeleteMapping("deleteuser/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		User user = userService.deleteById(id);
		if(null == user)
			throw new UserNotFoundException("id-" + id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
