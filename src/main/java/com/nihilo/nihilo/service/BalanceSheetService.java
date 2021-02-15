package com.nihilo.nihilo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

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

List<CreditTransaction>cashList=cRepository.findBySubAccountType(1L);
List<CreditTransaction>cashEquivalentsList=cRepository.findBySubAccountType(2L);
List<CreditTransaction>accountReceivablesList=cRepository.findBySubAccountType(3L);
List<CreditTransaction>stockInventoryList=cRepository.findBySubAccountType(4L);
List<CreditTransaction>prepaidLiabilitiesList=cRepository.findBySubAccountType(5L);
List<CreditTransaction>intellectualPropertiesList=cRepository.findBySubAccountType(6L);
List<CreditTransaction>plantEquipmentList=cRepository.findBySubAccountType(7L);
 

@PostConstruct
public Map<String,Long> asset() {
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

@PostConstruct
private Long sumCalculator(List<CreditTransaction>cList){
    Long amount=0L; 
    for (CreditTransaction creditTransaction : cList) {
       Long tmp=creditTransaction.getAmount();
       amount+=tmp;
        }
        return amount;
}




}





