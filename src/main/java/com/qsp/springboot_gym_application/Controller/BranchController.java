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
import com.qsp.springboot_gym_application.dto.Branch;
import com.qsp.springboot_gym_application.dto.BranchHead;
import com.qsp.springboot_gym_application.dto.Customers;
import com.qsp.springboot_gym_application.dto.Gym;
import com.qsp.springboot_gym_application.dto.MemberShip;
import com.qsp.springboot_gym_application.dto.Trainers;
import com.qsp.springboot_gym_application.service.BranchService;
import com.qsp.springboot_gym_application.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {
	@Autowired
	
	BranchService branchService;
	

	@ApiOperation(value = "save branch",notes = "Api is used for saving " )
	@ApiResponses({ @ApiResponse(code = 201, message = "Branch saved Successfully"),
				@ApiResponse(code = 400, message = "fields cannot be null or blank") })
	
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
		
	}
	
	@GetMapping("/fetchBranch")
	public ResponseEntity<ResponseStructure<Branch>> fetchById(@RequestParam int id) {
		return branchService.fetchById(id);
	}
	
	@GetMapping("/deleteBranch")
	public ResponseEntity<ResponseStructure<Branch>> deleteById(@RequestParam int id){
		return branchService.deleteById(id);
		
	}
	@PutMapping("/updateBranch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int id,@RequestBody Branch branch) {
		return branchService.updateBranch(id, branch);
	}
	
	@PutMapping("/addNewAddressToExistingBranch")
	public Branch addNewAddressToExistingBranch(@RequestParam int branchId,@RequestBody Address address)
	{
		return branchService.addNewAddressToExistingBranch(branchId, address);
	}
	@PutMapping("/addExistingAddressToExistingBranch")
	public Branch addExistingAddressToExistingBranch(@RequestParam int branchId,@RequestParam int addressId)
	{
		return branchService.addExistingAddressToExistingBranch(branchId, addressId);
	}
	


	@PutMapping("/addExistingGymToExistingBranch")
	public Branch addExistingGymToExistingBranch1(@RequestParam int branchId,@RequestParam int gymId) {
		return branchService.addExistingGymToExistingBranch(branchId, gymId);
	}
	@PutMapping("/addNewGymToExistingBranch")
	public Branch addNewGymToExistingBranch(@RequestParam int branchId,@RequestBody Gym gym)
	{
		return branchService.addNewGymToExistingBranch(branchId, gym);
	}


	@PutMapping("/addExistingBranchHeadToExistingBranch")
	public Branch addExistingBranchHeadToExistingBranch(@RequestParam int branchId,@RequestParam int branchHeadId) {
		return branchService.addExistingBranchHeadToExistingBranch(branchId, branchHeadId );
	}
	
	@PutMapping("/addNewBranchHeadToExistingBranch")
	public Branch addNewBranchHeadToExistingBranch(@RequestParam int branchId,@RequestBody BranchHead  branchHead)
	{
		return branchService.addNewBranchHeadToExistingBranch(branchId, branchHead);
	}
	

	
	@PutMapping("/addExistingCustomersToExistingBranch")
	public Branch addExistingCustomersToExistingBranch(@RequestParam int branchId,@RequestParam int customerId) {
		return branchService.addExistingAddressToExistingBranch(branchId, customerId);
		
	}
	@PutMapping("/addNewCustomersToExistingBranch")
	public Branch addNewCustomersToExistingBranch(@RequestParam int branchId,@RequestBody Customers customers) {
		return branchService.addNewCustomersToExistingBranch(branchId, customers);
	}
	

	@PutMapping("/addExistingTrainersToExistingBranch")
	public Branch addExistingTrainersToExistingBranch(@RequestParam int branchId,@RequestParam int trainerId) {
		return branchService.addExistingTrainersToExistingBranch(branchId, trainerId);
	}
	
	@PutMapping("/addNewTrainersToExistingBranch")
	public Branch addNewTrainersToExistingBranch(@RequestParam int branchId,@RequestBody Trainers trainers)
	{
		return branchService.addNewTrainersToExistingBranch(branchId, trainers);
		
	}
	
	@PutMapping("/addExistingMemberShipToExistingBranch")
	public Branch addExistingMemberShipToExistingBranch(@RequestParam int branchId,@RequestParam int memberShipId) {
		return branchService.addExistingMemberShipToExistingBranch(branchId, memberShipId);
	}
	
	@PutMapping("/addNewMemberShipToExistingBranch")
	public Branch addNewMemberShipToExistingBranch(@RequestParam int branchId,@RequestBody MemberShip memberShip)
	{
		return branchService.addNewMemberShipToExistingBranch(branchId, memberShip);
	}


	
}
