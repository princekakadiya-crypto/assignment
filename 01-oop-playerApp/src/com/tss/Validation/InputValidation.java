package com.tss.Validation;

import java.util.Scanner;

public class InputValidation {
    static Scanner scanner=new Scanner(System.in);
    public static int readInt(String message)
    {
        int number;
        while (true){
            System.out.println(message);
            try {
                number= scanner.nextInt();
                return number;
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
    }

    public static int readInt(String message,int min)
    {
        int number;
        while (true){
            System.out.println(message);
            try {
                number= scanner.nextInt();
                if(number<min)
                {
                    System.out.println("Minimum "+min+" value required");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
    }

    public static String readName(String message) {
        String name;
        scanner.nextLine();
        while (true) {
            System.out.print(message);
            name = scanner.nextLine().trim();

            if (name.matches("[a-zA-Z ]+")) {
                return name;
            }

            System.out.println("Invalid Input. Please enter letters only.");
        }
    }
}
