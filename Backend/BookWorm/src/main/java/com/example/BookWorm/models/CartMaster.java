package com.example.BookWorm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class CartMaster {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CartMaster(int id, int noofbooks, double cost) {
		super();
		this.id = id;
		this.noofbooks = noofbooks;
		this.cost = cost;
	}
	public int getNoofbooks() {
		return noofbooks;
	}
	public void setNoofbooks(int noofbooks) {
		this.noofbooks = noofbooks;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Cart_Id",length=10,nullable=false)
	private int id;
	@Column(name="Number_Of_Books",length=50,nullable=false)
	private int noofbooks;
	@Column(name="Cost",length=50,nullable=false)
	private double cost;
}
