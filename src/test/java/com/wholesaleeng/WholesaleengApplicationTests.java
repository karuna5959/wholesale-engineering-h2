package com.wholesaleeng;

import static org.assertj.core.api.Assertions.assertThat;
import com.wholesaleeng.controller.AccountDetailsController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class WholesaleengApplicationTests {

    @Autowired
    private AccountDetailsController accountDetailsController;

    @Test
    void contextLoads() throws  Exception {
        assertThat(accountDetailsController).isNotNull();
    }

}
