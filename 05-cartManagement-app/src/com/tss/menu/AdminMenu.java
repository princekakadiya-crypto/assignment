package com.tss.menu;

import com.tss.Validation.InputValidation;
import com.tss.services.ProductService;

public class AdminMenu {

    public void adminMenu()
    {
        ProductService productService=new ProductService();
        int choice;
        do {
            System.out.println("\n1 View all products");
            System.out.println("2 Update product quantity");
            System.out.println("3 Add product");
            System.out.println("4 Remove product");
            System.out.println("5 search product");
            System.out.println("6 Back");
            choice= InputValidation.readInt("Enter choice : ");
            switch (choice)
            {
                case 1:
                    productService.displayAllProducts();
                    break;
                case 2:
                    productService.updateQuantity();
                    break;
                case 3:
                    productService.addProduct();
                    break;
                case 4:
                    productService.removeProduct();
                    break;
                case 5:
                    productService.displayProduct();
                    break;
                case 6:
                    System.out.println("Backed to main menu");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }while (choice!=6);
    }
}
