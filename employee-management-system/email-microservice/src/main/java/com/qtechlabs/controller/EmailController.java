package com.qtechlabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qtechlabs.service.EmailService;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

	@Autowired
	private EmailService service;

	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMessage() {
		String message = service.getMessage();
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
