package com.qsp.springboot_gym_application.exception;

public class CustomersIdNotFound extends RuntimeException{
	
	
	private String message="CustomersId not found in DataBase";

	public String getMessage() {
		return message;
	}

}
