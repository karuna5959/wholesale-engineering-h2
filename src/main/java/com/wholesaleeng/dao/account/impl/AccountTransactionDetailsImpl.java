package com.wholesaleeng.dao.account.impl;

import com.wholesaleeng.entity.TransactionEntity;
import com.wholesaleeng.exceptions.NoDataFoundException;
import com.wholesaleeng.repo.TransactionDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class AccountTransactionDetailsImpl {

    @Autowired
    TransactionDetailsRepo transactionRepo;
    @Transactional
    public List<TransactionEntity> getAcctTrnDetailsForAccNbr(@NotNull String accountNumber) throws NoDataFoundException {
        List<TransactionEntity> transactionList = transactionRepo.getTrnDtlsForAccountNbr(accountNumber);
        if(!CollectionUtils.isEmpty(transactionList))
        {
            return  transactionList;
        }
        else
        {
           throw new NoDataFoundException("TransactionDetails Data not found for Account Number " + accountNumber);
        }
    }

}
