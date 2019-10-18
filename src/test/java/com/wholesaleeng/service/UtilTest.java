package com.wholesaleeng.service;

import com.wholesaleeng.util.AccountUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilTest {

    @Test
    public void testFormatAccountNumbetTest()
    {
       String accountNumber = AccountUtil.formatAccountNumber("1234595543");
       System.out.println(accountNumber);
        Assert.assertTrue(accountNumber.equals("123-4595-543"));
    }

    @Test
    public void testFormatAccountNumbetTest1()
    {
        String accountNumber = AccountUtil.formatAccountNumber("1234595");
        Assert.assertTrue(accountNumber.equals("1234595"));
    }

    @Test
    public void testFormatDateMMYY(){
        String date = AccountUtil.formatDateddMMYYY(new Date());
         Assert.assertTrue(StringUtils.isNotBlank(date));
    }

    @Test
    public void testFormatDateMMYYEmpty(){
        String date = AccountUtil.formatDateddMMYYY(null);
        Assert.assertTrue(StringUtils.isBlank(date));
    }
    @Test
    public void testFormatDateMMMdd(){
        String date = AccountUtil.formatDatedMMMddYYY(new Date());
        Assert.assertTrue(StringUtils.isNotBlank(date));
    }



}
