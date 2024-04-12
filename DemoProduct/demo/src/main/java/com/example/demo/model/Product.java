package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
    @Id
    private int productId;
    
    private String plantName;
    private String plantTemperature;
    private double plantPrice;
    private String potColor;
    private int plantGuarantee;
    private String plantOffer ;
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getPlantName() {
        return plantName;
    }
    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }
    public String getPlantTemperature() {
        return plantTemperature;
    }
    public void setPlantTemperature(String plantTemperature) {
        this.plantTemperature = plantTemperature;
    }
    public double getPlantPrice() {
        return plantPrice;
    }
    public void setPlantPrice(double plantPrice) {
        this.plantPrice = plantPrice;
    }
    public String getPotColor() {
        return potColor;
    }
    public void setPotColor(String potColor) {
        this.potColor = potColor;
    }
    public int getPlantGuarantee() {
        return plantGuarantee;
    }
    public void setPlantGuarantee(int plantGuarantee) {
        this.plantGuarantee = plantGuarantee;
    }
    public String getPlantOffer() {
        return plantOffer;
    }
    public void setPlantOffer(String plantOffer) {
        this.plantOffer = plantOffer;
    }
    public Product(int productId, String plantName, String plantTemperature, double plantPrice, String potColor,
            int plantGuarantee, String plantOffer) {
        this.productId = productId;
        this.plantName = plantName;
        this.plantTemperature = plantTemperature;
        this.plantPrice = plantPrice;
        this.potColor = potColor;
        this.plantGuarantee = plantGuarantee;
        this.plantOffer = plantOffer;
    }
    public Product()
    {
        
    }
    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    @JoinColumn(name="fk_add_id")
    @JsonManagedReference
    Payment payment;//obj of secondary table
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
   
}