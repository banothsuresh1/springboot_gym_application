package com.qsp.springboot_gym_application.exception;

public class BranchIdNotFound extends RuntimeException{
	
	private String message="BranchId not found in DataBase";

	public String getMessage() {
		return message;
	}

}
