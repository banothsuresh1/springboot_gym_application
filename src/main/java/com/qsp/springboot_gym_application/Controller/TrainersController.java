package com.qsp.springboot_gym_application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_gym_application.dto.Trainers;
import com.qsp.springboot_gym_application.service.TrainersService;
import com.qsp.springboot_gym_application.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class TrainersController {
	@Autowired
	TrainersService trainersService;
	
	@ApiOperation(value = "save Address",notes = "Api is used for saving " )
	@ApiResponses({ @ApiResponse(code = 201, message = "trainers saved Successfully"),
				@ApiResponse(code = 400, message = "fields cannot be null or blank") })
	
	
	@PostMapping("/saveTrainers")
	public ResponseEntity<ResponseStructure<Trainers>> saveTrainers(@RequestBody Trainers trainers) {
		return trainersService.saveTrainers(trainers);
	}
	
	@GetMapping("/fetchTrainers")
	public ResponseEntity<ResponseStructure<Trainers>> fetchById(@RequestParam int id) {
		return trainersService.fetchById(id);
	}
	
	@GetMapping("/deleteTrainers")
	public ResponseEntity<ResponseStructure<Trainers>> deleteById(int id) {
		return trainersService.deleteById(id);
	}

	@PutMapping("/updateTrainers")
	public ResponseEntity<ResponseStructure<Trainers>> updateTrainers(@RequestParam int id,@RequestBody Trainers trainers) {
		return trainersService.updateTrainers(id, trainers);
	}
}
