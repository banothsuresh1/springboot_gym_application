package com.qsp.springboot_gym_application.exception;

public class TrainerIdNotFound extends RuntimeException{
	
	private String message="TrainersId not found in DataBase";

	public String getMessage() {
		return message;
	}


}
