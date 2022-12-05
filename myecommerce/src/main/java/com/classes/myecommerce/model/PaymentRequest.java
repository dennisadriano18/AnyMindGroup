package com.classes.myecommerce.model;

import java.math.BigDecimal;

public class PaymentRequest {
    private String customerId;
    private String dateTime;
    private String paymentMethod;
    private BigDecimal price;
    private BigDecimal priceModifier;
    private AdditionalItem additionalItem;

    public PaymentRequest(){}

    public PaymentRequest(PaymentRequest paymentRequest){
        this.additionalItem = paymentRequest.additionalItem;
        this.customerId = paymentRequest.customerId;
        this.dateTime = paymentRequest.dateTime;
        this.paymentMethod = paymentRequest.paymentMethod;
        this.price = paymentRequest.price;
        this.priceModifier = paymentRequest.priceModifier;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceModifier() {
        return priceModifier;
    }

    public void setPriceModifier(BigDecimal priceModifier) {
        this.priceModifier = priceModifier;
    }

    public AdditionalItem getAdditionalItem() {
        return additionalItem;
    }

    public void setAdditionalItem(AdditionalItem additionalItem) {
        this.additionalItem = additionalItem;
    }
}
