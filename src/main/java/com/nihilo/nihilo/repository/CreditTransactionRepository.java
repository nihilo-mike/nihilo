package com.nihilo.nihilo.repository;

import java.time.Instant;
import java.util.List;

import com.nihilo.nihilo.model.CreditTransaction;
import com.nihilo.nihilo.model.SubAccountType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditTransactionRepository extends JpaRepository<CreditTransaction, Long> {
  List<CreditTransaction> findCreditTransactionByAccountTypeAndSubAccountType(Long id, Long subId);

  List<CreditTransaction> findAllByDate(Instant date);

  List<CreditTransaction> findAll();

  List<CreditTransaction> findAllBySubAccountType(SubAccountType subId);

  List<CreditTransaction>findBySubAccountType_SubId(Long subId);
    
  }
