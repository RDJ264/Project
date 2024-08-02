package com.example.BookWorm.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BookWorm.models.CartDetails;
import com.example.BookWorm.repository.CartDetailsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartDetailsService {

    @Autowired
    private CartDetailsRepository cartDetailsRepository;

    public List<CartDetails> getAllCartDetails() {
        return cartDetailsRepository.findAll();
    }

    public Optional<CartDetails> getCartDetailsById(int id) {
        return cartDetailsRepository.findById(id);
    }

    public CartDetails saveCartDetails(CartDetails cartDetails) {
        return cartDetailsRepository.save(cartDetails);
    }

    public void deleteCartDetails(int id) {
        cartDetailsRepository.deleteById(id);
    }
}
