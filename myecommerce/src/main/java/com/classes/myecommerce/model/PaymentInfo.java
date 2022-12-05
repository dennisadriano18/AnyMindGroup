package com.classes.myecommerce.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class PaymentInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String customerId;
    private java.time.LocalDateTime dateTime;
    private String paymentMethod;
    private BigDecimal price;
    private BigDecimal priceModifier;

    private BigDecimal points;
    private String last_4;
    private String bankName;
    private String acctNo;
    private String checkNo;
    private String courier;

    public PaymentInfo(){}

    public PaymentInfo(Long id){
        this.id = id;
    }

    public PaymentInfo(PaymentRequest paymentRequest) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(paymentRequest.getDateTime(), formatter);
        this.customerId = paymentRequest.getCustomerId();
        this.price = paymentRequest.getPrice();
        this.priceModifier = paymentRequest.getPriceModifier();
        this.dateTime = dateTime;
        this.paymentMethod = paymentRequest.getPaymentMethod();
        if(paymentRequest.getAdditionalItem()==null){
            this.courier = "default";
        }else{
            this.last_4 = paymentRequest.getAdditionalItem().getLast_4();
            this.bankName = paymentRequest.getAdditionalItem().getBankName();
            this.acctNo = paymentRequest.getAdditionalItem().getAcctNo();
            this.checkNo = paymentRequest.getAdditionalItem().getCheckNo();
            this.courier = paymentRequest.getAdditionalItem().getCourier() == null ? "default" : paymentRequest.getAdditionalItem().getCourier();
        }

    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public java.time.LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(java.time.LocalDateTime dateTime) {
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

    public String getLast_4() {
        return last_4;
    }

    public void setLast_4(String last_4) {
        this.last_4 = last_4;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }
}
