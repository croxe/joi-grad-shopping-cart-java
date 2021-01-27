package com.thoughtworks.codepairing.model;

public class Checkout implements Coupon, LoyaltyPoints{
    private final ShoppingCart shoppingCart;

    public Checkout(ShoppingCart shoppingCart){
        this.shoppingCart = shoppingCart;
    }

    public Order checkout() {
        double totalPrice = 0;
        int loyaltyPointsEarned = 0;

        for (Product product : shoppingCart.getAllProducts()) {
            loyaltyPointsEarned += getLoyaltyPoints(product);
            totalPrice += product.getPrice() - getDiscount(product);
        }

        return new Order(totalPrice, loyaltyPointsEarned);
    }

    @Override
    public double getDiscount(Product product) {
        double discount = 0;
        if (product.getProductCode().startsWith("DIS_10")) {
            discount = (product.getPrice() * 0.1);
        } else if (product.getProductCode().startsWith("DIS_15")) {
            discount = (product.getPrice() * 0.15);
        }
        return discount;
    }

    @Override
    public int getLoyaltyPoints(Product product) {
        int loyaltyPointsEarned = 0;
        if (product.getProductCode().startsWith("DIS_10")) {
            loyaltyPointsEarned += (product.getPrice() / 10);
        } else if (product.getProductCode().startsWith("DIS_15")) {
            loyaltyPointsEarned += (product.getPrice() / 15);
        } else {
            loyaltyPointsEarned += (product.getPrice() / 5);
        }
        return loyaltyPointsEarned;
    }
}
