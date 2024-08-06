package com.example.BookWorm.service;

import com.example.BookWorm.models.CartMaster;
import com.example.BookWorm.models.CustomerMaster;
import com.example.BookWorm.repository.CartMasterRepository;
import com.example.BookWorm.repository.CustomerMasterRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartMasterService {

    @Autowired
    private CartMasterRepository cartMasterRepository;
    @Autowired
    private CustomerMasterRepository customerMasterRepository;

    public List<CartMaster> getAllCarts() {
        return cartMasterRepository.findAll();
    }

    public Optional<CartMaster> getCartById(int id) {
        return cartMasterRepository.findById(id);
    }

    @Transactional
    public CartMaster saveCart(CartMaster cartMaster,long id) {
        // Save the CartMaster entity
        CartMaster createdCart = cartMasterRepository.save(cartMaster);

        // Find the customer by ID
        CustomerMaster customer = customerMasterRepository.findById(id).orElse(null);
        if (customer != null) {
            // Update the customer with the new cart
            customer.setCart(createdCart);
            customerMasterRepository.save(customer);
        }
        
        return createdCart;
    }

    public void deleteCart(int id) {
        cartMasterRepository.deleteById(id);
    }

    public CartMaster updateCart(int id, CartMaster cartDetails) {
        return cartMasterRepository.findById(id).map(cart -> {
            cart.setNoofbooks(cartDetails.getNoofbooks());
            cart.setCost(cartDetails.getCost());
            return cartMasterRepository.save(cart);
        }).orElseGet(() -> {
            cartDetails.setId(id);
            return cartMasterRepository.save(cartDetails);
        });
    }
    
}
