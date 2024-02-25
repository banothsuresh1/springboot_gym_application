package com.qsp.springboot_gym_application.exception;

public class MemberShipIdNotFound extends RuntimeException{
	private String message="MemberShipId not found in DataBase";

	public String getMessage() {
		return message;
	}

}
