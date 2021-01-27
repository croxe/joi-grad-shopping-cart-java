package com.thoughtworks.codepairing.model;

public class Product {
    private final double price; // Questionable
    private final String productCode; // Questionable
    private final String name; // Questionable

    public Product(double price, String productCode, String name) {
        this.price = price;
        this.productCode = productCode;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }
}
