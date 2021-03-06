package com.nihilo.nihilo.controller;
 
import java.time.Instant;
import java.util.Map;

import com.nihilo.nihilo.service.AnalysisService;
import com.nihilo.nihilo.service.BalanceSheetService;
import com.nihilo.nihilo.service.IncomeStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AdditionalServices {
    
   @Autowired
    private BalanceSheetService balanceSheet;

    @Autowired
    private AnalysisService analysis;

  @Autowired
   private IncomeStatement incomeStatement;

@GetMapping("/BalanceSheet/{startDate}/{endDate}")
    Map<String,Double>getBalanceSheet(@PathVariable Instant startDate,@PathVariable Instant endDate){
        return balanceSheet.balanceSheet(startDate, endDate);
        }

@GetMapping("/Analysis/{startDate}/{endDate}")
      Map<String,Double>getAnalysis(@PathVariable Instant startDate,@PathVariable Instant endDate){
        return analysis.getAnalysis(startDate, endDate);
          }        


@GetMapping("/IncomeStatement/{startDate}/{endDate}")
    Map<String,Double>getIncomeStatement(@PathVariable Instant startDate,@PathVariable Instant endDate){
    return incomeStatement.incomeStatement(startDate, endDate);
}


}