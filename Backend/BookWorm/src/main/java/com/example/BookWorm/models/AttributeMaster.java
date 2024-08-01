package com.example.BookWorm.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity

public class AttributeMaster {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Attribute_Id",length=10,nullable=false)
	private int Id;
	public AttributeMaster() {}
	@Column(name="Attribute_Name",length=50,nullable=false)
	private String name;
	
	@OneToMany(mappedBy = "am")
	@JsonBackReference
    Set<Product_Type_Attribute> productgenre;

	@OneToMany(mappedBy = "am1")
	@JsonBackReference
    Set<Product_Type_Attribute_Value> productgenre1;
    
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
