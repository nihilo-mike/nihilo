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

    final Instant endYear = Instant.parse("2022-12-31T00:00:00.000Z");
    final Instant startYear = Instant.parse("2021-01-01T00:00:00.000Z");
    final Instant second=Instant.parse("2021-02-01T00:00:00.000Z");
    final Instant third=Instant.parse("2021-03-01T00:00:00.000Z");
    final Instant fourth=Instant.parse("2021-04-01T00:00:00.000Z");
    final Instant fifth=Instant.parse("2021-05-01T00:00:00.000Z");
    final Instant sixth=Instant.parse("2021-06-01T00:00:00.000Z");
    final Instant seventh=Instant.parse("2021-07-01T00:00:00.000Z");
    final Instant eighth=Instant.parse("2021-08-01T00:00:00.000Z");
    final Instant ninth=Instant.parse("2021-09-01T00:00:00.000Z");
    final Instant tenth=Instant.parse("2021-10-01T00:00:00.000Z");
    final Instant eleventh=Instant.parse("2021-11-01T00:00:00.000Z");
    final Instant twelfth=Instant.parse("2021-12-01T00:00:00.000Z");
    String profitMargin="profitMargin";
    String roa="roa";
    String rev="revenue";

  public Map<String,Double>getAnalysis(Instant startDate,Instant endDate){

   Double cogs=incomeService.incomeStatement(startDate, endDate).get("cogs");
   Double inventory=balanceService.balanceSheet(startDate, endDate).get("stockInventory");
   Double totalAssests=balanceService.balanceSheet(startDate, endDate).get("totalAssets");
   Double totalEquity=balanceService.balanceSheet(startDate, endDate).get("totalEquity");
   Double ebit=incomeService.incomeStatement(startDate, endDate).get("ebit");
   Double interest=incomeService.incomeStatement(startDate, endDate).get("interestExpense");
   Double sales=incomeService.incomeStatement(startDate, endDate).get(rev);
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
  Double totalRevenue=incomeService.incomeStatement(startYear, endYear).get(rev);
  HashMap<String,Double>revenue=new HashMap<>();
  revenue.put(rev,totalRevenue);
  return revenue;
   }

   public Map<String,Double>getProfitMargin(){
    Double janProfitMargin=getAnalysis(startYear,second).get(profitMargin);
    Double febProfitMargin=getAnalysis(second,third).get(profitMargin);
    Double marProfitMargin=getAnalysis(third,fourth).get(profitMargin);
    Double aprProfitMargin=getAnalysis(fourth,fifth).get(profitMargin);
    Double mayProfitMargin=getAnalysis(fifth,sixth).get(profitMargin);
    Double junProfitMargin=getAnalysis(sixth,seventh).get(profitMargin);
    Double julProfitMargin=getAnalysis(seventh,eighth).get(profitMargin);
    Double augProfitMargin=getAnalysis(eighth,ninth).get(profitMargin);
    Double sepProfitMargin=getAnalysis(ninth,tenth).get(profitMargin);
    Double octProfitMargin=getAnalysis(tenth,eleventh).get(profitMargin);
    Double novProfitMargin=getAnalysis(eleventh,twelfth).get(profitMargin);
    Double decProfitMargin=getAnalysis(twelfth,endYear).get(profitMargin);
    HashMap<String,Double>profitMar=new HashMap<>();
    profitMar.put("january",janProfitMargin);
    profitMar.put("february",febProfitMargin);
    profitMar.put("march",marProfitMargin);
    profitMar.put("april",aprProfitMargin);
    profitMar.put("may",mayProfitMargin);
    profitMar.put("june",junProfitMargin);
    profitMar.put("july",julProfitMargin);
    profitMar.put("august",augProfitMargin);
    profitMar.put("september",sepProfitMargin);
    profitMar.put("october",octProfitMargin);
    profitMar.put("november",novProfitMargin);
    profitMar.put("december",decProfitMargin);
    return profitMar;
     }

     public Map<String,Double>getRoa(){
      Double janRoa=getAnalysis(startYear,second).get(roa);
      Double febRoa=getAnalysis(second,third).get(roa);
      Double marRoa=getAnalysis(third,fourth).get(roa);
      Double aprRoa=getAnalysis(fourth,fifth).get(roa);
      Double mayRoa=getAnalysis(fifth,sixth).get(roa);
      Double junRoa=getAnalysis(sixth,seventh).get(roa);
      Double julRoa=getAnalysis(seventh,eighth).get(roa);
      Double augRoa=getAnalysis(eighth,ninth).get(roa);
      Double sepRoa=getAnalysis(ninth,tenth).get(roa);
      Double octRoa=getAnalysis(tenth,eleventh).get(roa);
      Double novRoa=getAnalysis(eleventh,twelfth).get(roa);
      Double decRoa=getAnalysis(twelfth,endYear).get(roa);
      HashMap<String,Double>Roa=new HashMap<>();
      Roa.put("january",janRoa);
      Roa.put("february",febRoa);
      Roa.put("march",marRoa);
      Roa.put("april",aprRoa);
      Roa.put("may",mayRoa);
      Roa.put("june",junRoa);
      Roa.put("july",julRoa);
      Roa.put("august",augRoa);
      Roa.put("september",sepRoa);
      Roa.put("october",octRoa);
      Roa.put("november",novRoa);
      Roa.put("december",decRoa);
      return Roa;
       }  
  




  
  
  
  
  
  
    }