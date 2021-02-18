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
    double revenueCt=sumCalculator(cRepository.findbyAccountTypeandDate(2L, startDate, endDate));
    double revenueDt=drCalculator(dRepository.findbyAccountTypeandDate(2L, startDate, endDate));
    double totalRevenue=revenueCt-revenueDt;
    double cogsDr=drCalculator(dRepository.findbySubAccountandDate(30L, startDate, endDate));
    double cogsCr=sumCalculator(cRepository.findbySubAccountandDate(24L, startDate, endDate));
    double cogs=cogsDr-cogsCr;
    double sgac=drCalculator(dRepository.findSgs(5L, startDate, endDate));
    double depriciation=sumCalculator(cRepository.findbySubAccountandDate(30L, startDate, endDate));
    double ebit=totalRevenue-cogs-sgac-depriciation;
    double interestDr=drCalculator(dRepository.findbySubAccountandDate(31L, startDate, endDate));
    double interestCr=sumCalculator(cRepository.findbySubAccountandDate(31L, startDate, endDate));
    double interestExpense=interestDr-interestCr;
    double preTax=ebit-interestExpense;
    double taxes=0.2*preTax;
    double netIncome=preTax-taxes;
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



private double sumCalculator(List<CreditTransaction>cList){
    double amount=0.0; 
    for (CreditTransaction creditTransaction : cList) {
       double tmp=creditTransaction.getAmount();
       amount+=tmp;
        }
        return amount;
}
private double drCalculator(List<DebitTransaction>dList){
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
