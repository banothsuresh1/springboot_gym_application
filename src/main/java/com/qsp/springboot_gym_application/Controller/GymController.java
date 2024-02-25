package com.qsp.springboot_gym_application.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_gym_application.dto.Gym;
import com.qsp.springboot_gym_application.service.GymService;
import com.qsp.springboot_gym_application.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class GymController {
	
	@Autowired
	GymService gymService;
	
	@ApiOperation(value = "save gym",notes = "Api is used for saving " )
	@ApiResponses({ @ApiResponse(code = 201, message = "Gym saved Successfully"),
				@ApiResponse(code = 400, message = "fields cannot be null or blank") })
	
	@PostMapping("/saveGym")
	public ResponseEntity<ResponseStructure<Gym>> saveGym(@Valid @RequestBody Gym gym) {
		return gymService.saveGym(gym);
	}
	
	@GetMapping("/fetchGym")
	public ResponseEntity<ResponseStructure<Gym>> fetchById( @RequestParam int id) {
		return gymService.fetchById(id);
	}
	
	@GetMapping("/deleteGym")
	public ResponseEntity<ResponseStructure<Gym>> deleteById(@RequestParam int id) {
		return gymService.deleteById(id);
	}
	@PutMapping("/updateGym")
	public ResponseEntity<ResponseStructure<Gym>> updateGym(@RequestParam int id,@RequestBody Gym gym) {
		return gymService.updateGym(id, gym);
	}

}
