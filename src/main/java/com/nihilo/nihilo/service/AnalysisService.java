package com.nihilo.nihilo.service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import com.nihilo.nihilo.repository.CreditTransactionRepository;
import com.nihilo.nihilo.repository.DebitTransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class AnalysisService {

    @Autowired
    CreditTransactionRepository cRepository;

    @Autowired
    DebitTransactionRepository dRepository;

    @Autowired
    BalanceSheetService balanceService;

    @Autowired
    IncomeStatement incomeService;

  public Map<String,Double>getAnalysis(Instant startDate,Instant endDate){

   //Double cash= balanceService.balanceSheet(startDate, endDate).get("cash");
   Double cogs=incomeService.incomeStatement(startDate, endDate).get("cogs");
   Double inventory=balanceService.balanceSheet(startDate, endDate).get("stockInventory");
     
  HashMap<String,Double>analysis=new HashMap<>();
  analysis.put("inventoryTurnOver", cogs/inventory);      
   
  return analysis;
 } 


    
}
