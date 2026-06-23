package com.tss.isp.solution.test;


import com.tss.isp.solution.model.Book;
import com.tss.isp.solution.model.Magazine;

public class LibraryTest {
    public static void main(String[] args) {
        Book libraryItem1 = new Book("123", "abc", "xyz");
        libraryItem1.borrowItem("1");
        libraryItem1.renewItem("2");
        System.out.println(libraryItem1.calculateFine(5));
        System.out.println(libraryItem1.isReferenceOnly());
        libraryItem1.returnItem("1");

        Magazine libraryItem2 = new Magazine("123", "abc", "21-05-2026");
        libraryItem2.borrowItem("1");
        libraryItem2.reserveItem("2");
        System.out.println(libraryItem2.calculateFine(5));
        System.out.println(libraryItem2.isReferenceOnly());
        libraryItem2.returnItem("1");

    }
}
