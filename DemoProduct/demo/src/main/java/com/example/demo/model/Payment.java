package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Payment{
    
    
    private int productPrice;
    @Id
    private int productId;
    private int CustomerId;
    private String paymentMethod;
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    
    public int getCustomerId() {
        return CustomerId;
    }
    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Payment(int productId,int CustomerId,int productPrice, String paymentMethod) {
        this.productPrice = productPrice;
        this.paymentMethod = paymentMethod;
        this.productId = productId;
        this.CustomerId=CustomerId;
        
       
    }
    public Payment() {
    }
    @OneToOne
    @JsonBackReference
    Product product;//primary table obj
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    
}