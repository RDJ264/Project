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
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GenreId",length=10,nullable=false)
	private int id;
	@Column(name="GenreName",length=50,nullable=false)
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
