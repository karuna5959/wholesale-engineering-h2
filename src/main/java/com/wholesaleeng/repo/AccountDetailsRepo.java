package com.wholesaleeng.repo;

import com.wholesaleeng.entity.AccountEntity;
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
public class AccountDetailsRepo {

    @Autowired
    EntityManager entityManager;

    public List<AccountEntity> getAccountDetailsForUser(String userName)
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<AccountEntity> cq = cb.createQuery(AccountEntity.class);
        Root<AccountEntity> accountEntity = cq.from(AccountEntity.class);

        Predicate authorNamePredicate = cb.equal(accountEntity.get("userID"), userName);

        cq.where(authorNamePredicate);

        TypedQuery<AccountEntity> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

}
