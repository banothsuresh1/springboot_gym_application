package com.qsp.springboot_gym_application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_gym_application.dto.MemberShip;

public interface MemberShipRepo extends JpaRepository<MemberShip, Integer> {

}
