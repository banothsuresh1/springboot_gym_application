package com.qsp.springboot_gym_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_gym_application.dto.BranchHead;
import com.qsp.springboot_gym_application.repo.BranchHeadRepo;

@Repository
public class BranchHeadDao {
	
	@Autowired
	BranchHeadRepo branchHeadRepo;
	
	public BranchHead saveBranchHead(BranchHead branchHead) {
		return branchHeadRepo.save(branchHead);
		
	}
	
	public BranchHead fetchById(int id) {
		Optional<BranchHead> branch=branchHeadRepo.findById(id);
		if(branch.isPresent()) {
			return branch.get();
		}
		else {
			return null;
		}
	}
	
	public BranchHead deleteById(int id)
	{
		Optional<BranchHead> branchHead=branchHeadRepo.findById(id);
		if(branchHead.isPresent()) {
			
			branchHeadRepo.deleteById(id);
			return branchHead.get();
		}
		return null;
	}
	
	public BranchHead updateBranchHead(int id,BranchHead branchHead) {
		branchHead.setBranchHeadId(id);
		return branchHeadRepo.save(branchHead);
	}
}
