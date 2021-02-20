package com.nihilo.nihilo.controller;

import com.nihilo.nihilo.model.CreditTransaction;
import com.nihilo.nihilo.repository.CreditTransactionRepository;
import com.nihilo.nihilo.service.BalanceSheetService;
import com.nihilo.nihilo.service.IncomeStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CreditTransactionController {
    @Autowired
    private CreditTransactionRepository creditTransactionRepository;
   @Autowired
    private BalanceSheetService balanceSheet;

  @Autowired
   private IncomeStatement incomeStatement;

@GetMapping("/CreditTransaction")
      List<CreditTransaction> creditTransactions(){
        return creditTransactionRepository.findAll();
        
}
@GetMapping("/BalanceSheet/{startDate}/{endDate}")
      Map<String,Double>getBalanceSheet(@PathVariable Instant startDate,@PathVariable Instant endDate){
        return balanceSheet.balanceSheet(startDate, endDate);
        }

@GetMapping("/CreditTransaction/{creditTransId}")
    ResponseEntity<?>getCreditTransaction(@PathVariable Long creditTransId){
    Optional<CreditTransaction>creditTransaction=creditTransactionRepository.findById(creditTransId);
    return creditTransaction.map(response->ResponseEntity.ok().body(response))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

@GetMapping("/IncomeStatement/{startDate}/{endDate}")
    Map<String,Double>getIncomeStatement(@PathVariable Instant startDate,@PathVariable Instant endDate){
    return incomeStatement.incomeStatement(startDate, endDate);
}
@PostMapping("/CreditTransaction")
    ResponseEntity<CreditTransaction>createCreditTransaction(@RequestBody CreditTransaction creditTransaction)
    throws URISyntaxException {
        CreditTransaction result=creditTransactionRepository.save(creditTransaction);
        return ResponseEntity.created(new URI("/api/CreditTransaction"+result.getCreditTransId())).body(result);
    }

    @PostMapping("/CreditTransactions")
    ResponseEntity<?>createCreditTransactions(@RequestBody List<CreditTransaction> creditTransactions){
        List<CreditTransaction> result=creditTransactionRepository.saveAll(creditTransactions);
        return ResponseEntity.ok().body(result);
    }    


    @PutMapping("/CreditTransaction/{creditTransId}")
    ResponseEntity<CreditTransaction>updateCreditTransaction(@RequestBody CreditTransaction creditTransaction){
        CreditTransaction results=creditTransactionRepository.save(creditTransaction);
        return ResponseEntity.ok().body(results);
    }

    @DeleteMapping("/CreditTransaction/{creditTransId}")
    ResponseEntity<?>deleteCreditTransaction(@PathVariable Long creditTransId){
        creditTransactionRepository.deleteById(creditTransId);
        return ResponseEntity.ok().build();
    }


}
