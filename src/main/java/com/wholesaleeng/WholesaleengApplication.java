package com.wholesaleeng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
public class WholesaleengApplication {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(WholesaleengApplication.class, args);
    }

    @PostConstruct
    private void initDb() {
        String sqlStatements[] = {
                "insert into ACCOUNT_DETAILS(ACC_NBR, ACC_NAME, ACC_TYPE, BAL_DATE, CURRENCY, CURR_BAL, ACC_USER_NAME) values(123458, 'SGSaving8', 'Savings', '2018-11-11', 'AUD', '800', '1');\n" +
                        "insert into ACCOUNT_DETAILS(ACC_NBR, ACC_NAME, ACC_TYPE, BAL_DATE, CURRENCY, CURR_BAL, ACC_USER_NAME) values(123459, 'SGSaving811', 'Savings', '2018-11-11', 'AUD', '200', '1');\n" +
                        "insert into ACCOUNT_DETAILS(ACC_NBR, ACC_NAME, ACC_TYPE, BAL_DATE, CURRENCY, CURR_BAL, ACC_USER_NAME) values(123460, 'Current123', 'Current', '2018-12-11', 'AUD', '100', '2');\n" +
                        "insert into ACCOUNT_DETAILS(ACC_NBR, ACC_NAME, ACC_TYPE, BAL_DATE, CURRENCY, CURR_BAL, ACC_USER_NAME) values(123465, 'SGSaving118', 'Savings', '2017-11-11', 'AUD', '600',' 2');\n" +
                        "insert into ACCOUNT_DETAILS(ACC_NBR, ACC_NAME, ACC_TYPE, BAL_DATE, CURRENCY, CURR_BAL, ACC_USER_NAME) values(123468, 'Current667', 'Current', '2018-11-08', 'AUD', '20', '3');\n" +
                        "insert into ACCOUNT_DETAILS(ACC_NBR, ACC_NAME, ACC_TYPE, BAL_DATE, CURRENCY, CURR_BAL, ACC_USER_NAME) values(123469, 'Current116', 'Current', '2018-02-11', 'AUD', '5', '4');\n" +
                        "insert into ACCOUNT_DETAILS(ACC_NBR, ACC_NAME, ACC_TYPE, BAL_DATE, CURRENCY, CURR_BAL, ACC_USER_NAME) values(123470, 'SGSaving8', 'Savings', '2018-01-10', 'AUD', '800',' 4');\n" +
                        "insert into ACCOUNT_TRANSACTION  (TRANSACTION_ID , TRN_ACC_TYPE ,ACC_NBR ,TRN_CREDIT_AMT ,CURRENCY ,TRN_DEBIT_AMT ,TRN_COMMENTS ,TRN_DATE ,TRN_TYPE )\n" +
                        "values(1,'Current Account',123459, '1', 'AUD','12','food', '2018-11-11', 'Credit');\n" +
                        "insert into ACCOUNT_TRANSACTION  ( TRN_ACC_TYPE ,ACC_NBR ,TRN_CREDIT_AMT ,CURRENCY ,TRN_DEBIT_AMT ,TRN_DATE ,TRN_TYPE )\n" +
                        "values('Current Account',123459, '6', 'AUD','112', '2018-11-18', 'Credit');\n" +
                        "insert into ACCOUNT_TRANSACTION  ( TRN_ACC_TYPE ,ACC_NBR ,TRN_CREDIT_AMT ,CURRENCY ,TRN_DEBIT_AMT ,TRN_COMMENTS ,TRN_DATE ,TRN_TYPE )\n" +
                        "values('Current Account',123459, '6', 'AUD','112','food', '2018-11-18', 'Credit');\n" +
                        "insert into ACCOUNT_TRANSACTION  ( TRN_ACC_TYPE ,ACC_NBR ,TRN_CREDIT_AMT ,CURRENCY ,TRN_DEBIT_AMT ,TRN_COMMENTS ,TRN_DATE ,TRN_TYPE )\n" +
                        "values('Current Account',123459, '6', 'AUD','112','food', '2018-11-18', 'Credit');\n" +
                        "insert into ACCOUNT_TRANSACTION  ( TRN_ACC_TYPE ,ACC_NBR ,TRN_CREDIT_AMT ,CURRENCY ,TRN_DEBIT_AMT ,TRN_COMMENTS ,TRN_DATE ,TRN_TYPE )\n" +
                        "values('Current Account',123459, '6', 'AUD','112','food', '2018-11-18', 'Credit')"
        };

        Arrays.asList(sqlStatements).stream().forEach(sql -> {
            System.out.println(sql);
            jdbcTemplate.execute(sql);
        });
    }


}
