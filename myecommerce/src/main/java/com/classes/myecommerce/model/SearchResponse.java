package com.classes.myecommerce.model;

public class SearchResponse {
    private String datetime;
    private String sales;
    private String points;

    public SearchResponse(String datetime, String sales, String points){
        this.datetime = datetime;
        this.sales = sales;
        this.points = points;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
