
package com.qsp.springboot_gym_application.dto;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int branchId;
	private String branchName;
	private long branchPhone;
	private String branchEmail;
	private String branchTimings;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Gym gym;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BranchHead branchHead;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customers customers;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Trainers trainers;
	
	@OneToOne(cascade = CascadeType.ALL)
	private MemberShip memberShip;
	

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public long getBranchPhone() {
		return branchPhone;
	}

	public void setBranchPhone(long branchPhone) {
		this.branchPhone = branchPhone;
	}

	public String getBranchEmail() {
		return branchEmail;
	}

	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}

	public String getBranchTimings() {
		return branchTimings;
	}

	public void setBranchTimings(String branchTimings) {
		this.branchTimings = branchTimings;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Gym getGym() {
		return gym;
	}

	public void setGym(Gym gym) {
		this.gym = gym;
	}

	public BranchHead getBranchHead() {
		return branchHead;
	}

	public void setBranchHead(BranchHead branchHead) {
		this.branchHead = branchHead;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public Trainers getTrainers() {
		return trainers;
	}

	public void setTrainers(Trainers trainers) {
		this.trainers = trainers;
	}

	public MemberShip getMemberShip() {
		return memberShip;
	}

	public void setMemberShip(MemberShip memberShip) {
		this.memberShip = memberShip;
	}

}
