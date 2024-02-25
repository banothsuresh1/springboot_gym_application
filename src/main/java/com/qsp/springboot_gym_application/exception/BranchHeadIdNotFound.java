package com.qsp.springboot_gym_application.exception;

public class BranchHeadIdNotFound extends RuntimeException {
	
	private String message="BranchHeadId not found in DataBase";

	public String getMessage() {
		return message;
	}


}
