package com.tss.isp.violation.model;

import java.util.Date;

public class Magazine implements LibraryItem{
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
    public void renewItem(String memberId) {
        System.out.println(memberId+" Renew Magazine "+title);
    }

    @Override
    public void reserveItem(String memberId) throws IllegalAccessException {
        throw new IllegalAccessException("Magazine can not be reserve");

    }

    @Override
    public double calculateFine(int daysOverdue) {
        return daysOverdue*5;
    }

    @Override
    public boolean isReferenceOnly() throws IllegalAccessException {
        throw new IllegalAccessException("Magazine can not be Reference");
    }
}
