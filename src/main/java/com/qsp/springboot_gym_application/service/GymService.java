package com.qsp.springboot_gym_application.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_gym_application.dao.GymDao;
import com.qsp.springboot_gym_application.dto.Gym;
import com.qsp.springboot_gym_application.exception.GymIdNotFound;
import com.qsp.springboot_gym_application.util.ResponseStructure;


@Service
public class GymService {
	@Autowired
	GymDao gymDao;
	
	
	
	public ResponseEntity<ResponseStructure<Gym>> saveGym(Gym gym) {
		ResponseStructure<Gym> responseStructure=new ResponseStructure<Gym>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(gymDao.saveGym(gym));
		return new ResponseEntity<ResponseStructure<Gym>>(responseStructure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Gym>> fetchById(int id) {
		ResponseStructure<Gym> responseStructure=new ResponseStructure<Gym>();
		Gym gym=gymDao.fetchById(id);
		
		if(gym!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully fetched");
			responseStructure.setData(gymDao.fetchById(id));
			return new ResponseEntity<ResponseStructure<Gym>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new GymIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Gym>> deleteById(int id) {
		ResponseStructure<Gym> responseStructure=new ResponseStructure<Gym>();
		Gym gym=gymDao.fetchById(id);
		
		if(gym!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Sucessfully deleted");
		
		responseStructure.setData(gymDao.deleteById(id));
		return new ResponseEntity<ResponseStructure<Gym>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new GymIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Gym>> updateGym(int id,Gym gym) {
		Gym gym2=gymDao.fetchById(id);
		
		if(gym2!=null) {
		ResponseStructure<Gym> responseStructure=new ResponseStructure<Gym>();
		responseStructure.setMessage("successfully updated;;");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(gymDao.updateGym(id, gym));
		return new ResponseEntity<ResponseStructure<Gym>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new GymIdNotFound();
		}
	}
}
