package com.wholesaleeng.controller;

import com.wholesaleeng.dao.account.impl.AccountDetailsImpl;
import com.wholesaleeng.entity.AccountEntity;
import com.wholesaleeng.exceptions.InvalidInputException;
import com.wholesaleeng.exceptions.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountDetailsController {

    @Autowired
    private AccountDetailsImpl accountDetailsImpl;

    @RequestMapping(value ="/accountDetails" , method= RequestMethod.GET)
    public List<AccountEntity> getAccountDetails(@RequestParam("userName") String userName ) throws InvalidInputException, NoDataFoundException {
        if(!StringUtils.isEmpty(userName))
        {
            return accountDetailsImpl.getAccountDetailsForUser(userName);
        }
        else
        {
            throw new InvalidInputException("Input is not valid");

        }

    }
}
