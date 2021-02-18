package com.nihilo.nihilo.repository;

import com.nihilo.nihilo.model.DebitTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface DebitTransactionRepository extends JpaRepository<DebitTransaction,Long> {
    List<DebitTransaction>findDebitTransactionByAccountTypeAndSubAccountType(Long id,Long subId );
    List<DebitTransaction>findAllByDate(Instant date);
    List<DebitTransaction>findAll();
    List<DebitTransaction>findBySubAccountType_SubId(Long subId);
    @Query(value="SELECT d FROM DebitTransaction d WHERE d.accountType.accTypeId=:accTypeId AND d.date BETWEEN :startDate AND :endDate")
    List<DebitTransaction>findbyAccountTypeandDate(@Param("accTypeId")Long accTypeId,@Param("startDate")Instant
     startDate,@Param("endDate")Instant endDate);
     @Query(value="SELECT d FROM DebitTransaction d WHERE d.subAccountType.subId=:subId AND d.date BETWEEN :startDate AND :endDate")
   List<DebitTransaction>findbySubAccountandDate(@Param("subId")Long subId,@Param("startDate")Instant
    startDate,@Param("endDate")Instant endDate);
    @Query(value="SELECT d FROM DebitTransaction d WHERE d.accountType.accTypeId=:accTypeId AND d.subAccountType.subId NOT BETWEEN 30L AND 34L  AND d.date BETWEEN :startDate AND :endDate")
    List<DebitTransaction>findSgs(@Param("accTypeId")Long accTypeId,@Param("startDate")Instant
     startDate,@Param("endDate")Instant endDate);


}
