package com.qsp.springboot_gym_application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_gym_application.dto.BranchHead;
import com.qsp.springboot_gym_application.service.BranchHeadService;
import com.qsp.springboot_gym_application.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchHeadController {
	
	@Autowired
	BranchHeadService branchHeadService;
	
	@ApiOperation(value = "save brachHeAD",notes = "Api is used for saving " )
	@ApiResponses({ @ApiResponse(code = 201, message = "brachHeAD saved Successfully"),
				@ApiResponse(code = 400, message = "fields cannot be null or blank") })
	
	
	@PostMapping("/saveBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(@RequestBody BranchHead branchHead) {
		return branchHeadService.saveBranchHead(branchHead);
	}
	
	@GetMapping("/fetchBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> fetchById(@RequestParam int id) {
		return branchHeadService.fetchById(id);
	}
	
	@GetMapping("/deleleBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> deleleBranchHead(@RequestParam int id) {
		return branchHeadService.deleteById(id);
	}
	
	@PutMapping("/updateBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHead(@RequestParam int id,@RequestBody BranchHead branchHead) {
		return branchHeadService.updateBranchHead(id, branchHead);
	}

}
