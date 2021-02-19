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


public Map<String,Double>incomeStatement(Instant startDate,Instant endDate){
    double revenueCt=creditCalculator(cRepository.findbyAccountTypeandDate(2L, startDate, endDate));
    double revenueDt=debitCalculator(dRepository.findbyAccountTypeandDate(2L, startDate, endDate));
    double totalRevenue=revenueCt-revenueDt;
    double cogsDr=debitCalculator(dRepository.findbySubAccountandDate(30L, startDate, endDate));
    double cogsCr=creditCalculator(cRepository.findbySubAccountandDate(24L, startDate, endDate));
    double cogs=cogsDr-cogsCr;
    double sgac=debitCalculator(dRepository.findSgs(5L, startDate, endDate));
    double depriciation=creditCalculator(cRepository.findbySubAccountandDate(30L, startDate, endDate));
    double ebit=totalRevenue-cogs-sgac-depriciation;
    double interestDr=debitCalculator(dRepository.findbySubAccountandDate(31L, startDate, endDate));
    double interestCr=creditCalculator(cRepository.findbySubAccountandDate(31L, startDate, endDate));
    double interestExpense=interestDr-interestCr;
    double preTax=ebit-interestExpense;
    double taxes=0.2*preTax;
    double netIncome=preTax-checkTax(taxes);
    Map<String,Double>incomeMap=new HashMap<>();
        incomeMap.put("revenue",totalRevenue);
        incomeMap.put("COGS",cogs);
        incomeMap.put("SGAC",sgac);
        incomeMap.put("Depreciation",depriciation);
        incomeMap.put("Ebit",ebit);
        incomeMap.put("InterestExpense",interestExpense);
        incomeMap.put("PretaxIncome",ebit-interestExpense);
        incomeMap.put("Taxes",checkTax(taxes));
        incomeMap.put("netIncome",netIncome);
        incomeMap.put("Addition to earnings",0.0);
        incomeMap.put("Divivends",0.0);
  return incomeMap;
}



private double creditCalculator(List<CreditTransaction>cList){
    double amount=0.0; 
    for (CreditTransaction creditTransaction : cList) {
       double tmp=creditTransaction.getAmount();
       amount+=tmp;
        }
        return amount;
}
private double debitCalculator(List<DebitTransaction>dList){
    double amount=0.0; 
    for (DebitTransaction debitTransaction : dList) {
       double tmp=debitTransaction.getAmount();
       amount+=tmp;
        }
        return amount;
}
private double checkTax(double tax){
    if(tax<0.0){
        return 0.0;
    }
    return tax;
}



}
