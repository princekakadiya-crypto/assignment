package com.tss.isp.solution.model;

public interface Borrowable {
    void borrowItem(String memberId);
    void returnItem(String memberId);
}
