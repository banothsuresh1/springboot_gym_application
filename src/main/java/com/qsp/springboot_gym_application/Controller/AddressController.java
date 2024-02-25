package com.qsp.springboot_gym_application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_gym_application.dto.Address;
import com.qsp.springboot_gym_application.service.AddressService;
import com.qsp.springboot_gym_application.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;
	@ApiOperation(value = "save Address",notes = "Api is used for saving " )
	@ApiResponses({ @ApiResponse(code = 201, message = "Address saved Successfully"),
				@ApiResponse(code = 400, message = "fields cannot be null or blank") })
	
	@PostMapping("/saveAddresss")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@GetMapping("/deleteAddress")
	public ResponseEntity<ResponseStructure<Address>> deleteById(@RequestParam int id) {
		return addressService.deleteById(id);
	}
	@GetMapping("/fetchAddress")
	public ResponseEntity<ResponseStructure<Address>> fetchById(@RequestParam int id) {
		return addressService.fetchById(id);
	}
	@PutMapping("/updateAddress")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int id,@RequestBody Address address) {
		return addressService.updateAddress(id, address);
	}
}


