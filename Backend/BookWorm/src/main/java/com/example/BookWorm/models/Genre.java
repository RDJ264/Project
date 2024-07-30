package com.example.BookWorm.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity

public class Genre {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Genre Id",length=10,nullable=false,columnDefinition="int default '1'")
	private int id;
	@Column(name="Genre Name",length=50,nullable=false)
	private String name;
	 @OneToMany(mappedBy = "genre")
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
	public Genre(int id, String name) {
		this.id = id;
		this.name = name;
	}

}
