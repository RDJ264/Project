package com.example.BookWorm.repository;

import com.example.BookWorm.models.Invoice;
import com.example.BookWorm.models.InvoiceDetail;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
	List<InvoiceDetail> findByInvoice_InvoiceId(Long invoiceId);

    @Transactional
    @Modifying
    @Query("DELETE FROM InvoiceDetail id WHERE id.invoice.invoiceId = :invoiceId")
    void deleteByInvoiceId(Long invoiceId);


    @Query("SELECT id FROM InvoiceDetail id WHERE id.product.productId = :productId")
    List<InvoiceDetail> findInvoiceByProductId(@Param("productId") Long productId);}

