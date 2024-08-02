package com.example.BookWorm.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.BookWorm.models.CartDetails;
import com.example.BookWorm.service.CartDetailsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartDetails")
@CrossOrigin(origins = "http://localhost:3000")  // Enable CORS for all origins
public class CartDetailsController {

    @Autowired
    private CartDetailsService cartDetailsService;

    @GetMapping
    public List<CartDetails> getAllCartDetails() {
        return cartDetailsService.getAllCartDetails();
    }

    @GetMapping("/{id}")
    public Optional<CartDetails> getCartDetailsById(@PathVariable int id) {
        return cartDetailsService.getCartDetailsById(id);
    }

    @PostMapping
    public CartDetails createCartDetails(@RequestBody CartDetails cartDetails) {
        return cartDetailsService.saveCartDetails(cartDetails);
    }

    @PutMapping("/{id}")
    public CartDetails updateCartDetails(@PathVariable int id, @RequestBody CartDetails cartDetails) {
        cartDetails.setCtid(id);
        return cartDetailsService.saveCartDetails(cartDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCartDetails(@PathVariable int id) {
        cartDetailsService.deleteCartDetails(id);
    }
}
