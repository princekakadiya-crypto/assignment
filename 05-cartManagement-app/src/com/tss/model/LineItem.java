package com.tss.model;

import java.util.List;

public class LineItem {
    private static long lineItemCount=1;
    private long lineItemID;
    private int quantity;
    private Product product;

    public LineItem(int quantity, Product product) {
        this.lineItemID=lineItemCount++;
        this.quantity = quantity;
        this.product = product;
    }

    public static long getLineItemCount() {
        return lineItemCount;
    }

    public long getLineItemID() {
        return lineItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProducts() {
        return product;
    }

    public void addQuantity(int quantity)
    {
        this.quantity+=quantity;
    }
    public long getProductId()
    {
        return product.getProductId();
    }
    public String getProductName()
    {
        return product.getName();
    }
    public double getProductPrice()
    {
        return product.getPrice();
    }
    public double getProductPriceAfterDiscount()
    {
        return product.getPrice()-product.calculateDiscountPrice();
    }
    public double getDiscountPrice()
    {
        return product.calculateDiscountPrice();
    }
    public double getTotalPrice()
    {
        return product.calculateDiscountPrice()*quantity;
    }
    public int getProductQuantity()
    {
        return product.getQuantity();
    }
    public void decreaseQuantity(int quantity)
    {
        product.decreaseQuantity(quantity);
    }
}
