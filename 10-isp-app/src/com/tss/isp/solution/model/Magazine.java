package com.tss.isp.solution.model;

public class Magazine implements Borrowable,Reservable,FineCalculable,ReferenceOnly{
    String issueNumber;
    String title;
    String publicationDate;

    public Magazine(String issueNumber, String title, String publicationDate) {
        this.issueNumber = issueNumber;
        this.title = title;
        this.publicationDate = publicationDate;
    }
    @Override
    public void borrowItem(String memberId) {
        System.out.println(memberId+" Borrow Magazine "+title);
    }

    @Override
    public void returnItem(String memberId) {
        System.out.println(memberId+" return Magazine "+title);
    }

    @Override
    public double calculateFine(int daysOverdue) {
        return 5*daysOverdue;
    }

    @Override
    public boolean isReferenceOnly() {
        return false;
    }

    @Override
    public void reserveItem(String memberId) {
        System.out.println(memberId+" Reserve Magazine "+title);
    }
}
