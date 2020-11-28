package com.nihilo.nihilo.repository;

import com.nihilo.nihilo.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTypeRepository extends JpaRepository<AccountType,Long >{
    List<AccountType>findByName(String name);
}
