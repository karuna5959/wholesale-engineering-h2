package com.wholesaleeng.service;

import com.wholesaleeng.dao.account.impl.AccountTransactionDetailsImpl;
import com.wholesaleeng.entity.TransactionEntity;
import com.wholesaleeng.exceptions.NoDataFoundException;
import com.wholesaleeng.model.AccountTransactionsRO;
import com.wholesaleeng.repo.TransactionDetailsRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTransactionDetailsImplTest {

    @Autowired
    private AccountTransactionDetailsImpl accountTransactionDetails;

    @MockBean
    private  TransactionDetailsRepo transactionRepo;

    @Test(expected =  NoDataFoundException.class)
    public void testAccountTrnDetailsNoData() throws NoDataFoundException {
        Mockito.when(transactionRepo.getTransactionDetails(Mockito.anyString())).thenReturn(new ArrayList<>());
        accountTransactionDetails.getAcctTrnDetailsForAccNbr("12345");
    }

    @Test
    public void testAccountTrnDetails() throws NoDataFoundException {
        List<TransactionEntity> transactionEntities = new ArrayList<>();
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccountName("abc");
        transactionEntity.setAccountNumber("1234595543");
        transactionEntities.add(transactionEntity);
        Mockito.when(transactionRepo.getTransactionDetails(Mockito.anyString())).thenReturn(transactionEntities);
       List<AccountTransactionsRO> accountTransactionsROS = accountTransactionDetails.getAcctTrnDetailsForAccNbr("1234595543");
        Assert.assertTrue(accountTransactionsROS.get(0).getAccountNumber().equals("123-4595-543"));
    }

    @Test(expected =  Exception.class)
    public void testAccountTrnDetailsNoException() throws NoDataFoundException {
        Mockito.when(transactionRepo.getTransactionDetails(Mockito.anyString())).thenThrow(NoDataFoundException.class);
        accountTransactionDetails.getAcctTrnDetailsForAccNbr("12345");
    }



}
