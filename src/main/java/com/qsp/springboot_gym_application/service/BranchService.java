package com.qsp.springboot_gym_application.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_gym_application.dao.BranchDao;
import com.qsp.springboot_gym_application.dto.Address;
import com.qsp.springboot_gym_application.dto.Branch;
import com.qsp.springboot_gym_application.dto.BranchHead;
import com.qsp.springboot_gym_application.dto.Customers;
import com.qsp.springboot_gym_application.dto.Gym;
import com.qsp.springboot_gym_application.dto.MemberShip;
import com.qsp.springboot_gym_application.dto.Trainers;
import com.qsp.springboot_gym_application.exception.BranchIdNotFound;
import com.qsp.springboot_gym_application.util.ResponseStructure;


@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setMessage("branch inserted");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);
	}

	
	
	public ResponseEntity<ResponseStructure<Branch>> fetchById(int id) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		Branch branch=branchDao.fetchById(id);

		if(branch!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("successfully fetched");
			responseStructure.setData(branchDao.fetchById(id));
			
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> deleteById(int id) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		Branch branch=branchDao.fetchById(id);
		if(branch!=null) 
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully deleted ");
			responseStructure.setData(branchDao.fetchById(id));
			
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
			
		}
		else {
			throw new BranchIdNotFound();
		}

	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id,Branch branch) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		Branch branch2=branchDao.fetchById(id);
		
		if(branch2!=null) 
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully updated");
			responseStructure.setData(branchDao.updateBranch(id, branch));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new BranchIdNotFound();
		}
	}

	public Branch addExistingAddressToExistingBranch(int branchId,int addressId)
	{
		return branchDao.addExistingAddressToExistingBranch(branchId, addressId);
	}
	public Branch addNewAddressToExistingBranch(int branchId,Address address)
	{
		return branchDao.addNewAddressToExistingBranch(branchId, address);
	}
	
	public Branch addExistingGymToExistingBranch(int branchId,int gymId) {
		return branchDao.addExistingGymToExistingBranch(branchId, gymId);
	}
	public Branch addNewGymToExistingBranch(int branchId,Gym gym)
	{
		return branchDao.addNewGymToExistingBranch(branchId, gym);
	}
	
	public Branch addExistingBranchHeadToExistingBranch(int branchId,int branchHeadId) {
		return branchDao.addExistingBranchHeadToExistingBranch(branchId,branchHeadId );
	}
	public Branch addNewBranchHeadToExistingBranch(int branchId,BranchHead branchHead)
	{
		return branchDao.addNewBranchHeadToExistingBranch(branchId, branchHead);
	}
	
	
	public Branch addExistingCustomersToExistingBranch(int branchId,int customerId) {
		 return branchDao.addExistingCustomersToExistingBranch(branchId, customerId);
		
	}
	public Branch addNewCustomersToExistingBranch(int branchId,Customers customers)
	{
		return branchDao.addNewCustomersToExistingBranch(branchId, customers);
	}
	
	public Branch addExistingTrainersToExistingBranch(int branchId,int trainerId) {
		return branchDao.addExistingTrainersToExistingBranch(branchId, trainerId);
	}
	
	public Branch addNewTrainersToExistingBranch(int branchId,Trainers trainers)
	{
		return branchDao.addNewTrainersToExistingBranch(branchId, trainers);
	}
	

	public Branch addExistingMemberShipToExistingBranch(int branchId,int memberShipId) {
		return branchDao.addExistingMemberShipToExistingBranch(branchId, memberShipId);
	}
	public Branch addNewMemberShipToExistingBranch(int branchId,MemberShip memberShip)
	{
		return branchDao.addNewMemberShipToExistingBranch(branchId, memberShip);
	}
	
		
}
