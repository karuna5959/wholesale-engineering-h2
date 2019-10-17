package com.wholesaleeng.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "AccountTransaction")
public class TransactionEntity implements Serializable {

    public TransactionEntity() {
    }

    public TransactionEntity(int transactionId, String accountNumber, String accountName, Date transactionDt, String currency, double debitAmt, double creditAmt, String transactionTyp, String transactionComments) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.transactionDt = transactionDt;
        this.currency = currency;
        this.debitAmt = debitAmt;
        this.creditAmt = creditAmt;
        this.transactionTyp = transactionTyp;
        this.transactionComments = transactionComments;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int transactionId;

    @Column(name="acc_nbr", nullable=false)
    private String accountNumber;

    @Column(name="trn_acc_type", nullable=false)
    private String accountName;

    @Column(name="trn_date", nullable=false)
    private Date transactionDt;

    @Column(name="currency", nullable=false)
    private String currency;

    @Column(name="trn_debit_amt")
    private  double debitAmt;

    @Column(name="trn_credit_amt")
    private double creditAmt;

    @Column(name="trn_type", nullable=false)
    private String transactionTyp;

    @Column(name="trn_comments")
    private String transactionComments;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
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

    public Date getTransactionDt() {
        return transactionDt;
    }

    public void setTransactionDt(Date transactionDt) {
        this.transactionDt = transactionDt;
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
