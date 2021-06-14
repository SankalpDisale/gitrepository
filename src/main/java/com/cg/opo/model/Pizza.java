package com.cg.opo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pizza")

public class Pizza {

	@Id
	@Column(name = "pizza_id")
	private int pizzaId;

	@Column(name = "pizza_type")
	private String pizzaType;

	@Column(name = "pizza_name")
	private String pizzaName;
	
	@Column(name = "pizza_description")
	private String pizzaDescription;
	
	@Column(name="sz")
	private String size;

	@Column(name="ordered_quant")
	private int orderedQuantity;
	
	@Column(name = "pizza_cost")
	private double pizzaCost;
	
	@Column(name = "Sub_cost")
	private double SubCost;

	@JsonIgnore	
	@ManyToMany(mappedBy ="pizzaList")
	private List<PizzaOrder> pizzaord;
	
	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pizza(int pizzaId, String pizzaType, String pizzaName, String pizzaDescription, String size,
			int orderedQuantity, double pizzaCost) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaType = pizzaType;
		this.pizzaName = pizzaName;
		this.pizzaDescription = pizzaDescription;
		this.size = size;
		this.orderedQuantity = orderedQuantity;
		this.pizzaCost = pizzaCost;
	}


	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getPizzaType() {
		return pizzaType;
	}

	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public String getPizzaDescription() {
		return pizzaDescription;
	}

	public void setPizzaDescription(String pizzaDescription) {
		this.pizzaDescription = pizzaDescription;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getOrderedQuantity() {
		return orderedQuantity;
	}

	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	
	public double getPizzaCost() {
		return pizzaCost;
	}


	public void setPizzaCost(double pizzaCost) {
		this.pizzaCost = pizzaCost;
	}


	public double getSubCost() {
		return SubCost = orderedQuantity * pizzaCost;
	}

	public void setSubCost(double subCost) {
		this.SubCost = subCost;
	}

	
	public List<PizzaOrder> getPizzaord() {
		return pizzaord;
	}

	public void setPizzaord(List<PizzaOrder> pizzaord) {
		this.pizzaord = pizzaord;
	}


	@Override
	public String toString() {
		return "Pizza [pizzaId=" + pizzaId + ", pizzaType=" + pizzaType + ", pizzaName=" + pizzaName
				+ ", pizzaDescription=" + pizzaDescription + ", size=" + size + ", orderedQuantity=" + orderedQuantity
				+ ", pizzaCost=" + pizzaCost + ", SubCost=" + SubCost + "]";
	}


}