package com.example.BookWorm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookWorm.models.MyShelf;
import com.example.BookWorm.models.ProductOnShelf;

@Repository
public interface ProductOnShelfRepository extends JpaRepository<ProductOnShelf, Long> {
	 List<ProductOnShelf> findByShelf(MyShelf shelf);
}
