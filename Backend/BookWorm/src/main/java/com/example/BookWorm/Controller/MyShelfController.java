package com.example.BookWorm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.BookWorm.models.MyShelf;
import com.example.BookWorm.service.MyShelfService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/my-shelves")
@CrossOrigin(origins = "*")  // Enable CORS for all origins
public class MyShelfController {

    @Autowired
    private MyShelfService myShelfService;
    @PostMapping("/move/{customerId}")
    public void moveProductsToShelf(@PathVariable Long customerId) {
    	myShelfService.moveProductsToShelf( customerId);
    }

    @GetMapping
    public List<MyShelf> getAllMyShelves() {
        return myShelfService.getAllMyShelves();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyShelf> getMyShelfById(@PathVariable int id) {
        Optional<MyShelf> myShelf = myShelfService.getMyShelfById(id);
        return myShelf.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<MyShelf> createMyShelf(@RequestBody MyShelf myShelf) {
        MyShelf savedMyShelf = myShelfService.saveMyShelf(myShelf);
        return new ResponseEntity<>(savedMyShelf, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<MyShelf> updateMyShelf(@PathVariable int id, @RequestBody MyShelf myShelf) {
        if (!myShelfService.getMyShelfById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        myShelf.setId(id);
        MyShelf updatedMyShelf = myShelfService.saveMyShelf(myShelf);
        return ResponseEntity.ok(updatedMyShelf);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMyShelf(@PathVariable int id) {
        if (!myShelfService.getMyShelfById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        myShelfService.deleteMyShelf(id);
        return ResponseEntity.noContent().build();
    }
}
