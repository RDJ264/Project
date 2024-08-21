package com.example.BookWorm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookWorm.Controller.ProductController;
import com.example.BookWorm.models.CartMaster;
import com.example.BookWorm.models.CustomerMaster;
import com.example.BookWorm.models.InvoiceDetail;
import com.example.BookWorm.models.MyShelf;
import com.example.BookWorm.models.ProductOnShelf;
import com.example.BookWorm.repository.CustomerMasterRepository;
import com.example.BookWorm.repository.InvoiceDetailRepository;
import com.example.BookWorm.repository.ProductOnShelfRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.example.BookWorm.models.Product;
@Service
public class ProductOnShelfService {

    @Autowired
    private ProductOnShelfRepository productOnShelfRepository;
    @Autowired
    private CustomerMasterRepository customerrepo;
    public List<ProductOnShelf> getAllProductsOnShelf() {
        return productOnShelfRepository.findAll();
    }
    
    public Boolean checkproductonrepo(Long productid,Long customerid) {
    	CustomerMaster c1=customerrepo.getById(customerid);
    	List<ProductOnShelf> products_on_shelf=productOnShelfRepository.findAll();
    	for(ProductOnShelf p1:products_on_shelf) {
    		if(p1.getProduct().getProductId()==productid&&p1.getTranType().equals("B")&&p1.getShelf().getId()==c1.getShelf().getId()) {
    			return true;
    		}
    	}
    	return false;
    }  
    public Optional<ProductOnShelf> getProductOnShelfById(Long id) {
        return productOnShelfRepository.findById(id);
    }
    @Autowired
    private CustomerMasterRepository customerMasterRepository;
    public List<ProductOnShelf> getProductsOnShelfByCustomerId(Long customerId) {
        CustomerMaster customer = customerMasterRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
        
        MyShelf shelf = customer.getShelf();
        
        if (shelf == null) {
            throw new RuntimeException("Shelf not found for customer id: " + customerId);
        }
        
        return productOnShelfRepository.findByShelf(shelf);
    }
    public ProductOnShelf saveProductOnShelf(ProductOnShelf productOnShelf) {
        return productOnShelfRepository.save(productOnShelf);
    }

    public void deleteProductOnShelf(Long id) {
        productOnShelfRepository.deleteById(id);
    }
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;  
    @Autowired
    private CustomerMasterRepository cr;
    public ProductOnShelf transferProductToShelf(Long productId,Long CustomerId) {
        // Fetch the InvoiceDetail by productId
        List<InvoiceDetail> invoiceDetails = invoiceDetailRepository.findInvoiceByProductId(productId);

        if (invoiceDetails.isEmpty()) {
            throw new IllegalArgumentException("No InvoiceDetails found for the given productId: " + productId);
        }

        // Assuming you want to transfer the first found InvoiceDetail
        InvoiceDetail invoiceDetail = invoiceDetails.get(0);
         CustomerMaster c1=cr.getById(CustomerId);
        // Create a new ProductOnShelf object
         MyShelf m1=c1.getShelf();
         m1.setNoofbooks(m1.getNoofbooks()+1);
        ProductOnShelf productOnShelf = new ProductOnShelf();
        productOnShelf.setProduct(invoiceDetail.getProduct());
        productOnShelf.setBasePrice(invoiceDetail.getBasePrice());
        productOnShelf.setTranType("R");
        productOnShelf.setRentNoOfDays(invoiceDetail.getRentNoOfDays());
        productOnShelf.setShelf(m1);
        // Additional logic if needed (e.g., setting Shelf, calculating Rent Expiry Date, etc.)
        productOnShelf.setRentexpirydate(LocalDate.now().plusDays(invoiceDetail.getRentNoOfDays()));
        // Save the ProductOnShelf to the repository
        return productOnShelfRepository.save(productOnShelf);
    }
   
}
