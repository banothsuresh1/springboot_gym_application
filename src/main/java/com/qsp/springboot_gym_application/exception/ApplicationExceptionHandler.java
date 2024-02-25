package com.qsp.springboot_gym_application.exception;



import java.util.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.springboot_gym_application.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors = ex.getAllErrors();
		Map<String, String> map = new HashMap<>();
		for (ObjectError error : errors) {
			String message = error.getDefaultMessage();
			String fieldName = ((FieldError) error).getField();
			map.put(fieldName, message);
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	@ExceptionHandler(GymIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> gymIdNotFound(GymIdNotFound gymIdNotFound) {
		
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		
		responseStructure.setMessage("Enter Invalid id");
		
		responseStructure.setData(gymIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> branchIdNotFound(BranchIdNotFound branchIdNotFound) {
		
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		
		responseStructure.setMessage("Enter Invalid id");
		
		responseStructure.setData(branchIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
		
		@ExceptionHandler(AddressIdNotFound.class)
		public ResponseEntity<ResponseStructure<String>> addressIdNotFound(AddressIdNotFound addressIdNotFound ) {
			
			ResponseStructure<String> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			
			responseStructure.setMessage("Enter Invalid id");
			
			responseStructure.setData(addressIdNotFound.getMessage());
			return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(TrainerIdNotFound.class)
		public ResponseEntity<ResponseStructure<String>> trainerIdNotFound(TrainerIdNotFound trainerIdNotFound ) {
			
			ResponseStructure<String> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			
			responseStructure.setMessage("Enter Invalid id");
			
			responseStructure.setData(trainerIdNotFound.getMessage());
			return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(CustomersIdNotFound.class)
		public ResponseEntity<ResponseStructure<String>> customersIdNotFound(CustomersIdNotFound customersIdNotFound) {
			
			ResponseStructure<String> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			
			responseStructure.setMessage("Enter Invalid id");
			
			responseStructure.setData(customersIdNotFound.getMessage());
			return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(MemberShipIdNotFound.class)
		public ResponseEntity<ResponseStructure<String>> memberShipIdNotFound(MemberShipIdNotFound memberShipIdNotFound) {
			
			ResponseStructure<String> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			
			responseStructure.setMessage("Enter Invalid id");
			
			responseStructure.setData(memberShipIdNotFound.getMessage());
			return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		}
		@ExceptionHandler(BranchHeadIdNotFound.class)
		public ResponseEntity<ResponseStructure<String>> branchHeadIdNotFound(BranchHeadIdNotFound branchHeadIdNotFound) {
			
			ResponseStructure<String> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			
			responseStructure.setMessage("Enter Invalid id");
			
			responseStructure.setData(branchHeadIdNotFound.getMessage());
			return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		}
		
		
	}


