package com.qsp.springboot_gym_application.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_gym_application.dto.Customers;
import com.qsp.springboot_gym_application.service.CustomersService;
import com.qsp.springboot_gym_application.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CustomersController {
	
	@Autowired
	CustomersService customersService;
	@ApiOperation(value = "save cUSTOMERS",notes = "Api is used for saving " )
	@ApiResponses({ @ApiResponse(code = 201, message = "Customers saved Successfully"),
				@ApiResponse(code = 400, message = "fields cannot be null or blank") })
	
	
	@PostMapping("/saveCustomers")
	public ResponseEntity<ResponseStructure<Customers>> saveCustomers(@RequestBody Customers customers) {
		return customersService.saveCustomers(customers);
	}
	
	@GetMapping("/fetchCustomers")
	public ResponseEntity<ResponseStructure<Customers>> fetchById(@RequestParam int id) {
		return customersService.fetchById(id);
	}
	
	@GetMapping("/deleteCustomers")
	public ResponseEntity<ResponseStructure<Customers>> deleteById(@RequestParam int id) {
		return customersService.deleteById(id);
	}
	
	@PutMapping("/updateCustomers")
	public ResponseEntity<ResponseStructure<Customers>> updateCustomers(@RequestParam int id,@RequestBody Customers customers) {
		return customersService.updateCustomers(id, customers);
	}

}
