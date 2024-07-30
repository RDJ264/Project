package com.example.BookWorm.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_master")
public class CustomerMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_email", length = 50, unique = true, nullable = false)
    private String customerEmail;

    @Column(name = "customer_password", length = 40, nullable = false)
    private String customerPassword;

    @Column(name = "dob")
    private LocalDateTime dob;

    @Column(name = "phone_number", length = 10)
    private String phoneNumber;

    @Column(name = "pan")
    private String pan;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartMaster cart;

    @ManyToOne
    @JoinColumn(name = "library_package_id")
    private LibraryPackage libraryPackage;

    // Getters and Setters

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public CartMaster getCart() {
        return cart;
    }

    public void setCart(CartMaster cart) {
        this.cart = cart;
    }

    public LibraryPackage getLibraryPackage() {
        return libraryPackage;
    }

    public void setLibraryPackage(LibraryPackage libraryPackage) {
        this.libraryPackage = libraryPackage;
    }
}
