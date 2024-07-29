package com.example.BookWorm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class ProductType {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="Type-Id",length=10,nullable=false,columnDefinition="int default '1'")
private int id;
@Column(name="Type-Name",length=10,nullable=false)
private String name;
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
