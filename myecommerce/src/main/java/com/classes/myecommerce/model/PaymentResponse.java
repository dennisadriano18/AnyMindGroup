package com.classes.myecommerce.model;

import java.math.BigDecimal;

public class PaymentResponse {
    private BigDecimal finalPrice;
    private BigDecimal points;

    public PaymentResponse(){}

    public PaymentResponse(BigDecimal finalPrice, BigDecimal points){
        this.finalPrice = finalPrice;
        this.points = points;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }

    private void validateFinalPrice(){

    }
}
