package com.nihilo.nihilo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.nihilo.nihilo.model.CreditTransaction;
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


 public Map<String,Long> asset() {
  List<CreditTransaction>cashList=cRepository.findBySubAccountType(1l);
  List<CreditTransaction>cashEquivalentsList=cRepository.findBySubAccountType(2l);
  List<CreditTransaction>accountReceivablesList=cRepository.findBySubAccountType(3l);
  List<CreditTransaction>stockInventoryList=cRepository.findBySubAccountType(4l);
  List<CreditTransaction>prepaidLiabilitiesList=cRepository.findBySubAccountType(5l);
  List<CreditTransaction>intellectualPropertiesList=cRepository.findBySubAccountType(6l);
  List<CreditTransaction>plantEquipmentList=cRepository.findBySubAccountType(7l);
HashMap<String,Long>assetMap=new HashMap<>();
    assetMap.put("cash", sumCalculator(cashList));
    assetMap.put("cashEquivalents",sumCalculator(cashEquivalentsList));
    assetMap.put( "accountReceivables",sumCalculator(accountReceivablesList));
    assetMap.put("stockInventory",sumCalculator(stockInventoryList));
    assetMap.put("prepaidLiabilites",sumCalculator(prepaidLiabilitiesList));
    assetMap.put("intellectualProperties",sumCalculator(intellectualPropertiesList));
    assetMap.put("plantEquipment",sumCalculator(plantEquipmentList)); 
  return assetMap;
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





