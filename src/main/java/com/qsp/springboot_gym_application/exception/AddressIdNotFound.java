package com.qsp.springboot_gym_application.exception;

public class AddressIdNotFound extends RuntimeException {
	
	private String message="AddressId not found in DataBase";

	public String getMessage() {
		return message;
	}
	

}
