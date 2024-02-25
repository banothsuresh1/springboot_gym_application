package com.qsp.springboot_gym_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_gym_application.dto.Address;
import com.qsp.springboot_gym_application.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
		
	}
	
	public Address deleteById(int id) {
		Optional<Address> address=addressRepo.findById(id);
		if(address.isPresent()) {
			addressRepo.deleteById(id);
			return address.get();
		}
		else {
			return null;
		}
		
	}
	
	public Address fetchById(int Id) {
		Optional<Address> address=addressRepo.findById(Id);
		if(address.isPresent()) {
			return address.get();
		}
		else {
			return null;
		}
	}
	public Address updateAddress(int id,Address address) {
		address.setAddressId(id);
		return addressRepo.save(address);
	
	}
}
