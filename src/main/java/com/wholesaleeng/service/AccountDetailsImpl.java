package com.wholesaleeng.service;

import com.wholesaleeng.entity.AccountEntity;
import com.wholesaleeng.exceptions.NoDataFoundException;
import com.wholesaleeng.model.AccountDetails;
import com.wholesaleeng.repo.AccountDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service(value = "AccountDetailsImpl")
public class AccountDetailsImpl {

    @Autowired
    AccountDetailsRepo accountDetailsRepo;

    public List<AccountDetails> getAccountDetailsForUser(@NotNull String userName) throws NoDataFoundException {
        List<AccountEntity> accountEntities = accountDetailsRepo.findByUserID(userName);
        if (!CollectionUtils.isEmpty(accountEntities)) {
            List<AccountDetails> accountDetails = new ArrayList<>();
            accountEntities.forEach(accountEntity ->
            {
                accountDetails.add(new AccountDetails(accountEntity));
            });

            return accountDetails;

        } else {
            throw new NoDataFoundException("Account Data not found for User " + userName);

        }
    }

}
