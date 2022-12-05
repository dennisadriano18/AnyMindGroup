package com.classes.myecommerce.validation;

import antlr.StringUtils;
import com.classes.myecommerce.Exception.*;
import com.classes.myecommerce.model.PaymentInfo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Validation {
    private PaymentInfo paymentInfo;

    public Validation(PaymentInfo paymentInfo){
        this.paymentInfo = paymentInfo;
        this.validateAdditionalItems();
        if(paymentInfo.getPriceModifier() == null){
            validatePriceModifier();
        }
    }

    public void validateAdditionalItems(){

        switch(paymentInfo.getPaymentMethod()){
            case "CASH_ON_DELIVERY":
                if((paymentInfo.getCourier()==null) || (!paymentInfo.getCourier().equals("YAMATO") && !paymentInfo.getCourier().equals("SAGAWA"))){
                    throw new InvalidCourierException("Courier can only be Yamato or Sagawa");
                }
                break;
            case "VISA":
            case "MASTERCARD":
            case "AMEX":
            case "JCB":
                if(paymentInfo.getLast_4()==null || paymentInfo.getLast_4().length()<4){
                    throw new InvalidLast4Exception("Invalid last 4 digit for credit card");
                }
                break;
            case "BANK TRANSFER":
                if(paymentInfo.getBankName()==null || paymentInfo.getBankName().length()==0){
                    throw new InvalidBankInformation("Invalid Bank Name");
                }
                if(paymentInfo.getAcctNo()==null || paymentInfo.getAcctNo().length()==0){
                    throw new InvalidBankInformation("Invalid Account Number");
                }
                break;
            case "CHEQUE":
                if(paymentInfo.getBankName()==null || paymentInfo.getBankName().length()==0){
                    throw new InvalidBankInformation("Invalid Bank Name");
                }
                if(paymentInfo.getCheckNo()==null || paymentInfo.getCheckNo().length()==0){
                    throw new InvalidBankInformation("Invalid Check Number");
                }
                break;
            default:
                break;
        }
    }

    public void validatePriceModifier(){
        BigDecimal min = roundToTwoDecimal(1.0);
        BigDecimal max = roundToTwoDecimal(1.0);
        switch(paymentInfo.getPaymentMethod()){
            case "CASH":
            case "CHEQUE":
                min = roundToTwoDecimal(0.9);
                break;
            case "CASH_ON_DELIVERY":
                max = roundToTwoDecimal(1.02);
                break;
            case "VISA":
            case "JCB":
            case "MASTERCARD":
                min = roundToTwoDecimal(0.95);
                break;
            case "AMEX":
                min = roundToTwoDecimal(0.98);
                max = roundToTwoDecimal(1.01);
                break;
            default:
                min = roundToTwoDecimal(1.0);
                break;
        }

        if(paymentInfo.getPriceModifier().compareTo(min) < 0){
            throw new InvalidPriceModifier("The price modifier in the request is less than the allowed: "+min);
        }else if (paymentInfo.getPriceModifier().compareTo(max) > 0){
            throw new InvalidPriceModifier("The price modifier in the request is greater than the allowed: "+max);
        }

    }

    private BigDecimal roundToTwoDecimal(double value){
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
    }
}
