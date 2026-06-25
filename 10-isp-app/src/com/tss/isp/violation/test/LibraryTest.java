package com.tss.isp.violation.test;

import com.tss.isp.violation.Repository.LibraryRepository;
import com.tss.isp.violation.model.Book;
import com.tss.isp.violation.model.LibraryItem;
import com.tss.isp.violation.model.Magazine;

public class LibraryTest {

    public static void main(String[] args) throws IllegalAccessException {

        LibraryRepository libraryRepository=new LibraryRepository();

        LibraryItem libraryItem1 = new Book("123", "abc", "xyz");
        LibraryItem libraryItem2 = new Magazine("245", "pqr", "21-05-2026");
        libraryRepository.addItem(libraryItem1);
        libraryRepository.addItem(libraryItem2);

        LibraryItem book1=libraryRepository.getItem("123");
        book1.borrowItem("1");
        book1.returnItem("1");

        LibraryItem magazine=libraryRepository.getItem("245");
        magazine.returnItem("2");
        magazine.renewItem("3");
    }
}
