package com.tss.services;

import com.tss.Validation.InputValidation;
import com.tss.model.Product;
import com.tss.repository.ProductRepository;

import java.util.List;

public class ProductService {
    ProductRepository productRepository=new ProductRepository();
    public void addProduct()
    {
        String name= InputValidation.readString("Enter product name : ",2,50,"length of the product must be 2 to 50");
        double price=InputValidation.readDouble("Enter price : ",0,"price of the should not be negative");
        double discountPercent=InputValidation.readDouble("Enter Discount Percent : ",0,"negative value not allowed",100,"value should not be greater then 100");
        int quantity=InputValidation.readInt("Enter Quantity : ");
        Product product=productRepository.addProduct(new Product(name,price,discountPercent,quantity));
        System.out.println("Product added with product ID : "+product.getProductId());
    }

    public void displayProduct()
    {
        long id=InputValidation.readLong("Enter product Id : ");
        Product product=productRepository.getProductById(id);
        if (product==null)
        {
            System.out.println("Product Not found check your id");
            return;
        }
        System.out.println(product);
    }

    public void removeProduct()
    {
        long id=InputValidation.readLong("Enter product Id : ");
        boolean flag=productRepository.removeProductById(id);
        if (flag)
            System.out.println("Product Removed");
        else
            System.out.println("Product Not found check your id");
    }

    public void displayAllProducts()
    {
        List<Product> products=productRepository.getAllProduct();
        if (products.isEmpty())
        {
            System.out.println("No Product");
            return;
        }
        System.out.printf("%10s %15s %10s %15s %10s%n","Id","Name","Price","Discount Percent","Quantity");
        for (Product product:products)
            System.out.printf("%10d %15s %10.2f %15.2f %10d%n",product.getProductId(),product.getName(),product.getPrice(),product.getDiscountPercent(),product.getQuantity());
    }
    public void updateQuantity()
    {
        long id=InputValidation.readLong("Enter Product Id : ");
        Product product=productRepository.getProductById(id);
        if (product==null)
        {
            System.out.println("Product not found Check product Id");
            return;
        }
        int quantity=InputValidation.readInt("Enter Quantity : ");
        product.updateQuantity(quantity);
        System.out.println("Quantity Updated...");

    }
}
