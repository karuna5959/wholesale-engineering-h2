package com.wholesaleeng.dao.account;

import com.wholesaleeng.entity.AccountEntity;

import java.util.List;

public interface AccountDetailsService {

    List<AccountEntity> getTrnDtlsForAccountNbr(String userID);
}
