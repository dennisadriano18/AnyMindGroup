package com.classes.myecommerce.model;

public class AdditionalItem {
    private String last_4;
    private String bankName;
    private String acctNo;
    private String checkNo;
    private String courier;

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
}
