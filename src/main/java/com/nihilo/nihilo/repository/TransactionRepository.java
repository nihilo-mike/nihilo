package com.nihilo.nihilo.repository;


import java.util.Optional;

import com.nihilo.nihilo.model.Transactions;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends PagingAndSortingRepository<Transactions,Long> {
  

@Query(value = "select t from Transactions t left join t.creditTransactions c where c.remark LIKE CONCAT('%',UPPER(:remark),'%')"+
"OR t left join t.debittransactions d where d.remark LIKE CONCAT('%',UPPER(:remark),'%') ")
Optional<Transactions>searchByRemark(@Param("remark") String remark);



}
