package com.tss.services;

import com.tss.model.Customer;
import com.tss.model.LineItem;
import com.tss.model.Order;
import com.tss.repository.LineItemRepository;
import com.tss.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    OrderRepository orderRepository=new OrderRepository();
    LineItemRepository lineItemRepository=new LineItemRepository();
    public void placeOrder()
    {
        List<LineItem> outOfStock= lineItemRepository.checkAllStockAvailable();
        if (!outOfStock.isEmpty())
        {
            System.out.println("Out of Stock in your order");
            System.out.printf("%15s %15s %15s %10s %15s %10s %15s%n","line item Id","Product Id","Product Name","Price","Discount price","Quantity","Total price");
            for (LineItem lineItem:outOfStock)
            {
                System.out.printf("%15d %15d %15s %10.2f %15.2f %10d %15.2f%n",lineItem.getLineItemID(),lineItem.getProductId(),lineItem.getProductName(),lineItem.getProductPrice(),lineItem.getDiscountPrice(),lineItem.getQuantity(),lineItem.getTotalPrice());
            }
            return;
        }

        orderRepository.addOrderInCustomer(new Order(lineItemRepository.getAllLineItem()));
        for (LineItem lineItem:lineItemRepository.getAllLineItem())
        {
            lineItem.decreaseQuantity(lineItem.getQuantity());
        }
        lineItemRepository.clear();
        System.out.println("Order placed successfully....");
    }
    public void ViewOrderHistory()
    {
        List<Order> orders=orderRepository.getOrders();
        if (orders.isEmpty())
        {
            System.out.println("No order History");
            return;
        }
        for (Order order:orders)
        {
            System.out.println();
            System.out.println("Order Id : "+order.getOrderId()+" Date : "+order.getDate());
            System.out.printf("%15s %15s %15s %10s %15s %10s %15s%n","line item Id","Product Id","Product Name","Price","Discount price","Quantity","Total price");
            for (LineItem lineItem:order.getLineItems())
            {
                System.out.printf("%15d %15d %15s %10.2f %15.2f %10d %15.2f%n",lineItem.getLineItemID(),lineItem.getProductId(),lineItem.getProductName(),lineItem.getProductPrice(),lineItem.getDiscountPrice(),lineItem.getQuantity(),lineItem.getTotalPrice());
            }
            System.out.printf("%80s %15.2f","Total Amount : ",order.totalAmount());
        }
    }
}
