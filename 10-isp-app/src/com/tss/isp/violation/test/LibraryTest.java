package com.tss.isp.violation.test;

import com.tss.isp.violation.model.Book;
import com.tss.isp.violation.model.LibraryItem;
import com.tss.isp.violation.model.Magazine;

public class LibraryTest {

    public static void main(String[] args) throws IllegalAccessException {

        LibraryItem libraryItem1 = new Book("123", "abc", "xyz");
        libraryItem1.borrowItem("1");
        libraryItem1.renewItem("2");
        libraryItem1.calculateFine(5);
        try {
            libraryItem1.reserveItem("4");
        }catch (IllegalAccessException e)
        {
            System.out.println(e.getMessage());
        }
        try {
            libraryItem1.isReferenceOnly();
        }catch (IllegalAccessException e)
        {
            System.out.println(e.getMessage());
        }


        LibraryItem libraryItem2 = new Magazine("245", "pqr", "21-05-2026");
        libraryItem2.borrowItem("1");
        libraryItem2.renewItem("2");
        libraryItem2.calculateFine(5);
        try {
            libraryItem2.reserveItem("4");
        }catch (IllegalAccessException e)
        {
            System.out.println(e.getMessage());
        }
        try {
            libraryItem2.isReferenceOnly();
        }catch (IllegalAccessException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
