package com.ccgg.FinalProject.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccgg.FinalProject.http.Response;

@RestController
public class AuthController {
	
	@GetMapping("/checklogin")
	public Response checklogin(Authentication authentication) {
		return new Response(authentication != null);
	}
}