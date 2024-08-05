package com.example.BookWorm.service;

import com.example.BookWorm.models.CustomerMaster;
import com.example.BookWorm.repository.CustomerMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerMasterService {

    @Autowired
    private CustomerMasterRepository customerMasterRepository;

    public List<CustomerMaster> getAllCustomers() {
        return customerMasterRepository.findAll();
    }

    public Optional<CustomerMaster> getCustomerById(long id) {
        return customerMasterRepository.findById(id);
    }

    public CustomerMaster saveCustomer(CustomerMaster customer) {
        return customerMasterRepository.save(customer);
    }

    public void deleteCustomer(long id) {
        customerMasterRepository.deleteById(id);
    }

    public CustomerMaster updateCustomer(long id, CustomerMaster customerDetails) {
        return customerMasterRepository.findById(id).map(customer -> {
            customer.setCustomerName(customerDetails.getCustomerName());
            customer.setCustomerEmail(customerDetails.getCustomerEmail());
            customer.setCustomerPassword(customerDetails.getCustomerPassword());
            customer.setDob(customerDetails.getDob());
            customer.setPhoneNumber(customerDetails.getPhoneNumber());
            customer.setPan(customerDetails.getPan());
            customer.setCart(customerDetails.getCart());
            customer.setLibraryPackage(customerDetails.getLibraryPackage());
            return customerMasterRepository.save(customer);
        }).orElseGet(() -> {
            customerDetails.setCustomerId(id);
            return customerMasterRepository.save(customerDetails);
        });
    }
    public Optional<CustomerMaster> getCustomerByEmailAndPassword(String email, String password) {
        return customerMasterRepository.findByCustomerEmailAndCustomerPassword(email, password);
    }
}
