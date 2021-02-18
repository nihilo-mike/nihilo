package com.nihilo.nihilo.service;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nihilo.nihilo.model.CreditTransaction;
import com.nihilo.nihilo.model.DebitTransaction;
import com.nihilo.nihilo.repository.CreditTransactionRepository;
import com.nihilo.nihilo.repository.DebitTransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class IncomeStatement {

@Autowired
CreditTransactionRepository cRepository;

@Autowired
DebitTransactionRepository dRepository;


    
public Map<String,Long>incomeStatement(Instant startDate,Instant endDate){

List<CreditTransaction>revenue=cRepository.findbyAccountTypeandDate(2L, startDate, endDate);

Map<String,Long>revenueMap=new HashMap<>();
revenueMap.put("revenue", sumCalculator(revenue));

return revenueMap;

}


private Long sumCalculator(List<CreditTransaction>cList){
    Long amount=0L; 
    for (CreditTransaction creditTransaction : cList) {
       Long tmp=creditTransaction.getAmount();
       amount+=tmp;
        }
        return amount;
}






}
