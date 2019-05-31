package com.codecool.web.model;

public class Task4 {
    private String companyName;
    private int orderId;

    public Task4(String companyName, int orderId) {
        this.companyName = companyName;
        this.orderId = orderId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
