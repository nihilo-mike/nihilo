package com.nihilo.nihilo.repository;
import java.util.List;

import com.nihilo.nihilo.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions,Long> {
  List<Transactions>findByTransId(Long transId);
  List<Transactions>findAll();   





    
}
