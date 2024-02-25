package com.qsp.springboot_gym_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_gym_application.dto.Customers;
import com.qsp.springboot_gym_application.repo.CustomersRepo;

@Repository
public class CustomersDao {
	
	@Autowired
	CustomersRepo customersRepo;
	
	public Customers saveCustomers(Customers customers) {
		return customersRepo.save(customers);
	}
	
	public Customers fetchById(int id) {
		Optional<Customers> customers=customersRepo.findById(id);
		if(customers.isPresent()) {
			return customers.get();
		}
		else {
			return null;
		}
	}
	
	public Customers deleteById(int id) {
		Optional<Customers> customers=customersRepo.findById(id);
		if(customers.isPresent()) {
		customersRepo.deleteById(id);
		return customers.get();
		}else {
			return null;
		}
	}
	
	public Customers updateCustomers(int id,Customers customers) {
		customers.setCustomerId(id);
		return customersRepo.save(customers);
	}

}
