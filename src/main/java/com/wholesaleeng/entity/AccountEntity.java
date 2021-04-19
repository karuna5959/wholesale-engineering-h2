package com.wholesaleeng.entity;


import com.wholesaleeng.util.AccountUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "AccountDetails")
public class AccountEntity implements Serializable {
    public AccountEntity() {
    }

    public AccountEntity(String accountNumber, String accountName, String accountType, Date balanceDate, String currency, double opngAvlbBalance, String userID) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balanceDate = balanceDate;
        this.currency = currency;
        this.opngAvlbBalance = opngAvlbBalance;
        this.userID = userID;
    }

    @Id
    @Column(name = "acc_nbr", nullable = false)
    @Size(min = 10, max = 10)
    private String accountNumber;

    @Column(name = "acc_name", nullable = false)
    private String accountName;

    @Column(name = "acc_type", nullable = false)
    private String accountType;

    @Column(name = "bal_date", nullable = false)
    private Date balanceDate;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "curr_bal", nullable = false)
    private double opngAvlbBalance;

    @Column(name = "acc_user_name", nullable = false)
    private String userID;

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
        return AccountUtil.formatDateddMMYYY(balanceDate);
    }

    public void setBalanceDate(Date balanceDate) {
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
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }


}
