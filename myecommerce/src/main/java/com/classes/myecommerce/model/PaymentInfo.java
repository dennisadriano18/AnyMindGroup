package com.classes.myecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String customerId;
    private String dateTime;
    private String paymentMethod;
    private Integer price;
    private Integer priceModifier;

    public PaymentInfo(){}

    public PaymentInfo(Long id){
        this.id = id;
    }

    public PaymentInfo(String customerId, Integer price, Integer priceModifier, String dateTime, String paymentMethod){
        this.customerId = customerId;
        this.price = price;
        this.priceModifier = priceModifier;
        this.dateTime = dateTime;
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPriceModifier() {
        return priceModifier;
    }

    public void setPriceModifier(Integer priceModifier) {
        this.priceModifier = priceModifier;
    }
}
