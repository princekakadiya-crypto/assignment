package com.tss.AccountManagement.test;

import com.tss.AccountManagement.service.AccountService;

public class AccountApp {
    public static void main(String[] args) {
        AccountService service = new AccountService();
        service.start();
    }

}
