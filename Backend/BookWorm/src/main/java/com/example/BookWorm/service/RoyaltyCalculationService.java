package com.example.BookWorm.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookWorm.models.InvoiceDetail;
import com.example.BookWorm.models.ProdBeneficiaryMaster;
import com.example.BookWorm.models.RoyaltyCalculation;
import com.example.BookWorm.repository.InvoiceDetailRepository;
import com.example.BookWorm.repository.ProductBeneficiaryMaster;
import com.example.BookWorm.repository.RoyaltyCalculationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;
    @Autowired
    private ProductBeneficiaryMaster prodBeneficiaryMasterRepository;

    public void calculateAndSaveRoyalties(Long invoiceId) {
        List<InvoiceDetail> invoiceDetails = invoiceDetailRepository.findByInvoice_InvoiceId(invoiceId);

        for (InvoiceDetail detail : invoiceDetails) {
            Long productId = detail.getProduct().getProductId();
            Set<ProdBeneficiaryMaster> beneficiaries = prodBeneficiaryMasterRepository.findByProduct_ProductId(productId);

            double salesPrice = detail.getBasePrice(); // Assuming salesPrice is basePrice from InvoiceDetail

            for (ProdBeneficiaryMaster beneficiary : beneficiaries) {
                double percentage = beneficiary.getProdBenPercentage();
                double royaltyAmount = (percentage / 100) * salesPrice;

                RoyaltyCalculation royalty = new RoyaltyCalculation();
                royalty.setInvoice(detail.getInvoice());
                royalty.setProduct(detail.getProduct());
                royalty.setBeneficiaryMaster(beneficiary.getBeneficiary());
                royalty.setRoyaltyDate(LocalDateTime.now()); // or set the required date
//                royalty.setQuantity(detail.getQuantity()); // Assuming quantity is available
                royalty.setTransactionType(detail.getTranType()); // Assuming transaction type is available
                royalty.setSalesPrice(salesPrice);
                royalty.setBasePrice(detail.getBasePrice());
                royalty.setRoyaltyOnBasePrice(royaltyAmount);

                royaltyCalculationRepository.save(royalty);
            }
        }
    }
}

