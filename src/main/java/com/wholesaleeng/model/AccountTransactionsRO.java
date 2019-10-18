package com.wholesaleeng.model;

import com.wholesaleeng.entity.TransactionEntity;

import java.io.Serializable;

public class AccountTransactionsRO implements Serializable {

    public AccountTransactionsRO() {
    }

    public AccountTransactionsRO(TransactionEntity transactionEntity, String transactionDate, String accountNumber) {
        this.transactionDate = transactionDate;
        this.accountNumber = accountNumber;
        this.accountName = transactionEntity.getAccountName();
        this.currency = transactionEntity.getCurrency();
        this.debitAmt = transactionEntity.getDebitAmt();
        this.creditAmt = transactionEntity.getCreditAmt();
        this.transactionTyp = transactionEntity.getTransactionTyp();
        this.transactionComments = transactionEntity.getTransactionComments();
    }


    private String accountNumber;

    private String accountName;

    private String transactionDate;

    private String currency;

    private  double debitAmt;

    private double creditAmt;

    private String transactionTyp;

    private String transactionComments;

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getDebitAmt() {
        return debitAmt;
    }

    public void setDebitAmt(double debitAmt) {
        this.debitAmt = debitAmt;
    }

    public double getCreditAmt() {
        return creditAmt;
    }

    public void setCreditAmt(double creditAmt) {
        this.creditAmt = creditAmt;
    }

    public String getTransactionTyp() {
        return transactionTyp;
    }

    public void setTransactionTyp(String transactionTyp) {
        this.transactionTyp = transactionTyp;
    }

    public String getTransactionComments() {
        return transactionComments;
    }

    public void setTransactionComments(String transactionComments) {
        this.transactionComments = transactionComments;
    }

}
