package com.pg.testapps.usermgmt.domain;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	private Integer id;
	@Size(min=2, message="Username Should have at least 2 Character!")
	private String username;
	@Size(min=2, message="Password Should have at least 2 Character!")
	private String password;
	@Size(min=2, message="FirstName Should have at least 2 Character!")
	private String firstName;
	@Size(min=2, message="LastName Should have at least 2 Character!")
	private String lastName;
	@Past(message="Birthdate should be a past Date!")
	private Date birthDate;
	
	public User() {
	}

	public User(Integer id, String usernane, String password, String firstName, String lastName, Date birthDate) {
		super();
		this.id = id;
		this.username = usernane;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String usernane) {
		this.username = usernane;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
	}

}
