package com.tss.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order {
    private static long orderCount=1;
    private long orderId;
    private String dateTime;
    private List<LineItem> lineItems;

    public Order(List<LineItem> lineItems) {
        this.lineItems=lineItems;
        this.orderId=orderCount++;
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public static long getOrderCount() {
        return orderCount;
    }

    public long getOrderId() {
        return orderId;
    }

    public String getDate() {
        return dateTime;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
    public double totalAmount()
    {
        double total=0;
        for (LineItem lineItem:lineItems)
        {
            total+=lineItem.getQuantity()*lineItem.getProductPriceAfterDiscount();
        }
        return total;
    }
}
