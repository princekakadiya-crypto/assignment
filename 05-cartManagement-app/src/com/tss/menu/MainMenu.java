package com.tss.menu;

import com.tss.Validation.InputValidation;

public class MainMenu {
    AdminMenu adminMenu=new AdminMenu();
    CustomerMenu customerMenu=new CustomerMenu();
    public void start()
    {
        int choice;
        do {
            System.out.println("\n1 Admin menu");
            System.out.println("2 Customer menu");
            System.out.println("3 Exit");
            choice= InputValidation.readInt("Enter your choice : ");
            switch (choice)
            {
                case 1:
                    adminMenu.adminMenu();
                    break;
                case 2:
                    customerMenu.customerAouth();
                    break;
                case 3:
                    System.out.println("Exited..");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while (choice!=3);
    }
}
