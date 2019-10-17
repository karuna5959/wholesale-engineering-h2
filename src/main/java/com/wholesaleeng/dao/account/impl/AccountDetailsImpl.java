package com.wholesaleeng.dao.account.impl;

import com.wholesaleeng.entity.AccountEntity;
import com.wholesaleeng.exceptions.NoDataFoundException;
import com.wholesaleeng.repo.AccountDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service(value="AccountDetailsImpl")
public class AccountDetailsImpl {

    @Autowired
    AccountDetailsRepo accountDetailsRepo;

    public List<AccountEntity> getAccountDetailsForUser(@NotNull String userName) throws NoDataFoundException {
        List<AccountEntity> accountEntities =  accountDetailsRepo.getAccountDetailsForUser(userName);
        if(!CollectionUtils.isEmpty(accountEntities))
        {
            return  accountEntities;

        }else {
            throw new NoDataFoundException("Account Data not found for User " + userName);

        }
    }

}
