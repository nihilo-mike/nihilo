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


 public Map<String,Double> asset() {
 
    List<CreditTransaction>cashList=cRepository.findBySubAccountType_SubId(1L);
   // List<CreditTransaction>cashEquivalentsList=cRepository.findBySubAccountType_SubId(2L);
   // List<CreditTransaction>accountReceivablesList=cRepository.findAllBySubAccountType_SubId(3L);
   // List<CreditTransaction>stockInventoryList=cRepository.findAllBySubAccountType_SubId(4L);
   // List<CreditTransaction>prepaidLiabilitiesList=cRepository.findAllBySubAccountType_SubId(5L);
   // List<CreditTransaction>intellectualPropertiesList=cRepository.findAllBySubAccountType_SubId(6L);
   // List<CreditTransaction>plantEquipmentList=cRepository.findAllBySubAccountType_SubId(7L);
  HashMap<String,Double>assetMap=new HashMap<>();
    assetMap.put("cash", sumCalculator(cashList));
  //  assetMap.put("cashEquivalents",sumCalculator(cashEquivalentsList));
   // assetMap.put( "accountReceivables",sumCalculator(accountReceivablesList));
   // assetMap.put("stockInventory",sumCalculator(stockInventoryList));
   // assetMap.put("prepaidLiabilites",sumCalculator(prepaidLiabilitiesList));
   // assetMap.put("intellectualProperties",sumCalculator(intellectualPropertiesList));
   // assetMap.put("plantEquipment",sumCalculator(plantEquipmentList)); 
  return assetMap;
}



//dr-cr
//date important 
//

private double sumCalculator(List<CreditTransaction>cList){
    double amount=0.0; 
    for (CreditTransaction creditTransaction : cList) {
       double tmp=creditTransaction.getAmount();
       amount+=tmp;
        }
        return amount;
}




}





