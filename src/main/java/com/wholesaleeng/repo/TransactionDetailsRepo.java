package com.wholesaleeng.repo;

import com.wholesaleeng.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TransactionDetailsRepo extends JpaRepository<TransactionEntity,String> {

    @Transactional
    @Query("SELECT A FROM TransactionEntity A WHERE A.accountNumber = ?1")
    List<TransactionEntity> getTrnDtlsForAccountNbr(String accountNbr);
}
