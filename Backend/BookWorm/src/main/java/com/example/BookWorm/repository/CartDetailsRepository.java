package com.example.BookWorm.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.BookWorm.models.CartDetails;
import com.example.BookWorm.models.CartMaster;

@Repository
public interface CartDetailsRepository extends JpaRepository<CartDetails, Integer> {
	List<CartDetails> findByCid_Id(int cartId);
//	Optional<CartDetails> findByCidAndProduct_ProductId(Long customerId, Long productId);
	 boolean existsByCidAndProduct_ProductId(CartMaster cartMaster, Long productId);
	 List<CartDetails> findByCid(CartMaster cartMaster);
}
