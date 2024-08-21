package com.example.BookWorm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BookWorm.models.InvoiceDetail;
import com.example.BookWorm.models.Product;
import com.example.BookWorm.repository.InvoiceDetailRepository;
import com.example.BookWorm.repository.ProductRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;
@Autowired
private ProductRepository productmasterrepo;
    // Retrieves all invoice details
    public List<InvoiceDetail> getAllInvoiceDetails() {
        return invoiceDetailRepository.findAll();
    }


    public List<InvoiceDetail> getInvoiceByProductId(Long productId) {
        return invoiceDetailRepository.findInvoiceByProductId(productId);
    }
    public List<InvoiceDetail> getInvoiceDetailsByInvoiceId(Long invoiceId) {
        return invoiceDetailRepository.findByInvoice_InvoiceId(invoiceId);
    }
    // Retrieves an invoice detail by its ID
    public Optional<InvoiceDetail> getInvoiceDetailById(int id) {
        return invoiceDetailRepository.findById(id);
    }
    @Transactional
    public void deleteInvoiceDetailsByInvoiceId(Long invoiceId) {
        List<InvoiceDetail> invoiceDetails = invoiceDetailRepository.findByInvoice_InvoiceId(invoiceId);
        for (InvoiceDetail detail : invoiceDetails) {
            System.out.println("Checking InvoiceDetail: " + detail.getInvDtlId() + " with TranType: " + detail.getTranType());
            if ("P".equals(detail.getTranType())) {
                System.out.println("Deleting InvoiceDetail: " + detail.getInvDtlId());
                invoiceDetailRepository.delete(detail); // Deletes only the specific InvoiceDetail
            }
        }
    }
public void deletebyproduct(long productid) {
	List<InvoiceDetail> i1=invoiceDetailRepository.findInvoiceByProductId(productid);
	for(InvoiceDetail idl:i1) {
		invoiceDetailRepository.delete(idl);
	}
}


 // Saves a new invoice detail or updates an existing one
    public InvoiceDetail saveInvoiceDetail(InvoiceDetail invoiceDetail) {
        // Validate required fields
        if (invoiceDetail.getInvoice() == null) {
            throw new IllegalArgumentException("Invoice cannot be null");
        }
        if (invoiceDetail.getProduct() == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (invoiceDetail.getQuantity() == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }
        if (invoiceDetail.getBasePrice() == null) {
            throw new IllegalArgumentException("Base price cannot be null");
        }
        if (invoiceDetail.getTranType() == null || invoiceDetail.getTranType().isEmpty()) {
            throw new IllegalArgumentException("Transaction type cannot be null or empty");
        }
        return invoiceDetailRepository.save(invoiceDetail);
    }

    // Deletes an invoice detail by its ID
    public void deleteInvoiceDetail(int id) {
        invoiceDetailRepository.deleteById(id);
    }
   
}
