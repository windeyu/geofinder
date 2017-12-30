package com.imotiontech.repository;

import com.imotiontech.domain.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findByName(String accountName);

}
