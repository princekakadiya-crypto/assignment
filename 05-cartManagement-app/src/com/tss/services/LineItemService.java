package com.tss.services;

import com.tss.Validation.InputValidation;
import com.tss.model.LineItem;
import com.tss.model.Product;
import com.tss.repository.LineItemRepository;
import com.tss.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class LineItemService {
    LineItemRepository lineItemRepository=new LineItemRepository();
    ProductRepository productRepository=new ProductRepository();
    public void addToCard()
    {
        long productId= InputValidation.readLong("Enter Product Id : ");
        Product product=productRepository.getProductById(productId);
        if (product==null)
        {
            System.out.println("Invalid product id check product id.");
            return;
        }
        int quantity=InputValidation.readInt("Enter Quantity : ",1);
        if (product.getQuantity()-quantity<0)
        {
            System.out.println("This much quantity is not in stock");
            return;
        }
        LineItem lineItem= lineItemRepository.addLineItem(new LineItem(quantity,product));
        if (lineItem==null)
            System.out.println("Quantity Added to cart");
        else
            System.out.println("Item Added to cart");
    }
    public void displayAll()
    {
        List<LineItem> lineItems=lineItemRepository.getAllLineItem();
        if (lineItems.isEmpty())
        {
            System.out.println("No items in cart");
            return;
        }
        System.out.printf("%15s %15s %15s %10s %15s %10s %15s%n","line item Id","Product Id","Product Name","Price","Discount price","Quantity","Total price");
        for (LineItem lineItem:lineItems)
        {
            System.out.printf("%15d %15d %15s %10.2f %15.2f %10d %15.2f%n",lineItem.getLineItemID(),lineItem.getProductId(),lineItem.getProductName(),lineItem.getProductPrice(),lineItem.getDiscountPrice(),lineItem.getQuantity(),lineItem.getTotalPrice());
        }
    }
    public void removeFromCart()
    {
        long productId= InputValidation.readLong("Enter Product Id : ");
        boolean flag=lineItemRepository.removeLineItem(productId);
        if (flag)
        {
            System.out.println("Item Removed from the cart");
            return;
        }
        System.out.println("product not found in your cart");
    }
}
