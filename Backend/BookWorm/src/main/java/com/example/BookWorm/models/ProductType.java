package com.example.BookWorm.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ProductType {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TypeId", nullable = false)
    private int id;

    @Column(name = "TypeName", length = 50, nullable = false)
    private String name;

//    @OneToMany(mappedBy = "pt", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Set<Product_Type_Attribute> productGenres;

    public ProductType() {}

    public ProductType(int id, String name) {
        this.id = id;
        this.name = name;
    }

	public int getId() {
		return id;
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
