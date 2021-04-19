package com.wholesaleeng.service;

import com.wholesaleeng.entity.AccountEntity;
import com.wholesaleeng.exceptions.NoDataFoundException;
import com.wholesaleeng.model.AccountDetails;
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
        Mockito.when(accountDetailsRepo.findByUserID(Mockito.anyString())).thenReturn(accountEntities);
        List<AccountDetails> accountDetails = this.accountDetails.getAccountDetailsForUser("1");
        Assert.assertTrue(!accountDetails.isEmpty() &&  accountDetails.get(0).getAccountName().equals("1234595543"));
    }

    @Test(expected = NoDataFoundException.class)
    public void testAccountDetailsForNodata() throws NoDataFoundException {

        Mockito.when(accountDetailsRepo.findByUserID(Mockito.anyString())).thenReturn(new ArrayList<>());
        accountDetails.getAccountDetailsForUser("1");
    }

    private AccountEntity getAccountEntity() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountName("1234595543");
        accountEntity.setAccountNumber("1234595543");
        accountEntity.setAccountType("credit");
        accountEntity.setCurrency("AUD");

        return  accountEntity;
    }
}
