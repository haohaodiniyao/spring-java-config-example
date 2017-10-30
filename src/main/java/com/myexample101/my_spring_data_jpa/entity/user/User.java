package com.myexample101.my_spring_data_jpa.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	//Ö÷¼ü×ÔÔö
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String lastname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", lastname=" + lastname + "]";
	}

}