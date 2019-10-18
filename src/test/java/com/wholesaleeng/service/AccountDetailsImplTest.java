package com.wholesaleeng.service;

import com.wholesaleeng.dao.account.impl.AccountDetailsImpl;
import com.wholesaleeng.entity.AccountEntity;
import com.wholesaleeng.exceptions.NoDataFoundException;
import com.wholesaleeng.model.AccountDetailsRO;
import com.wholesaleeng.repo.AccountDetailsRepo;
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
public class AccountDetailsImplTest {
    @Autowired
    AccountDetailsImpl accountDetails;

    @MockBean
    AccountDetailsRepo accountDetailsRepo;

    @Test
    public void testAccountDetailsForUser() throws NoDataFoundException {
        AccountEntity entity = getAccountEntity();
        List<AccountEntity> accountEntities = new ArrayList<>();
        accountEntities.add(entity);
        Mockito.when(accountDetailsRepo.getAccountDetailsForUser(Mockito.anyString())).thenReturn(accountEntities);
        List<AccountDetailsRO> accountDetailsROS = accountDetails.getAccountDetailsForUser("1");
        Assert.assertTrue(!accountDetailsROS.isEmpty() &&  accountDetailsROS.get(0).getAccountName().equals("1234595543"));
    }

    @Test(expected = NoDataFoundException.class)
    public void testAccountDetailsForNodata() throws NoDataFoundException {

        Mockito.when(accountDetailsRepo.getAccountDetailsForUser(Mockito.anyString())).thenReturn(new ArrayList<>());
        List<AccountDetailsRO> accountDetailsROS = accountDetails.getAccountDetailsForUser("1");
    }

    private AccountEntity getAccountEntity() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountName("1234595543");
        accountEntity.setAccountNumber("1234595543");
        accountEntity.setAccountType("credit");
        //accountEntity.setBalanceDate();
        accountEntity.setCurrency("AUD");

        return  accountEntity;
    }
}
