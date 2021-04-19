package com.wholesaleeng.Controller;

import com.wholesaleeng.controller.AccountTransactionController;
import com.wholesaleeng.service.AccountTransactionDetailsImpl;
import com.wholesaleeng.exceptions.NoDataFoundException;
import com.wholesaleeng.model.AccountTransactions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountTransactionControllerTest {


    @Autowired
    private AccountTransactionController accountTransactionController;

    @Autowired
    private MockMvc mvc;

    @MockBean
    AccountTransactionDetailsImpl accountTransactionDetails;

    @Test
    public void testGetAccountDetails() throws Exception {
        AccountTransactions accountTransactionsRO = new AccountTransactions();
        accountTransactionsRO.setAccountName("123-4595-543");

        List<AccountTransactions> accountTransactionsROS = new ArrayList<>();
        accountTransactionsROS.add(accountTransactionsRO);
        Mockito.when(accountTransactionDetails.getAcctTrnDetailsForAccNbr(Mockito.anyString())).thenReturn(accountTransactionsROS);
        this.mvc.perform(get("/transactionDetails?accountNumber=1234595543")).andDo(print()).andExpect(content().string(containsString("123-4595-543")));
    }

    @Test(expected = Exception.class)
    public void testInvalidInput() throws Exception {
        this.mvc.perform(get("/transactionDetails?accountNumber="));
    }

    @Test(expected = Exception.class)
    public void testNodataThrowException() throws Exception {
        Mockito.when(accountTransactionDetails.getAcctTrnDetailsForAccNbr(Mockito.anyString())).thenThrow(NoDataFoundException.class);
        this.mvc.perform(get("/transactionDetails?accountNumber=1"));
    }

}
