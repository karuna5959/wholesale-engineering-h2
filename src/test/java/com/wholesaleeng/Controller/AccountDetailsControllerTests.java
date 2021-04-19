package com.wholesaleeng.Controller;

import com.wholesaleeng.controller.AccountDetailsController;
import com.wholesaleeng.service.AccountDetailsImpl;
import com.wholesaleeng.exceptions.NoDataFoundException;
import com.wholesaleeng.model.AccountDetails;
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
public class AccountDetailsControllerTests {

    @Autowired
    private AccountDetailsController accountDetailsController;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AccountDetailsImpl accountDetailsImpl;

    @Test
    public void testGetAccountDetails() throws Exception {
      AccountDetails accountDetails = new AccountDetails();
      accountDetails.setAccountName("1234595543");

      List<AccountDetails> accountDetailsRo = new ArrayList<>();
        accountDetailsRo.add(accountDetails);

        Mockito.when(accountDetailsImpl.getAccountDetailsForUser(Mockito.anyString())).thenReturn(accountDetailsRo);
        this.mvc.perform(get("/accountDetails?userName=1")).andDo(print()).andExpect(content().string(containsString("1234595543")));
    }

    @Test(expected = Exception.class)
    public void testInvalidInput() throws Exception {
        this.mvc.perform(get("/accountDetails?userName="));
    }

    @Test(expected = Exception.class)
    public void testGetAccountDetailsException() throws Exception {
        Mockito.when(accountDetailsImpl.getAccountDetailsForUser(Mockito.anyString())).thenThrow(NoDataFoundException.class);
        this.mvc.perform(get("/accountDetails?userName=1")).andDo(print()).andExpect(content().string(containsString("1234595543")));
    }

}
