package com.qsp.springboot_gym_application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_gym_application.dto.MemberShip;
import com.qsp.springboot_gym_application.service.AddressService;
import com.qsp.springboot_gym_application.service.MemberShipService;
import com.qsp.springboot_gym_application.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MemberShipController {
	
	@Autowired
	MemberShipService memberShipService;
	AddressService addressService;
	@ApiOperation(value = "save  MemberShip",notes = "Api is used for saving " )
	@ApiResponses({ @ApiResponse(code = 201, message = "membership saved Successfully"),
				@ApiResponse(code = 400, message = "fields cannot be null or blank") })
	
	@PostMapping("/saveMemberShip")
	public ResponseEntity<ResponseStructure<MemberShip>> saveMemberShip(@RequestBody MemberShip memberShip) {
		return memberShipService.saveMemberShip(memberShip);
		
	}
	@GetMapping("/fetchMemberShip")
	public ResponseEntity<ResponseStructure<MemberShip>> fetchById(int id) {
		return memberShipService.fetchById(id);
	}
	@GetMapping("/deleteMemberShip")
	public ResponseEntity<ResponseStructure<MemberShip>> deleteById(int id) {
		return memberShipService.deleteById(id);
	}
	@PutMapping("/updateMemberShip")
	public ResponseEntity<ResponseStructure<MemberShip>> updateMemberShip(@RequestParam int id,@RequestBody MemberShip memberShip) {
		return memberShipService.updateMemberShip(id, memberShip);
	}
	


}
