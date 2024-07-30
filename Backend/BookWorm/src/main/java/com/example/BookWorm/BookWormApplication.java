package com.example.BookWorm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.BookWorm.models.ProductType;
import com.example.BookWorm.repository.ProductRepository;
import com.example.BookWorm.repository.ProductTypeRepository;

@SpringBootApplication

public class BookWormApplication {
	@Autowired ProductRepository ob;
    @Autowired ProductTypeRepository ob1;
	public static void main(String[] args) {
		SpringApplication.run(BookWormApplication.class, args);
	}
	  
}
