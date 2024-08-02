package com.example.BookWorm.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.BookWorm.models.CartDetails;

@Repository
public interface CartDetailsRepository extends JpaRepository<CartDetails, Integer> {
}
