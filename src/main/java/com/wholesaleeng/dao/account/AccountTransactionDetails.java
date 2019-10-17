package com.wholesaleeng.dao.account;

import com.wholesaleeng.entity.TransactionEntity;

import java.util.List;

public interface AccountTransactionDetails {

    List<TransactionEntity> getTrnDtlsForAccountNbr(int accountNbr);
}
