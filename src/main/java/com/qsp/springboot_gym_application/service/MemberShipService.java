package com.qsp.springboot_gym_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_gym_application.dao.MemberShipDao;
import com.qsp.springboot_gym_application.dto.MemberShip;
import com.qsp.springboot_gym_application.exception.MemberShipIdNotFound;
import com.qsp.springboot_gym_application.util.ResponseStructure;

@Service
public class MemberShipService {
	@Autowired
	MemberShipDao memberShipDao;
	
	public ResponseEntity<ResponseStructure<MemberShip>>  saveMemberShip(MemberShip memberShip) {
		ResponseStructure<MemberShip> responseStructure=new ResponseStructure<MemberShip>();
		
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage(" MemberShip inserted");
		responseStructure.setData(memberShipDao.saveMemberShip(memberShip));
		return new ResponseEntity<ResponseStructure<MemberShip>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<MemberShip>>  fetchById(int id) {
		ResponseStructure<MemberShip> responseStructure=new ResponseStructure<MemberShip>();
		MemberShip memberShip=memberShipDao.fetchById(id);
		
		if(memberShip!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("memberShip fetched");
			responseStructure.setData(memberShipDao.fetchById(id));
			
			return new ResponseEntity<ResponseStructure<MemberShip>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new MemberShipIdNotFound();
		}
		
		
	}
	public ResponseEntity<ResponseStructure<MemberShip>>  deleteById(int id) {
		ResponseStructure<MemberShip> responseStructure=new ResponseStructure<MemberShip>();
		MemberShip memberShip=memberShipDao.fetchById(id);
		
		if(memberShip!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("memberShip fetched");
			responseStructure.setData(memberShipDao.fetchById(id));

			return new ResponseEntity<ResponseStructure<MemberShip>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new MemberShipIdNotFound();
		}
		
	}
	public ResponseEntity<ResponseStructure<MemberShip>> updateMemberShip(int id,MemberShip memberShip) {
		ResponseStructure<MemberShip> responseStructure=new ResponseStructure<MemberShip>();
		MemberShip memberShip1=memberShipDao.fetchById(id);
		
		if(memberShip1!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("memberShip updated");
			responseStructure.setData(memberShipDao.updateMemberShip(id, memberShip));

			return new ResponseEntity<ResponseStructure<MemberShip>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new MemberShipIdNotFound();
		}
		
	}

}
