package com.tss.model;

public class Product {
    private static long productCount=1;
    private long productId;
    private String name;
    private double price;
    private double discountPercent;
    private int quantity;

    public Product(String name, double price, double discountPercent,int quantity) {
        this.productId=productCount++;
        this.name = name;
        this.price = price;
        this.discountPercent = discountPercent;
        this.quantity=quantity;
    }

    public static long getProductCount() {
        return productCount;
    }

    public long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public int getQuantity() {
        return quantity;
    }
    public void updateQuantity(int quantity)
    {
        this.quantity+=quantity;
    }

    public double calculateDiscountPrice()
    {
        return (price*discountPercent)/100;
    }

    @Override
    public String toString() {
        return  "\n productId : " + productId +
                "\n name : " + name +
                "\n price : " + price +
                "\n discount Percent : " + discountPercent +
                "\n Quantity : "+quantity
                ;
    }
    public void decreaseQuantity(int quantity)
    {
        this.quantity-=quantity;
    }
}
