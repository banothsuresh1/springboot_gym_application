package com.qsp.springboot_gym_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_gym_application.dao.TrainersDao;
import com.qsp.springboot_gym_application.dto.Trainers;
import com.qsp.springboot_gym_application.exception.TrainerIdNotFound;
import com.qsp.springboot_gym_application.util.ResponseStructure;

@Service
public class TrainersService {
	
	@Autowired
	TrainersDao trainersDao;
	
	public ResponseEntity<ResponseStructure<Trainers>> saveTrainers(Trainers trainers) {
		ResponseStructure<Trainers> responseStructure=new ResponseStructure<Trainers>();
		responseStructure.setMessage("sucessfully inserted Trainer");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(trainersDao.saveTrainers(trainers));
		
		return new ResponseEntity<ResponseStructure<Trainers>>(responseStructure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Trainers>>  fetchById(int id) {
		ResponseStructure<Trainers> responseStructure=new ResponseStructure<Trainers>();
		Trainers trainers=trainersDao.fetchById(id);
		
		if(trainers!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("fetched trainer");
			responseStructure.setData(trainersDao.fetchById(id));
			
			return new ResponseEntity<ResponseStructure<Trainers>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new TrainerIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Trainers>> deleteById(int id) {
		ResponseStructure<Trainers> responseStructure=new ResponseStructure<Trainers>();
		Trainers trainers=trainersDao.fetchById(id);
		
		if(trainers!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("delete trainer");
			responseStructure.setData(trainersDao.fetchById(id));
			
			return new ResponseEntity<ResponseStructure<Trainers>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new TrainerIdNotFound();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Trainers>> updateTrainers(int id,Trainers trainers) {
	
		ResponseStructure<Trainers> responseStructure=new ResponseStructure<Trainers>();
		Trainers trainers2=trainersDao.updateTrainers(id, trainers);
		
		if(trainers2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("update sucessfully");
			responseStructure.setData(trainersDao.updateTrainers(id, trainers));
			
			return new ResponseEntity<ResponseStructure<Trainers>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new TrainerIdNotFound();
		}
	
		
		
		
	}

}
