package com.example.BookWorm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class AttributeMaster {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Attribute_Id",length=10,nullable=false)
	private int Id;
	@Column(name="Attribute_Name",length=50,nullable=false)
	private String name;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AttributeMaster(int id, String name) {
		Id = id;
		this.name = name;
	}
	
}
