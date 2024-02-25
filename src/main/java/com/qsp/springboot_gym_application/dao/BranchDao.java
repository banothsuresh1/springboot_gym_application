package com.qsp.springboot_gym_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_gym_application.dto.Address;
import com.qsp.springboot_gym_application.dto.Branch;
import com.qsp.springboot_gym_application.dto.BranchHead;
import com.qsp.springboot_gym_application.dto.Customers;
import com.qsp.springboot_gym_application.dto.Gym;
import com.qsp.springboot_gym_application.dto.MemberShip;
import com.qsp.springboot_gym_application.dto.Trainers;
import com.qsp.springboot_gym_application.repo.AddressRepo;
import com.qsp.springboot_gym_application.repo.BranchHeadRepo;
import com.qsp.springboot_gym_application.repo.BranchRepo;
import com.qsp.springboot_gym_application.repo.CustomersRepo;
import com.qsp.springboot_gym_application.repo.GymRepo;
import com.qsp.springboot_gym_application.repo.MemberShipRepo;
import com.qsp.springboot_gym_application.repo.TrainersRepo;

@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;
	@Autowired
	AddressRepo addressRepo;
	@Autowired
	GymRepo gymRepo;
	@Autowired
	BranchHeadRepo branchHeadRepo;
	@Autowired
	CustomersRepo customersRepo;
	@Autowired
	TrainersRepo trainersRepo;
	@Autowired
	MemberShipRepo memberShipRepo;
	
	
	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}
	
	public Branch fetchById(int id) {
		Optional<Branch> branch=branchRepo.findById(id);
		if(branch.isPresent()) {
			return branch.get();
			
		}
		else {
			return null;
		}
	}
	
	public Branch deleteById(int id) {
		Optional<Branch> branch=branchRepo.findById(id);
		if(branch.isPresent()) {
			branchRepo.deleteById(id);
			return branch.get();
			
		}
		else {
			return null;
		}
	
		
	}
	public Branch updateBranch(int id,Branch branch) {
		branch.setBranchId(id);
		return branchRepo.save(branch);
	}
	
	 
	
	public Branch addExistingAddressToExistingBranch(int branchId,int addressId) {
		Branch branch=branchRepo.findById(branchId).get();
		Address address=addressRepo.findById(addressId).get();
		branch.setAddress(address);
		return saveBranch(branch);
	}
	
	public Branch addNewAddressToExistingBranch(int branchId,Address address)
	{
		Branch branch=branchRepo.findById(branchId).get();
		branch.setAddress(address);
		return saveBranch(branch);
	}
	
	public Branch addExistingGymToExistingBranch(int branchId,int gymId) {
		Branch branch=branchRepo.findById(branchId).get();
		Gym gym=gymRepo.findById(branchId).get();
		branch.setGym(gym);
		return saveBranch(branch);
	}
	public Branch addNewGymToExistingBranch(int branchId,Gym gym)
	{
		Branch branch=branchRepo.findById(branchId).get();
		branch.setGym(gym);
		return saveBranch(branch);
	}
	
	public Branch addExistingBranchHeadToExistingBranch(int branchId,int branchHeadId) {
		Branch branch=branchRepo.findById(branchId).get();
		BranchHead branchHead=branchHeadRepo.findById(branchHeadId).get();
		branch.setBranchHead(branchHead);
		return saveBranch(branch);
	
	}
	public Branch addNewBranchHeadToExistingBranch(int branchId,BranchHead branchHead)
	{
		Branch branch=branchRepo.findById(branchId).get();
		branch.setBranchHead(branchHead);
		return saveBranch(branch);
	}
	
	
	public Branch addExistingCustomersToExistingBranch(int branchId,int customerId) {
		Branch branch=branchRepo.findById(branchId).get();
		Customers customers=customersRepo.findById(customerId).get();
		branch.setCustomers(customers);
		return saveBranch(branch);
	
	}
	public Branch addNewCustomersToExistingBranch(int branchId,Customers customers)
	{
		Branch branch=branchRepo.findById(branchId).get();
		branch.setCustomers(customers);
		return saveBranch(branch);
	}
	
	public Branch addExistingTrainersToExistingBranch(int branchId,int trainerId) {
		Branch branch=branchRepo.findById(branchId).get();
		Trainers trainers=trainersRepo.findById(trainerId).get();
		branch.setTrainers(trainers);
		return saveBranch(branch);
	
	}
	public Branch addNewTrainersToExistingBranch(int branchId,Trainers trainers)
	{
		Branch branch=branchRepo.findById(branchId).get();
		branch.setTrainers(trainers);
		return saveBranch(branch);
	}

	
	public Branch addExistingMemberShipToExistingBranch(int branchId,int memberShipId) {
		Branch branch=branchRepo.findById(branchId).get();
		MemberShip memberShip=memberShipRepo.findById(memberShipId).get();
		branch.setMemberShip(memberShip);
		return saveBranch(branch);
	
	}
	public Branch addNewMemberShipToExistingBranch(int branchId,MemberShip memberShip)
	{
		Branch branch=branchRepo.findById(branchId).get();
		branch.setMemberShip(memberShip);
		return saveBranch(branch);
	}
	
}

