package com.example.BookWorm.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RoyaltyCalculation {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="RoyCalId", length=10, nullable=false)
    private int id;

    @OneToOne
    @JoinColumn(name = "Invoice_id", referencedColumnName = "invoice_id")
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "Ben_id", referencedColumnName = "ben_id")
    private BeneficiaryMaster beneficiaryMaster;

    @Column(name = "royalty_date")
    private LocalDateTime royaltyDate;

    @OneToOne
    @JoinColumn(name = "Product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "TransactionType")
    private String transactionType;

    @Column(name = "sales_price")
    private double salesPrice;

    @Column(name = "base_price")
    private double basePrice;

    @Column(name = "Royalty_On_base_price")
    private double royaltyOnBasePrice;

	public void setId(int id2) {
		// TODO Auto-generated method stub
		
	}
}
