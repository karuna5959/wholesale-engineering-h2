package com.wholesaleeng.repo;

import com.wholesaleeng.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDetailsRepo extends CrudRepository<TransactionEntity, String> {
    List<TransactionEntity> findByAccountNumber(String accountNumber);
}

