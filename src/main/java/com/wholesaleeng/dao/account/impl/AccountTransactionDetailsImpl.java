package com.wholesaleeng.dao.account.impl;

import com.wholesaleeng.entity.TransactionEntity;
import com.wholesaleeng.exceptions.NoDataFoundException;
import com.wholesaleeng.model.AccountTransactionsRO;
import com.wholesaleeng.repo.TransactionDetailsRepo;
import com.wholesaleeng.util.AccountUtil;
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
    public List<AccountTransactionsRO> getAcctTrnDetailsForAccNbr(@NotNull String accountNumber) throws NoDataFoundException {
        List<TransactionEntity> transactionList = transactionRepo.getTransactionDetails(accountNumber);
        if(!CollectionUtils.isEmpty(transactionList))
        {
            List<AccountTransactionsRO> accountTransactions = new ArrayList<>();
            transactionList.forEach(transactionEntity ->
            {
                AccountTransactionsRO accountTransactionsRO = new AccountTransactionsRO(transactionEntity,
                        AccountUtil.formatDatedMMMddYYY(transactionEntity.getTransactionDt()),
                        AccountUtil.formatAccountNumber(transactionEntity.getAccountNumber()));
                accountTransactions.add(accountTransactionsRO);
            });
            return  accountTransactions;
        }
        else
        {
           throw new NoDataFoundException("TransactionDetails Data not found for Account Number " + accountNumber);
        }
    }

}
