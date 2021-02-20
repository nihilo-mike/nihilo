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
public class BalanceSheetService {

@Autowired
CreditTransactionRepository cRepository;

@Autowired
DebitTransactionRepository dRepository;

public Map<String,Double> balanceSheet(Instant startDate,Instant endDate) {
 //im getting the data from the database by subid which is a Long and date then opertating on it 
  final double cash=drCalculator(dRepository.findbySubAccountandDate(1L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(1L, startDate, endDate));
  final double cashEquivalents=drCalculator(dRepository.findbySubAccountandDate(2L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(2L, startDate, endDate));
  final double accountReceivables=drCalculator(dRepository.findbySubAccountandDate(3L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(3L, startDate, endDate));
  final double stockInventory=drCalculator(dRepository.findbySubAccountandDate(4L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(4L, startDate, endDate));
  final double prepaidLiabilities=drCalculator(dRepository.findbySubAccountandDate(5L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(5L, startDate, endDate));
  final double intellectualProperties=drCalculator(dRepository.findbySubAccountandDate(6L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(6L, startDate, endDate));
  final double plantEquipment=drCalculator(dRepository.findbySubAccountandDate(7L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(7L, startDate, endDate));
  final double accountsPayable=drCalculator(dRepository.findbySubAccountandDate(13L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(13L, startDate, endDate));
  final double taxesPayable=drCalculator(dRepository.findbySubAccountandDate(14L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(14L, startDate, endDate));
  final double interestPayable=drCalculator(dRepository.findbySubAccountandDate(15L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(15L, startDate, endDate));
  final double notesPayable=drCalculator(dRepository.findbySubAccountandDate(16L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(16L, startDate, endDate));
  final double accruedExpense=drCalculator(dRepository.findbySubAccountandDate(17L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(17L, startDate, endDate));
  final double unearnedRevenue=drCalculator(dRepository.findbySubAccountandDate(18L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(18L, startDate, endDate));
  final double mortgagePayable=drCalculator(dRepository.findbySubAccountandDate(19L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(19L, startDate, endDate));
  final double longTermDebt=drCalculator(dRepository.findbySubAccountandDate(20L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(20L, startDate, endDate));
  final double ownersEquity=drCalculator(dRepository.findbySubAccountandDate(21L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(21L, startDate, endDate));
  final double commonStocks=drCalculator(dRepository.findbySubAccountandDate(22L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(22L, startDate, endDate));
  final double retainedEarnings=drCalculator(dRepository.findbySubAccountandDate(23L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(23L, startDate, endDate));
  final double ownersDrawing=drCalculator(dRepository.findbySubAccountandDate(44L, startDate, endDate))-crCalculator(
    cRepository.findbySubAccountandDate(44L, startDate, endDate));  
  HashMap<String,Double>balance=new HashMap<>();
    balance.put("cash", cash);
    balance.put("cashEquivalent",cashEquivalents);
    balance.put("accountReceivables",accountReceivables);
    balance.put("stockInventory",stockInventory);
    balance.put("prepaidLiabilities",prepaidLiabilities);
    balance.put("intellectualProperties",intellectualProperties);
    balance.put("plantEquipment",plantEquipment);
    balance.put("accountsPayable",accountsPayable);
    balance.put( "taxesPayable",taxesPayable);
    balance.put( "interestPayable",interestPayable);
    balance.put( "notesPayable",notesPayable);
    balance.put( "accruedExpense",accruedExpense);
    balance.put( "unearnedRevenue",unearnedRevenue);
    balance.put( "mortgagePayable",mortgagePayable);
    balance.put("longTermDebt" ,longTermDebt);
    balance.put("ownersEquity" ,ownersEquity);
    balance.put( "commonStocks",commonStocks);
    balance.put( "retainedEarnings",retainedEarnings);
    balance.put( "ownersDrawing",ownersDrawing);
    return balance;
}

private double crCalculator(List<CreditTransaction>cList){
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



}





