package com.tss.isp.violation.model;

public interface LibraryItem {
    void borrowItem(String memberId);
    void returnItem(String memberId);
    void renewItem(String memberId);
    void reserveItem(String memberId) throws IllegalAccessException;
    double calculateFine(int daysOverdue);
    boolean isReferenceOnly() throws IllegalAccessException;
}
