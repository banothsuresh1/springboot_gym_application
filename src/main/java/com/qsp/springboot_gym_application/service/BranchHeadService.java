package com.qsp.springboot_gym_application.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_gym_application.dao.BranchHeadDao;
import com.qsp.springboot_gym_application.dto.BranchHead;
import com.qsp.springboot_gym_application.exception.BranchHeadIdNotFound;

import com.qsp.springboot_gym_application.util.ResponseStructure;

@Service
public class BranchHeadService {
	@Autowired
	BranchHeadDao branchHeadDao;
	
	public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(BranchHead branchHead) {
		ResponseStructure<BranchHead> responseStructure=new ResponseStructure<BranchHead>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("branchHead inserted");
		responseStructure.setData(branchHeadDao.saveBranchHead(branchHead));
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<BranchHead>>  fetchById(int id) {
		ResponseStructure<BranchHead> responseStructure=new ResponseStructure<BranchHead>();
		BranchHead branchHead=branchHeadDao.fetchById(id);
		
		if(branchHead!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("fetched branchead");
			responseStructure.setData(branchHeadDao.fetchById(id));
			
			return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new BranchHeadIdNotFound();
		}
	}
	

	public ResponseEntity<ResponseStructure<BranchHead>> deleteById(int id) {
		ResponseStructure<BranchHead> responseStructure=new ResponseStructure<BranchHead>();
		BranchHead branchHead=branchHeadDao.fetchById(id);
		
		if(branchHead!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("delete branchead");
			responseStructure.setData(branchHeadDao.fetchById(id));
			
			return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new BranchHeadIdNotFound();
		}
		
			
	}
	
	public ResponseEntity<ResponseStructure<BranchHead>>  updateBranchHead(int id,BranchHead branchHead) {
		ResponseStructure<BranchHead> responseStructure=new ResponseStructure<BranchHead>();
		BranchHead branchHead1=branchHeadDao.updateBranchHead(id, branchHead);
				if(branchHead1!=null) {
					responseStructure.setStatus(HttpStatus.OK.value());
					responseStructure.setMessage("updated branchead");
					responseStructure.setData(branchHeadDao.updateBranchHead(id, branchHead));
					
					return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.OK);
				}
				else {
					throw new BranchHeadIdNotFound();
				}
		
	}
	
	

}
