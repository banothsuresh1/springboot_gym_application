package com.qsp.springboot_gym_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_gym_application.dao.AddressDao;
import com.qsp.springboot_gym_application.dto.Address;
import com.qsp.springboot_gym_application.exception.AddressIdNotFound;
import com.qsp.springboot_gym_application.util.ResponseStructure;


@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address)
	{
		ResponseStructure<Address>responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Address is saved");
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Address>> deleteById(int id) {
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		Address address=addressDao.fetchById(id);
		if(address!=null) {
			responseStructure.setMessage("delete Address");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(addressDao.fetchById(id));
			
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
			
		}
		else {
			throw new AddressIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> fetchById(int id) {
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		Address address=addressDao.fetchById(id);
		
		if(address!=null) {
			responseStructure.setMessage("Addresss inserted");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(addressDao.fetchById(id));
			
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new AddressIdNotFound();
		}
				
	}
	
	public ResponseEntity<ResponseStructure<Address>>  updateAddress(int id,Address address) {
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		Address address2=addressDao.fetchById(id);
		if(address2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Addresss id updated");
			responseStructure.setData(addressDao.updateAddress(id, address));
			
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new AddressIdNotFound();
		}
		
		
		
	}

}
