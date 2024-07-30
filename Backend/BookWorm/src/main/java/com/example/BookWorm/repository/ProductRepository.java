package com.example.BookWorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookWorm.models.Product;
import com.example.BookWorm.models.ProductType;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
