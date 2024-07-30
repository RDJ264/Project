package com.example.BookWorm.models;

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
public class ProductGenre {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductGenreId",length=10,nullable=false)
    int gid;
	 @ManyToOne
	    @JoinColumn(name = "ProductId")
	    Product product;
	  @ManyToOne
	    @JoinColumn(name = "Genre Id")
	    Genre genre;
}
