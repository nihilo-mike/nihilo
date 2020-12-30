package com.nihilo.nihilo.controller;

import com.nihilo.nihilo.model.CreditTransaction;
import com.nihilo.nihilo.repository.CreditTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CreditTransactionController {
    @Autowired
    private CreditTransactionRepository creditTransactionRepository;

@GetMapping("/CreditTransaction")
      List<CreditTransaction> creditTransactions(){
        return creditTransactionRepository.findAll();
}

@GetMapping("/CreditTransaction/{creditTransId}")
    ResponseEntity<?>getCreditTransaction(@PathVariable Long creditTransId){
    Optional<CreditTransaction>creditTransaction=creditTransactionRepository.findById(creditTransId);
    return creditTransaction.map(response->ResponseEntity.ok().body(response))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}
@PostMapping("/CreditTransaction")
    ResponseEntity<CreditTransaction>createCreditTransaction(@RequestBody CreditTransaction creditTransaction)throws URISyntaxException {
        CreditTransaction result=creditTransactionRepository.save(creditTransaction);
        return ResponseEntity.created(new URI("/api/CreditTransaction"+result.getCreditTransId())).body(result);
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
