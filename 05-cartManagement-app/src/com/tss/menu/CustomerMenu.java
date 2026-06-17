package com.tss.menu;

import com.tss.Validation.InputValidation;
import com.tss.model.Customer;
import com.tss.repository.OrderRepository;
import com.tss.services.CustomerService;
import com.tss.services.LineItemService;
import com.tss.services.OrderService;
import com.tss.services.ProductService;

public class CustomerMenu {
    CustomerService customerService=new CustomerService();
    ProductService productService=new ProductService();
    LineItemService lineItemService=new LineItemService();
    OrderService orderService=new OrderService();
    OrderRepository orderRepository=new OrderRepository();
    public void customerAouth()
    {
        int choice;
        do {
            System.out.println("\n1 Already have account");
            System.out.println("2 Create account");
            System.out.println("3 Back");
            choice= InputValidation.readInt("Enter choice : ");
            switch (choice)
            {
                case 1:
                    Customer customer= customerService.login();
                    if(customer!=null)
                    {
                        orderRepository.setOrders(customer);
                        customerMenu();
                    }
                    break;
                case 2:
                    customerService.addCustomer();
                    break;
                case 3:
                    System.out.println("Backed to main menu");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while (choice!=3);
    }
    public void customerMenu()
    {
        int choice;
        do {
            System.out.println("\n1 View product");
            System.out.println("2 Add product to cart");
            System.out.println("3 View cart");
            System.out.println("4 Remove from cart");
            System.out.println("5 place order");
            System.out.println("6 View order History");
            System.out.println("7 Back");
            choice=InputValidation.readInt("Enter Choice : ");
            switch (choice)
            {
                case 1:
                    productService.displayAllProducts();
                    break;
                case 2:
                    lineItemService.addToCard();
                    break;
                case 3:
                    lineItemService.displayAll();
                    break;
                case 4:
                    lineItemService.removeFromCart();
                    break;
                case 5:
                    orderService.placeOrder();
                    break;
                case 6:
                    orderService.ViewOrderHistory();
                    break;
                case 7:
                    System.out.println("Backed..");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }while (choice!=7);
    }
}
