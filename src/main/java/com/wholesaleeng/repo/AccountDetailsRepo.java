package com.wholesaleeng.repo;

import com.wholesaleeng.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountDetailsRepo extends CrudRepository<AccountEntity, String> {

    List<AccountEntity> findByUserID(String userName);

}
