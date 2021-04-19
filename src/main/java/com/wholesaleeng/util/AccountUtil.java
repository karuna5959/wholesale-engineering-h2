package com.wholesaleeng.util;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountUtil {

    public static String formatDateddMMYYY(Date inputDate) {
        if (inputDate != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYY");
            return formatter.format(inputDate).toString();
        }
        return "";
    }

    public static String formatDatedMMMddYYY(Date inputDate) {
        if (inputDate != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
            return formatter.format(inputDate).toString();
        }
        return "";
    }

    //Assuming the account length is 10
    public static String formatAccountNumber(String accountNumber) {
        if (!StringUtils.isEmpty(accountNumber) && accountNumber.length() >= 10) {
            return String.join("-", accountNumber.substring(0, 3), accountNumber.substring(3, 7), accountNumber.substring(7, 10));
        }
        return accountNumber;
    }
}
