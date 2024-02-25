package com.marketingapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "registration")
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)			  //it helps to autogenerate like iteration for id ex.-1,2,3
	private long id; 
	
	@Column(name = "first_name", length = 10, nullable = false)	  //snake cassing is must for name value
	private String firstName;									  //camel cassing(for jsp page)
	
	@Column(name = "last_name", length = 10, nullable = false)
	private String lastName;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "mobile", unique = true, nullable = false)
	private long mobile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	
}
