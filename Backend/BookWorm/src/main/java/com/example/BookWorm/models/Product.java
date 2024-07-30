package com.example.BookWorm.models;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Product {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductId",length=10,nullable=false)
	private int id;
	@Column(name="ProductName",length=50,nullable=false)
	private String name;
	@Column(name="ProductEnglishName",length=50,nullable=false)
	private String Ename;
	 @ManyToOne
	    //Adding the name
	    @JoinColumn(name = "ProductTypeid")
	    ProductType ob;
	 @OneToOne
	 @JoinColumn(name = "Lanuageid")
	 Language language;
	 @OneToMany(mappedBy = "product")
	    Set<ProductGenre> productgenre;

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
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public ProductType getOb() {
		return ob;
	}
	public void setOb(ProductType ob) {
		this.ob = ob;
	}
	public Product(int id, String name, String ename, ProductType ob) {
		super();
		this.id = id;
		this.name = name;
		Ename = ename;
		this.ob = ob;
	}
 
}
