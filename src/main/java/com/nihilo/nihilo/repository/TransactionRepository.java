package com.nihilo.nihilo.repository;


import java.util.Optional;

import com.nihilo.nihilo.model.Transactions;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransactionRepository extends PagingAndSortingRepository<Transactions,Long> {
  



}
