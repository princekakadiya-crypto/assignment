package com.tss.TransportManagement.Validation;

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
                scanner.nextLine();
                return number;
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
    }

    public static int readInt(String message,int min,String minMessage)
    {
        int number;
        while (true){
            System.out.println(message);
            try {
                number= scanner.nextInt();
                if(number<min)
                {
                    System.out.println(minMessage);
                    continue;
                }
                scanner.nextLine();
                return number;
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
    }

    public static int readInt(String message,int min,int max)
    {
        int number;
        while (true){
            System.out.println(message);
            try {
                number= scanner.nextInt();
                if(number<min)
                {
                    System.out.println("Input must be more then "+min);
                    continue;
                }
                else if (number>max)
                {
                    System.out.println("Input Must br lover then "+max);
                    continue;
                }
                scanner.nextLine();
                return number;
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
    }
    public static double readDouble(String message,double min)
    {
        double number;
        while (true){
            System.out.println(message);
            try {
                number= scanner.nextInt();
                if(number<min)
                {
                    System.out.println("Minimum "+min+" value required");
                    continue;
                }
                scanner.nextLine();
                return number;
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
    }

    public static double readDouble(String message)
    {
        double number;
        while (true){
            System.out.println(message);
            try {
                number= scanner.nextInt();
                scanner.nextLine();
                return number;
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
    }

    public static double readDouble(String message,double min,String messageForMin,double max,String messageForMax)
    {
        double number;
        while (true){
            System.out.println(message);
            try {
                number= scanner.nextInt();
                if(number<min)
                {
                    System.out.println(messageForMin);
                    continue;
                }
                if (number>max)
                {
                    System.out.println(messageForMax);
                    continue;
                }
                scanner.nextLine();
                return number;
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
    }

    public static String readName(String message) {
        String name;
        while (true) {
            System.out.print(message);
            name = scanner.nextLine().trim();

            if (name.matches("[a-zA-Z ]+")) {
                return name;
            }
            scanner.nextLine();
            System.out.println("Invalid Input. Please enter letters only.");
        }
    }
    public static String readString(String message,int minLength,int maxLength,String lengthmessage) {
        String name;
        while (true) {
            System.out.print(message);
            name = scanner.nextLine().trim();

            if (name.length()>=minLength && name.length()<=maxLength)
                return name;
            System.out.println(lengthmessage);
            scanner.nextLine();
        }
    }

    public static String readNumberWithLength(String message,int minLength,int maxLength,String lengthmessage) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim();

            if (input.matches("[0-9]+")) {
                if (input.length()>=minLength && input.length()<=maxLength)
                    return input;
                System.out.println(lengthmessage);
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            System.out.println("Invalid Input. Please enter Number only.");
        }
    }
}
