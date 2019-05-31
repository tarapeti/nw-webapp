package com.codecool.web.model;

public class Task2 {

    private String companyName;
    private int products;

    public Task2(String companyName, int products) {
        this.companyName = companyName;
        this.products = products;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }
}
