package com.qtechlabs.service;

import org.springframework.stereotype.Service;

@Service
public class HRMSService {

	public String getMessage() {

		String welcomeMessage = "You have been granted 2 sick leaves "
				+ "and 1 casual leave as per internal policy , ThankYou.. ";

		return welcomeMessage;
	}

}
