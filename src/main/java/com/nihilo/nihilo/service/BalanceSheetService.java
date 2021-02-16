package com.nihilo.nihilo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.nihilo.nihilo.model.CreditTransaction;
import com.nihilo.nihilo.model.SubAccountType;
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
 
 SubAccountType a=new SubAccountType();
 a.setSubId(1L);

List<CreditTransaction>cashList=cRepository.findAllBySubAccountType(a);
List<CreditTransaction>cashEquivalentsList=cRepository.findBySubAccountType_SubId(1L);
 //List<CreditTransaction>accountReceivablesList=cRepository.findAllBySubAccountType(3L);
 // List<CreditTransaction>stockInventoryList=cRepository.findAllBySubAccountType(4L);
 // List<CreditTransaction>prepaidLiabilitiesList=cRepository.findAllBySubAccountType(5L);
 // List<CreditTransaction>intellectualPropertiesList=cRepository.findAllBySubAccountType(6L);
  //List<CreditTransaction>plantEquipmentList=cRepository.findAllBySubAccountType(7L);
HashMap<String,Long>assetMap=new HashMap<>();
    assetMap.put("cash", sumCalculator(cashList));
    assetMap.put("cashEquivalents",sumCalculator(cashEquivalentsList));
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

private Long sumCalculator(List<CreditTransaction>cList){
    Long amount=0L; 
    for (CreditTransaction creditTransaction : cList) {
       Long tmp=creditTransaction.getAmount();
       amount+=tmp;
        }
        return amount;
}




}





