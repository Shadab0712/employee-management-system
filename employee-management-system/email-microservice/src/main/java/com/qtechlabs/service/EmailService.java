package com.qtechlabs.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailService {

	public String getMessage() {
		
		String welcomeMessage = "You have been onboarded successfully in the Organization "
				+ "and an Email has been sent to your registered mail address, Thank you..";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange("http://hrms-microservice-container:9097/api/v1/hrms/leaves",
				HttpMethod.GET, null, String.class);
		
		return welcomeMessage;
	}

}
