package com.wholesaleeng.model;

import com.wholesaleeng.entity.AccountEntity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AccountDetailsRO implements Serializable {

        @NotNull
        private String accountNumber;

        @NotNull
        private String accountName;

        @NotNull
        private String accountType;

        @NotNull
        private String balanceDate;

        @NotNull
        private String currency;

        @NotNull
        private double opngAvlbBalance;

    public AccountDetailsRO() {
    }

    public AccountDetailsRO(AccountEntity accountEntity, String balanceDate) {

        this.accountNumber = accountEntity.getAccountNumber();
        this.accountName = accountEntity.getAccountName();
        this.accountType = accountEntity.getAccountType();
        this.balanceDate = balanceDate;
        this.currency = accountEntity.getCurrency();
        this.opngAvlbBalance = accountEntity.getOpngAvlbBalance();

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

        public String getAccountType() {
        return accountType;
    }

        public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

        public String getBalanceDate() {
        return balanceDate;
    }

        public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
    }

        public String getCurrency() {
        return currency;
    }

        public void setCurrency(String currency) {
        this.currency = currency;
    }

        public double getOpngAvlbBalance() {
        return opngAvlbBalance;
    }

        public void setOpngAvlbBalance(double opngAvlbBalance) {
        this.opngAvlbBalance = opngAvlbBalance;
    } }

