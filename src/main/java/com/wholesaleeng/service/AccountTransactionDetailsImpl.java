package com.wholesaleeng.service;

import com.wholesaleeng.entity.TransactionEntity;
import com.wholesaleeng.exceptions.NoDataFoundException;
import com.wholesaleeng.model.AccountTransactions;
import com.wholesaleeng.repo.TransactionDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountTransactionDetailsImpl {

    @Autowired
    TransactionDetailsRepo transactionRepo;

    @Transactional
    public List<AccountTransactions> getAcctTrnDetailsForAccNbr(@NotNull String accountNumber) throws NoDataFoundException {
        List<TransactionEntity> transactionList = transactionRepo.findByAccountNumber(accountNumber);
        if (!CollectionUtils.isEmpty(transactionList)) {
            List<AccountTransactions> accountTransactions = new ArrayList<>();
            transactionList.forEach(transactionEntity ->
            {
                AccountTransactions accountTransactionsRO = new AccountTransactions(transactionEntity);
                accountTransactions.add(accountTransactionsRO);
            });
            return accountTransactions;
        } else {
            throw new NoDataFoundException("TransactionDetails Data not found for Account Number " + accountNumber);
        }
    }

}
