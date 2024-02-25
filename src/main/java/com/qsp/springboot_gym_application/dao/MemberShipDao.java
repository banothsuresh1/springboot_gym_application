package com.qsp.springboot_gym_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_gym_application.dto.MemberShip;
import com.qsp.springboot_gym_application.repo.MemberShipRepo;

@Repository
public class MemberShipDao {
	@Autowired
	MemberShipRepo memberShipRepo;
	
	public MemberShip saveMemberShip(MemberShip memberShip) {
		return memberShipRepo.save(memberShip);
	}
	public MemberShip fetchById(int id) {
		Optional<MemberShip> memberShip=memberShipRepo.findById(id);
		
		if(memberShip.isPresent()) {
			return memberShip.get();
		}
		else {
			return null;
		}
	}
	
	public MemberShip deleteByid(int id) {
		Optional<MemberShip> memberShip=memberShipRepo.findById(id);
		if(memberShip.isPresent()) {
			memberShipRepo.deleteById(id);
			return memberShip.get();
		}
		else {
			return null;
		}
	}
	
	public MemberShip updateMemberShip(int id,MemberShip memberShip) {
		memberShip.setMemberShipId(id);
		return memberShipRepo.save(memberShip);
	}
	

}
