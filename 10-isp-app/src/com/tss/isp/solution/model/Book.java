package com.tss.isp.solution.model;

public class Book implements Borrowable,Renewable,FineCalculable,ReferenceOnly{
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
        System.out.println(memberId+" Borrow Book "+title);
    }

    @Override
    public void returnItem(String memberId) {
        System.out.println(memberId+" return Book "+title);
    }

    @Override
    public double calculateFine(int daysOverdue) {
        return daysOverdue*5;
    }

    @Override
    public boolean isReferenceOnly() {
        return true;
    }

    @Override
    public void renewItem(String memberId) {
        System.out.println(memberId+" re new Book "+title);
    }
}
