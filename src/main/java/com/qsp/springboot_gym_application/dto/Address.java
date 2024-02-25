package com.qsp.springboot_gym_application.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int addressId;
	private String addressArea;
	private long addressPincode;
	private String addressCity;
	private String addressLandMark;
	private String addressState;
	


	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressArea() {
		return addressArea;
	}

	public void setAddressArea(String addressArea) {
		this.addressArea = addressArea;
	}

	public long getAddressPincode() {
		return addressPincode;
	}

	public void setAddressPincode(long addressPincode) {
		this.addressPincode = addressPincode;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressLandMark() {
		return addressLandMark;
	}

	public void setAddressLandMark(String addressLandMark) {
		this.addressLandMark = addressLandMark;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}	
}
