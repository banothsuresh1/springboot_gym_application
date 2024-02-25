package com.qsp.springboot_gym_application.exception;

public class GymIdNotFound extends RuntimeException {
	
	private String message="GymId not found in DataBase";

	public String getMessage() {
		return message;
	}
	

}
