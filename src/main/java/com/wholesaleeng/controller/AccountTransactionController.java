package com.wholesaleeng.controller;

import com.wholesaleeng.exceptions.InvalidInputException;
import com.wholesaleeng.exceptions.NoDataFoundException;
import com.wholesaleeng.model.AccountTransactions;
import com.wholesaleeng.service.AccountTransactionDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountTransactionController {

    @Autowired
    private AccountTransactionDetailsImpl transactionService;

    @RequestMapping("/transactionDetails")
    public List<AccountTransactions> getTransactionDetails(@RequestParam("accountNumber") String accountID) throws NoDataFoundException, InvalidInputException {
        if (!StringUtils.isEmpty(accountID)) {
            return transactionService.getAcctTrnDetailsForAccNbr(accountID);
        } else {
            throw new InvalidInputException("Input is not valid");

        }
    }
}
