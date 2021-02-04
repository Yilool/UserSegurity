package com.usersegurity.segurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.usersegurity.segurity.model.User;
import com.usersegurity.segurity.model.dto.UserDTO;
import com.usersegurity.segurity.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/{id}")
	private ResponseEntity<User> createNewUser(@RequestBody UserDTO user, @PathVariable Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(user, id));
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
