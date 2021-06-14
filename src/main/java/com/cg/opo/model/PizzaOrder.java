package com.cg.opo.model;

import java.util.*;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pizzaorder")
public class PizzaOrder {

	@Id
	@Column(name="b_Id")
	private int bookingOrderId;
	@Column(name = "order_type",length = 50)
	private String orderType;
	@Column(name="t_Mode")
	private String transactionMode;
	@Column(name="t_cost")
	private double totalCost;
	@Column(name = "pizza_cost_After_Coupan",length = 10)
	private double pizzaCostAfterCoupan;
	@Column(name = "disc_cent")
	private double discountPercent;
	
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Kolkata")
	@Column(name="order_date")
	private Date orderDateL = new Date();
	
    @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name = "pizzaorder_pizza", 
    joinColumns = @JoinColumn(name = "b_Id", referencedColumnName = "b_Id"), 
    inverseJoinColumns = @JoinColumn(name = "pizza_id", 
    referencedColumnName = "pizza_id"))
    private List<Pizza> pizzaList = new ArrayList<>();

    @OneToOne(targetEntity = Coupan.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="coupan_id")
    private Coupan coupan;
 
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

	public PizzaOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PizzaOrder(int bookingOrderId, String orderType, String transactionMode, double totalCost,
			double pizzaCostAfterCoupan, double discountPercent, Date orderDateL, Coupan coupan, Customer customer) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderType = orderType;
		this.transactionMode = transactionMode;
		this.totalCost = totalCost;
		this.pizzaCostAfterCoupan = pizzaCostAfterCoupan;
		this.discountPercent = discountPercent;
		this.orderDateL = orderDateL;
		this.coupan = coupan;
		this.customer = customer;
	}

	public double getTotalCost() {
        return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getPizzaCostAfterCoupan() {
		return pizzaCostAfterCoupan;
	}
	
	public void setPizzaCostAfterCoupan(double pizzaCostAfterCoupan) {
		this.pizzaCostAfterCoupan = pizzaCostAfterCoupan;
	}

	
	public int getBookingOrderId() {
		return bookingOrderId;
	}


	public void setBookingOrderId(int bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}


	public String getOrderType() {
		return orderType;
	}


	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}


	public String getTransactionMode() {
		return transactionMode;
	}


	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}


	public double getDiscountPercent() {
		return discountPercent;
	}

	
	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	
	public Date getOrderDateL() {
		return orderDateL;
	}


	public void setOrderDateL(Date orderDateL) {
		this.orderDateL = orderDateL;
	}


	public List<Pizza> getPizzaList() {
		return pizzaList;
	}


	public void setPizzaList(List<Pizza> pizzaList) {
		this.pizzaList = pizzaList;
	}


	public Coupan getCoupan() {
		return coupan;
	}


	public void setCoupan(Coupan coupan) {
		this.coupan = coupan;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "PizzaOrder [bookingOrderId=" + bookingOrderId + ", orderType=" + orderType + ", transactionMode="
				+ transactionMode + ", totalCost=" + totalCost + ", pizzaCostAfterCoupan=" + pizzaCostAfterCoupan
				+ ", discountPercent=" + discountPercent + ", orderDateL=" + orderDateL + ", pizzaList=" + pizzaList
				+ ", coupan=" + coupan + ", customer=" + customer + "]";
	}

	
}