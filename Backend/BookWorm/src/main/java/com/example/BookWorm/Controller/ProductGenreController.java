package com.example.BookWorm.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BookWorm.models.ProductGenre;
import com.example.BookWorm.service.ProductGenreService;

@RestController
@RequestMapping("/api/product-genres")
public class ProductGenreController {

    @Autowired
    private ProductGenreService productGenreService;

    @GetMapping
    public ResponseEntity<List<ProductGenre>> getAllProductGenres() {
        List<ProductGenre> productGenres = productGenreService.getAllProductGenres();
        return new ResponseEntity<>(productGenres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductGenre> getProductGenreById(@PathVariable int id) {
        return productGenreService.getProductGenreById(id)
                .map(productGenre -> new ResponseEntity<>(productGenre, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductGenre>> getProductGenresByProductId(@PathVariable Long productId) {
        List<ProductGenre> productGenres = productGenreService.getProductGenresByProductId(productId);
        if (productGenres.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(productGenres, HttpStatus.OK);
    }
}
