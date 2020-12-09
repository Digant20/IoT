package com.iot.sample.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	
	@Id
	private String id;
	private String firstName;
	private int mobile;
	private String email;
	
	public User() {
		
	}

	
	public User(String firstName, int mobile, String email) {
		super();
		this.firstName = firstName;
		this.mobile = mobile;
		this.email = email;
	}



	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", mobile=" + mobile + ", email=" + email + "]";
	}

	
	
	
	
	
	
	
	

}
