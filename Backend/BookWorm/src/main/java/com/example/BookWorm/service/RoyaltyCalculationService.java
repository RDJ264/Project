package com.example.BookWorm.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BookWorm.models.RoyaltyCalculation;
import com.example.BookWorm.repository.RoyaltyCalculationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoyaltyCalculationService {

    @Autowired
    private RoyaltyCalculationRepository royaltyCalculationRepository;

    public List<RoyaltyCalculation> getAllRoyaltyCalculations() {
        return royaltyCalculationRepository.findAll();
    }

    public Optional<RoyaltyCalculation> getRoyaltyCalculationById(int id) {
        return royaltyCalculationRepository.findById(id);
    }

    public RoyaltyCalculation saveRoyaltyCalculation(RoyaltyCalculation royaltyCalculation) {
        return royaltyCalculationRepository.save(royaltyCalculation);
    }

    public void deleteRoyaltyCalculation(int id) {
        royaltyCalculationRepository.deleteById(id);
    }
}

