package com.tss.AccountManagement.service;

import com.tss.AccountManagement.Entity.Account;
import com.tss.Validation.InputValidation;

public class AccountService {
    Account[] accounts = new Account[10];
    static int index = 0;

    public void start() {
        int choice = 0;
        do {
            System.out.println("1 for Create Account");
            System.out.println("2 for Withdraw");
            System.out.println("3 for Deposit");
            System.out.println("4 for Check Balance");
            System.out.println("5 for Transfer");
            System.out.println("6 for Exit");

            choice = InputValidation.readInt("Enter your Choice");
            int attempt=0;
            switch (choice) {
                case 1:
                    accounts[index] = new Account();
                    createAccount(accounts[index]);
                    index++;
                    break;
                case 2:
                    do {
                        String accountNumber = String.valueOf(InputValidation.readInt("Enter Account Number : "));
                        int indexOfAccount = findIndexByAccount(accountNumber);
                        if (indexOfAccount == -1) {
                            attempt++;
                            if (attempt>2)
                                break;
                            System.out.println("Invalid Account Number. "+(3-attempt)+" attempt left");
                        } else {
                            int amount = InputValidation.readInt("Enter Amount : ", 1);
                            accounts[indexOfAccount].withdraw(amount);
                            System.out.println(amount+" Amount Withdraw.");
                            break;
                        }
                    } while (true);
                    break;
                case 3:
                    do {
                        String accountNumber = String.valueOf(InputValidation.readInt("Enter Account Number : "));
                        int indexOfAccount = findIndexByAccount(accountNumber);
                        if (indexOfAccount == -1) {
                            attempt++;
                            if (attempt>2)
                                break;
                            System.out.println("Invalid Account Number. "+(3-attempt)+" attempt left");
                        } else {
                            int amount = InputValidation.readInt("Enter Amount : ", 1);
                            accounts[indexOfAccount].deposit(amount);
                            System.out.println(amount+" Amount Deposit");
                            break;
                        }
                    } while (true);
                    break;
                case 4:
                    do {
                        String accountNumber = String.valueOf(InputValidation.readInt("Enter Account Number : "));
                        int indexOfAccount = findIndexByAccount(accountNumber);
                        if (indexOfAccount == -1) {
                            attempt++;
                            if (attempt>2)
                                break;
                            System.out.println("Invalid Account Number. "+(3-attempt)+" attempt left");
                        } else {
                            System.out.println("Balance : "+accounts[indexOfAccount].getBalance());
                            break;
                        }
                    } while (true);
                    break;
                case 5:
                    String fromAccountNumber;
                    String toAccountNumber;
                    int indexOfAccountFrom;
                    int indexOfAccountTo;
                    do {
                        fromAccountNumber = String.valueOf(InputValidation.readInt("Enter Account Number From Transfer : "));
                        indexOfAccountFrom = findIndexByAccount(fromAccountNumber);
                        if (indexOfAccountFrom == -1) {
                            attempt++;
                            if (attempt>2)
                                break;
                            System.out.println("Invalid Account Number. "+(3-attempt)+" attempt left");
                        }
                        else
                            break;
                    } while (true);
                    if (attempt>2)
                    {
                        System.out.println("Transfer Failed.");
                        break;
                    }
                    attempt=0;
                    do {
                        toAccountNumber = String.valueOf(InputValidation.readInt("Enter Account Number TO Transfer : "));
                        indexOfAccountTo = findIndexByAccount(toAccountNumber);
                        if (indexOfAccountTo == -1) {
                            attempt++;
                            if (attempt>2)
                                break;
                            System.out.println("Invalid Account Number. "+(3-attempt)+" attempt left");
                        }
                        else
                            break;
                    }while (true);
                    if (attempt>2) {
                        System.out.println("Transfer Failed.");
                        break;
                    }

                    int amount = InputValidation.readInt("Enter Amount : ", 1);
                    boolean flag=accounts[indexOfAccountFrom].withdraw(amount);
                    if (!flag) {
                        System.out.println("Transfer Failed.");
                        break;
                    }
                    accounts[indexOfAccountTo].deposit(amount);
                    System.out.println("Transfer of Amount "+amount+" complete from "+fromAccountNumber+" to "+toAccountNumber);
                    break;
                case 6:
                    System.out.println("Exited...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);
    }

    private int findIndexByAccount(String accountNumber) {
        for (int i=0;i<index;i++)
        {
            if (accountNumber.equals(accounts[i].getAccountNumber()))
                return i;
        }
        return -1;
    }

    private void createAccount(Account account) {
        account.setName(InputValidation.readName("Enter Name : " ));
        account.setBalance(InputValidation.readInt("Enter Amount : ",500));
        while (true)
        {
            System.out.println("1 for Saving Account ");
            System.out.println("2 for Current Account");
            try
            {
                int accountType= InputValidation.readInt("Enter Account Type (1/2) : ");
                if (accountType==1)
                {
                    account.setAccountType("Saving Account");
                    break;
                } else if (accountType==2) {
                    account.setAccountType("Current Account");
                    break;
                }
                System.out.println("Invalid choice");
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        System.out.println("Account Created.. Account Number is "+account.getAccountNumber());
    }
}
