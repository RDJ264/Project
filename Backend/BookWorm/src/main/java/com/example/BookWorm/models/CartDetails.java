package com.example.BookWorm.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class CartDetails {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductGenreId",length=10,nullable=false)
    int ctid;
	 @ManyToOne
	    @JoinColumn(name = "Cart_Id")
	 @JsonManagedReference
	 CartMaster cid;
	 @ManyToOne
	    @JoinColumn(name = "ProductId")
	 @JsonManagedReference
	    Product product;
	 @Column(name = "cost")
	    private Double cost;
}
