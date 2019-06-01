package com.ccgg.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccgg.FinalProject.beans.User;
import com.ccgg.FinalProject.http.Response;
import com.ccgg.FinalProject.service.UserService;

@RestController()
//@RequestMapping("/users")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/admin")
	public Response addUser(@RequestBody User user) {
		return userService.registerAdm(user);
	}
}