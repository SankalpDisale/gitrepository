package com.cg.opo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="customers")

public class Customer {
	@Id
	//@GeneratedValue
	@Column(name="customer_id",length=10)
	private int customerId;
	
	@Column(name="customer_name",length=15)
	private String customerName;
	
	@Column(name="customer_mobile",length=10)
	private long customerMobile;
	@Column(name="customer_email",length=25)
	private String customerEmail;
	@Column(name="customer_address",length=30)
	private String customerAddress;

	@JsonIgnore
	@OneToOne(mappedBy ="customer" )
	private User userId;
	@OneToMany(mappedBy="customer",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	
	private List<PizzaOrder> pod = new ArrayList<>();
	
	public Customer() {
		
	}

	public Customer(int customerId, String customerName, long customerMobile, String customerEmail,
			String customerAddress, User userId, List<PizzaOrder> pod) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.userId = userId;
		this.pod = pod;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(long customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public List<PizzaOrder> getPod() {
		return pod;
	}

	public void setPod(List<PizzaOrder> pod) {
		this.pod = pod;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerMobile="
				+ customerMobile + ", customerEmail=" + customerEmail + ", customerAddress=" + customerAddress
				+ ", userId=" + userId + ", pod=" + pod + "]";
	}


}
