package com.example.BookWorm.models;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class ProductType {
@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="TypeId",length=10,nullable=false)
private int id;

@Column(name="TypeName",length=10,nullable=false)
private String name;

@OneToMany(cascade = CascadeType.ALL)
private Set<Product> ob;



public int getId() {
	return id;
}
public ProductType(int id, String name) {
	this.id = id;
	this.name = name;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
