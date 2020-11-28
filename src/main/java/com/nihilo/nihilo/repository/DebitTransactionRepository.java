package com.nihilo.nihilo.repository;

import com.nihilo.nihilo.model.DebitTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface DebitTransactionRepository extends JpaRepository<DebitTransaction,Long> {
    List<DebitTransaction>findDebitTransactionByAccountTypeAndSubAccountType(Long id,Long subId );
    List<DebitTransaction>findAllByDate(Instant date);
    List<DebitTransaction>findAll();
    List<DebitTransaction>findBySubAccountType(Long subId);
}
