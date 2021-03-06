package com.nihilo.nihilo.repository;
import java.util.List;

import com.nihilo.nihilo.model.Transactions;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransactionRepository extends PagingAndSortingRepository<Transactions,Long> {
  List<Transactions>findByTransId(Long transId,Pageable pageable);
  List<Transactions>findAll(Pageable pageable);   





    
}
