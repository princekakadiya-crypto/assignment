package com.tss.isp.violation.model;

public class Book implements LibraryItem{

    String isbn;
    String title;
    String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public void borrowItem(String memberId) {
        System.out.println(memberId+"Borrow Book "+title);
    }

    @Override
    public void returnItem(String memberId) {
        System.out.println(memberId+"return Book "+title);
    }

    @Override
    public void renewItem(String memberId) {
        System.out.println(memberId+"re new Book "+title);
    }

    public String getId()
    {
        return isbn;
    }

    @Override
    public void reserveItem(String memberId) throws IllegalAccessException {
        throw new IllegalAccessException("Book can not be reserve");
    }

    @Override
    public double calculateFine(int daysOverdue) {
        return daysOverdue*6;
    }

    @Override
    public boolean isReferenceOnly() throws IllegalAccessException {
        throw new IllegalAccessException("Book can not be Reference");
    }
}
