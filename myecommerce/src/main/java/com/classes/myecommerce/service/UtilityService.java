package com.classes.myecommerce.service;

import com.classes.myecommerce.model.PaymentInfo;
import org.aspectj.apache.bcel.classfile.Utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UtilityService {

    private PaymentInfo paymentInfo;

    public UtilityService(PaymentInfo paymentInfo){
        this.paymentInfo = paymentInfo;
    }

    public BigDecimal computeFinalPrice(){
        return paymentInfo.getPriceModifier() == null?
                paymentInfo.getPrice().setScale(2, RoundingMode.HALF_UP) :
                paymentInfo.getPrice().multiply( paymentInfo.getPriceModifier()).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal computePoints(){
        BigDecimal totalPoints = null;
        BigDecimal pointsModifier = null;
        switch(paymentInfo.getPaymentMethod()){
            case "CASH":
            case "JCB":
            case "CASH_ON_DELIVERY":
                pointsModifier = roundToTwoDecimal(0.05);
                break;
            case "VISA":
            case "MASTERCARD":
                pointsModifier = roundToTwoDecimal(0.03);
                break;
            case "AMEX":
                pointsModifier = roundToTwoDecimal(0.02);
                break;
            case "LINE PAY":
            case "GRAB PAY":
            case "PAYPAY":
                pointsModifier = roundToTwoDecimal(0.01);
                break;
            default:
                pointsModifier = roundToTwoDecimal(0.0);
                break;
        }
        return totalPoints = paymentInfo.getPrice().multiply(pointsModifier);
    }

    private BigDecimal roundToTwoDecimal(double value){
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
    }
}
