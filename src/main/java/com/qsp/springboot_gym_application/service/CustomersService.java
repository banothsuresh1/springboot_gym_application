package com.qsp.springboot_gym_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_gym_application.dao.CustomersDao;
import com.qsp.springboot_gym_application.dto.Customers;
import com.qsp.springboot_gym_application.exception.CustomersIdNotFound;
import com.qsp.springboot_gym_application.util.ResponseStructure;

@Service
public class CustomersService {
	@Autowired
	CustomersDao customersDao;
	
	public ResponseEntity<ResponseStructure<Customers>>  saveCustomers(Customers customers) 
	{
		ResponseStructure<Customers>responseStructure=new ResponseStructure<Customers>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Customers inserted");
		responseStructure.setData(customersDao.saveCustomers(customers));
		
		return new ResponseEntity<ResponseStructure<Customers>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Customers>>  fetchById(int id) {
		ResponseStructure<Customers>responseStructure=new ResponseStructure<Customers>();
		Customers customers=customersDao.fetchById(id);
		
		if(customers!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("customers fetched");
			responseStructure.setData(customersDao.fetchById(id));
			
			return new ResponseEntity<ResponseStructure<Customers>>(responseStructure,HttpStatus.FOUND);
		}
			
		else {
			throw new CustomersIdNotFound();
		}

		
	}
	
	public ResponseEntity<ResponseStructure<Customers>> deleteById(int id) {
		ResponseStructure<Customers>responseStructure=new ResponseStructure<Customers>();
		Customers customers=customersDao.fetchById(id);
		
		if(customers!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("customers Deleted");
			responseStructure.setData(customersDao.fetchById(id));
			
			return new ResponseEntity<ResponseStructure<Customers>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new CustomersIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Customers>>  updateCustomers(int id, Customers customers) {

		ResponseStructure<Customers>responseStructure=new ResponseStructure<Customers>();
		Customers customers1=customersDao.updateCustomers(id, customers);
		
		if(customers1!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("customers updated");
			responseStructure.setData(customersDao.updateCustomers(id, customers));
			
			return new ResponseEntity<ResponseStructure<Customers>>(responseStructure,HttpStatus.OK);
		}

		else {
			throw new CustomersIdNotFound();
		}
	}
	
	

	

}
