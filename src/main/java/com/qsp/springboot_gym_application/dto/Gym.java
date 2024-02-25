package com.qsp.springboot_gym_application.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class Gym {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int gymId;
	@NotNull(message = "GymName cannot be Null")
	@NotBlank(message = "GymName cannot be Blank")
	private String gymName;
	private String gymGst;
	private String gymOwner;
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	
	private long gymPhone;
	@Email(message = "mail is not valid")
	private String gymWebsite;
	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getGymGst() {
		return gymGst;
	}
	public void setGymGst(String gymGst) {
		this.gymGst = gymGst;
	}
	public String getGymOwner() {
		return gymOwner;
	}
	public void setGymOwner(String gymOwner) {
		this.gymOwner = gymOwner;
	}
	public long getGymPhone() {
		return gymPhone;
	}
	public void setGymPhone(long gymPhone) {
		this.gymPhone = gymPhone;
	}
	public String getGymWebsite() {
		return gymWebsite;
	}
	public void setGymWebsite(String gymWebsite) {
		this.gymWebsite = gymWebsite;
	}
	
	
	

}
