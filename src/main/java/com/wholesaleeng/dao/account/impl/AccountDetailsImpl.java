package com.wholesaleeng.dao.account.impl;

import com.wholesaleeng.entity.AccountEntity;
import com.wholesaleeng.exceptions.NoDataFoundException;
import com.wholesaleeng.model.AccountDetailsRO;
import com.wholesaleeng.repo.AccountDetailsRepo;
import com.wholesaleeng.util.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service(value="AccountDetailsImpl")
public class AccountDetailsImpl {

    @Autowired
    AccountDetailsRepo accountDetailsRepo;

    public List<AccountDetailsRO> getAccountDetailsForUser(@NotNull String userName) throws NoDataFoundException {
        List<AccountEntity> accountEntities =  accountDetailsRepo.getAccountDetailsForUser(userName);
        if(!CollectionUtils.isEmpty(accountEntities))
        {
            List<AccountDetailsRO> accountDetails = new ArrayList<>();
            accountEntities.forEach( accountEntity ->
            {
                AccountDetailsRO accountDetail = new AccountDetailsRO(accountEntity, AccountUtil.formatDateddMMYYY(accountEntity.getBalanceDate()));
                accountDetails.add(accountDetail);
            });
            return  accountDetails;

        }else {
            throw new NoDataFoundException("Account Data not found for User " + userName);

        }
    }

}
