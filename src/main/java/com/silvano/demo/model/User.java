package com.silvano.demo.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Access(AccessType.FIELD)
public class User extends ParentEntity implements Serializable {
	private static final long serialVersionUID = -4611815928732870812L;

	@Column(name = "first_name", nullable = false, length = 255)
	private String firsName;

	@Column(name = "second_name", nullable = true, length = 255)
	private String secondName;

	@Column(name = "first_surname", nullable = false, length = 255)
	private String firstSurName;

	@Column(name = "second_surname", nullable = true, length = 255)
	private String secondSurName;

	@Column(name = "phone", nullable = true, length = 30)
	private String phone;

	@Column(name = "address", nullable = false, length = 150)
	private String address;

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstSurName() {
		return firstSurName;
	}

	public void setFirstSurName(String firstSurName) {
		this.firstSurName = firstSurName;
	}

	public String getSecondSurName() {
		return secondSurName;
	}

	public void setSecondSurName(String secondSurName) {
		this.secondSurName = secondSurName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
