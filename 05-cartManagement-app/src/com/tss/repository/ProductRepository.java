package com.tss.repository;

import com.tss.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static List<Product> products=new ArrayList<>();
    public Product addProduct(Product product)
    {
        products.add(product);
        return product;
    }
    public Product getProductById(long productId)
    {
        for (Product product:products)
        {
            if (product.getProductId()==productId)
                return product;
        }
        return null;
    }
    public boolean removeProductById(long productId)
    {
        Product product=getProductById(productId);
        if (product==null)
            return false;
        products.remove(product);
        return true;
    }
    public List<Product> getAllProduct()
    {
        return products;
    }
}
