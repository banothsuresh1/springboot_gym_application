package com.qsp.springboot_gym_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_gym_application.dto.Trainers;
import com.qsp.springboot_gym_application.repo.TrainersRepo;

@Repository
public class TrainersDao {
	
	@Autowired
	TrainersRepo trainersRepo;
	
	public Trainers saveTrainers(Trainers trainers) {
		return trainersRepo.save(trainers);
	}
	
	public Trainers fetchById(int id) {
		Optional<Trainers> trainers=trainersRepo.findById(id);
		if(trainers.isPresent()) {
			return trainers.get();
		}
		else {
			return null;
		}
	}
	
	public Trainers deleteById(int id) {
		Optional<Trainers> trainers=trainersRepo.findById(id);
		if(trainers.isPresent()) {
			trainersRepo.deleteById(id);
			return trainers.get();
		}
		else {
			return null;
		}
		
	}
	public Trainers updateTrainers(int id,Trainers trainers) {
		trainers.setTrainerId(id);
		return trainersRepo.save(trainers);
	}

}
