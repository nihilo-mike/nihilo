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

  Instant endYear = Instant.parse("2022-12-31T00:00:00.000Z");
  Instant startYear = Instant.parse("2021-01-01T00:00:00.000Z");


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

public Map<String,Double>getTotalRevenue(){
  Double totalRevenue=incomeService.incomeStatement(startYear, endYear).get("revenue");
  HashMap<String,Double>revenue=new HashMap<>();
  revenue.put("revenue",totalRevenue);
  return revenue;
   }
   

}