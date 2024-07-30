package com.example.BookWorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookWorm.models.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType,Integer> {

}
