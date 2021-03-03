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

   Double cogs=incomeService.incomeStatement(startDate, endDate).get("cogs");
   Double inventory=balanceService.balanceSheet(startDate, endDate).get("stockInventory");
   Double totalAssests=balanceService.balanceSheet(startDate, endDate).get("totalAssets");
   Double totalEquity=balanceService.balanceSheet(startDate, endDate).get("totalEquity");
   Double ebit=incomeService.incomeStatement(startDate, endDate).get("ebit");
   Double interest=incomeService.incomeStatement(startDate, endDate).get("interestExpense");
   Double sales=incomeService.incomeStatement(startDate, endDate).get("revenue");
   Double netIncome=incomeService.incomeStatement(startDate, endDate).get("netIncome");
   Double accountrecievables=balanceService.balanceSheet(startDate, endDate).get("accountReceivables");
  
  
   HashMap<String,Double>analysis=new HashMap<>();
  analysis.put("debtRatio",(totalAssests-totalEquity)/totalAssests);
  analysis.put("Equitymultiplier",totalAssests/totalEquity);
  analysis.put("timesInterest",ebit/interest);
  analysis.put("inventoryTurnOver", cogs/inventory);
  analysis.put("recievablesTurnOver",sales/accountrecievables);
  analysis.put("totalAssetTurnOver",sales/totalAssests);
  analysis.put("capitalIntensity",totalAssests/sales);
  analysis.put("profitMargin",netIncome/sales);
  analysis.put("roa",netIncome/totalAssests);
  analysis.put("roe",netIncome/totalEquity);

   
  return analysis;
 } 


    
}
