package com.nihilo.nihilo.repository;

import java.time.Instant;
import java.util.List;

import com.nihilo.nihilo.model.CreditTransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CreditTransactionRepository extends JpaRepository<CreditTransaction, Long> {
  List<CreditTransaction> findCreditTransactionByAccountTypeAndSubAccountType(Long id, Long subId);

  List<CreditTransaction> findAllByDate(Instant date);

  List<CreditTransaction> findAll();
  @Query(value="SELECT c FROM CreditTransaction c WHERE c.accountType.accTypeId=:accTypeId AND c.date BETWEEN :startDate AND :endDate")
  List<CreditTransaction>findbyAccountTypeandDate(@Param("accTypeId")Long accTypeId,@Param("startDate")Instant
   startDate,@Param("endDate")Instant endDate);
  
  List<CreditTransaction>findBySubAccountType_SubId(Long subId);
    
  }
