package com.classes.myecommerce.service;

import com.classes.myecommerce.model.AdditionalItem;
import com.classes.myecommerce.model.PaymentInfo;
import com.classes.myecommerce.model.PaymentRequest;
import graphql.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class UtilityServiceTest {

    @Test
    void computeFinalPrice() throws ParseException{
        UtilityService service = new UtilityService(createDummyPaymentInfo());
        Assert.assertTrue(service.computeFinalPrice().compareTo(new BigDecimal(95)) == 0);
    }

    @Test
    void computePoints() throws ParseException{
        UtilityService service = new UtilityService(createDummyPaymentInfo());
        Assert.assertTrue(service.computePoints().compareTo(new BigDecimal(3)) == 0);
    }

    private PaymentInfo createDummyPaymentInfo() throws ParseException {

        AdditionalItem additionalItem = new AdditionalItem();
        additionalItem.setAcctNo("123456789");
        additionalItem.setBankName("Bank of Test");
        additionalItem.setCourier("KuroNeko");
        additionalItem.setLast_4("1234");

        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setPaymentMethod("VISA");
        paymentRequest.setPrice(new BigDecimal(100.0));
        paymentRequest.setAdditionalItem(additionalItem);
        paymentRequest.setCustomerId("1234");
        paymentRequest.setPriceModifier(new BigDecimal(0.95));
        paymentRequest.setDateTime("2022-12-01 12:59:59");

        return new PaymentInfo(paymentRequest);
    }
}