package com.nihilo.nihilo.repository;


import java.util.Optional;

import com.nihilo.nihilo.model.Transactions;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends PagingAndSortingRepository<Transactions,Long> {
  

@Query(value = "SELECT t from Transactions t  OUTER JOIN  t.creditTransactions c where c.remark LIKE CONCAT('%',UPPER(:remark),'%')"+
"OR t OUTER JOIN t.debitTransactions d where d.remark LIKE CONCAT('%',UPPER(:remark),'%') ")
Optional<Transactions>searchByRemark(@Param("remark") String remark);



}
