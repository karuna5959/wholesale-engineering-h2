package com.wholesaleeng.repo;

import com.wholesaleeng.entity.TransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TransactionDetailsRepo
{
    @Autowired
    EntityManager entityManager;

    public List<TransactionEntity> getTransactionDetails(String accountNumber)
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<TransactionEntity> cq = cb.createQuery(TransactionEntity.class);
        Root<TransactionEntity> transactionEntityRoot = cq.from(TransactionEntity.class);

        Predicate authorNamePredicate = cb.equal(transactionEntityRoot.get("accountNumber"), accountNumber);

        cq.where(authorNamePredicate);

        TypedQuery<TransactionEntity> query = entityManager.createQuery(cq);
        return query.getResultList();
    }


}

