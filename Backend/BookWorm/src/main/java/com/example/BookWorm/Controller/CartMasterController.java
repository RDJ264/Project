package com.example.BookWorm.Controller;

import com.example.BookWorm.models.CartMaster;
import com.example.BookWorm.service.CartMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
@CrossOrigin(origins = "http://localhost:3000")
public class CartMasterController {

    @Autowired
    private CartMasterService cartMasterService;

    @GetMapping
    public List<CartMaster> getAllCarts() {
        return cartMasterService.getAllCarts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartMaster> getCartById(@PathVariable int id) {
        Optional<CartMaster> cart = cartMasterService.getCartById(id);
        return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CartMaster> createCart(@RequestBody CartMasterRequest request) {
        CartMaster createdCart = cartMasterService.saveCart(request.getCartMaster(), request.getCustomerId());
        return ResponseEntity.ok(createdCart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartMaster> updateCart(@PathVariable int id, @RequestBody CartMaster cartDetails) {
        return ResponseEntity.ok(cartMasterService.updateCart(id, cartDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable int id) {
        cartMasterService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
    public static class CartMasterRequest {
        private CartMaster cartMaster;
        private long customerId;

        public CartMaster getCartMaster() {
            return cartMaster;
        }

        public void setCartMaster(CartMaster cartMaster) {
            this.cartMaster = cartMaster;
        }

        public long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(long customerId) {
            this.customerId = customerId;
        }
    }
}
