package com.qsp.springboot_gym_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_gym_application.dto.Gym;
import com.qsp.springboot_gym_application.repo.GymRepo;

@Repository
public class GymDao {
	
	@Autowired
	GymRepo gymRepo;
	
	public Gym saveGym(Gym gym) {
		return gymRepo.save(gym);
	}
	
	public Gym fetchById(int id) {
	Optional<Gym> gym=gymRepo.findById(id);
	if(gym.isPresent())
	{
		return gym.get();
	}
	else 
	{
		return null;
	}}
	public Gym deleteById(int id) {
		Optional<Gym> gym=gymRepo.findById(id);
		if(gym.isPresent()) {
			gymRepo.deleteById(id);
			return gym.get();
		}
		else {
			return null;
		}
	
		
	}
	public Gym updateGym(int id,Gym gym) {
		gym.setGymId(id);
		return gymRepo.save(gym);
	}

}
