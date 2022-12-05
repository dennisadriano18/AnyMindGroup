package com.classes.myecommerce.service;

import com.classes.myecommerce.model.PaymentInfo;
import org.aspectj.apache.bcel.classfile.Utility;

import java.math.BigDecimal;

public class UtilityService {

    private PaymentInfo paymentInfo;

    public UtilityService(PaymentInfo paymentInfo){
        this.paymentInfo = paymentInfo;
    }

    public BigDecimal computeFinalPrice(){
        return paymentInfo.getPriceModifier() == null? paymentInfo.getPrice() : paymentInfo.getPrice().multiply( paymentInfo.getPriceModifier());
    }

    public BigDecimal computePoints(){
        BigDecimal totalPoints = null;
        BigDecimal pointsModifier = null;
        switch(paymentInfo.getPaymentMethod()){
            case "CASH":
            case "JCB":
            case "CASH_ON_DELIVERY":
                pointsModifier = new BigDecimal(0.05);
                break;
            case "VISA":
            case "MASTERCARD":
                pointsModifier = new BigDecimal(0.03);
                break;
            case "AMEX":
                pointsModifier = new BigDecimal(0.02);
                break;
            case "LINE PAY":
            case "GRAB PAY":
            case "PAYPAY":
                pointsModifier = new BigDecimal(0.01);
                break;
            default:
                pointsModifier = new BigDecimal(0.0);
                break;
        }
        return totalPoints = paymentInfo.getPrice().multiply(pointsModifier);
    }
}
