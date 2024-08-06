package com.example.BookWorm.repository;

import com.example.BookWorm.models.CartMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartMasterRepository extends JpaRepository<CartMaster, Integer> {
}
