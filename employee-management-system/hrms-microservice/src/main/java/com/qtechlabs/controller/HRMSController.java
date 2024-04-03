package com.qtechlabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qtechlabs.service.HRMSService;

@RequestMapping("/api/v1/hrms")
@RestController
public class HRMSController {

	@Autowired
	private HRMSService hrmsService;

	@GetMapping("/leaves")
	public ResponseEntity<String> leavesMessage() {
		String welcomeMessage = hrmsService.getMessage();
		return new ResponseEntity<String>(welcomeMessage, HttpStatus.OK);
	}
}
