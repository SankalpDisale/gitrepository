package com.cg.opo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "users")
public class User {
	

	@Id
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name")
	private String userName;
	@Column(name="user_password")
	private String pass;
	
	@OneToOne(targetEntity = Customer.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public User(int userId, String userName, String pass, Customer customer) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.pass = pass;
		this.customer = customer;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", pass=" + pass + ", customer=" + customer
				+ "]";
	}

}
