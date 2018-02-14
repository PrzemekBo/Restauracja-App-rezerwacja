package com.restaurant.demo.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Api(description = "This is Guest class")
@Entity
@Table(name = "guest")
public class Guest{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "guest_id")
	@ApiModelProperty(value ="This is Id of Guest",required = true)
	private Long id;
	
	@Column(name = "name")
	@ApiModelProperty(value = "This is first name of guest", required = true)
	private String name;
	
	@Column(name = "surname")
	@ApiModelProperty(value = "This is surename of guest", required = true)
	private String surname;
	
	@Column(name = "email")
	@ApiModelProperty(value = "This is email of costumer", required = true)
	private String email;
	
	@Column(name = "number")
	@ApiModelProperty(value = "This is phone number of guest", required = true)
	private String number;

	public Guest() {};
	
	public Guest(String name, String surname, String email, String number) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}





