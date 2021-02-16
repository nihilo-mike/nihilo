package com.nihilo.nihilo.repository;

import com.nihilo.nihilo.model.CreditTransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;


public interface CreditTransactionRepository extends JpaRepository<CreditTransaction,Long> {
    List<CreditTransaction> findCreditTransactionByAccountTypeAndSubAccountType(Long id, Long subId );
    List<CreditTransaction>findAllByDate(Instant date);
    List<CreditTransaction>findAll();
    @Query("SELECT * from CreditTransaction as creditTransaction WHERE creditTransaction.subAccountType.subId=:subId")
    List<CreditTransaction>findAllBySubAccountType(Long subId);
    
  }
