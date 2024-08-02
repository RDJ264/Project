package com.example.BookWorm.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.BookWorm.models.RoyaltyCalculation;
import com.example.BookWorm.service.RoyaltyCalculationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/royaltyCalculations")
@CrossOrigin(origins = "http://localhost:3000")  // Enable CORS for all origins
public class RoyaltyCalculationController {

    @Autowired
    private RoyaltyCalculationService royaltyCalculationService;

    @GetMapping
    public List<RoyaltyCalculation> getAllRoyaltyCalculations() {
        return royaltyCalculationService.getAllRoyaltyCalculations();
    }

    @GetMapping("/{id}")
    public Optional<RoyaltyCalculation> getRoyaltyCalculationById(@PathVariable int id) {
        return royaltyCalculationService.getRoyaltyCalculationById(id);
    }

    @PostMapping
    public RoyaltyCalculation createRoyaltyCalculation(@RequestBody RoyaltyCalculation royaltyCalculation) {
        return royaltyCalculationService.saveRoyaltyCalculation(royaltyCalculation);
    }

    @PutMapping("/{id}")
    public RoyaltyCalculation updateRoyaltyCalculation(@PathVariable int id, @RequestBody RoyaltyCalculation royaltyCalculation) {
        royaltyCalculation.setId(id);
        return royaltyCalculationService.saveRoyaltyCalculation(royaltyCalculation);
    }

    @DeleteMapping("/{id}")
    public void deleteRoyaltyCalculation(@PathVariable int id) {
        royaltyCalculationService.deleteRoyaltyCalculation(id);
    }
}
