package com.nihilo.nihilo.controller;

import com.nihilo.nihilo.model.CreditTransaction;
import com.nihilo.nihilo.model.DebitTransaction;
import com.nihilo.nihilo.repository.CreditTransactionRepository;
import com.nihilo.nihilo.repository.DebitTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DebitTransactionController {
    @Autowired
    private DebitTransactionRepository debitTransactionRepository;

    @GetMapping("/DebitTransaction")
    List<DebitTransaction> debitTransactions(){
        return debitTransactionRepository.findAll();
    }

    @GetMapping("/DebitTransaction/{debitTransId}")
    ResponseEntity<?>getDebitTransaction(@PathVariable Long debitTransId){
        Optional<DebitTransaction>debitTransaction=debitTransactionRepository.findById(debitTransId);
        return debitTransaction.map(response->ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/DebitTransaction")
    ResponseEntity<DebitTransaction>createDebitTransaction(@RequestBody DebitTransaction debitTransaction)
            throws URISyntaxException {
        DebitTransaction result=debitTransactionRepository.save(debitTransaction);
        return ResponseEntity.created(new URI("/api/DebitTransaction"+result.getDebitTransId())).body(result);
    }

    @PutMapping("/DebitTransaction/{debitTransId}")
    ResponseEntity<DebitTransaction>updateDebitTransaction(@RequestBody DebitTransaction debitTransaction){
        DebitTransaction results=debitTransactionRepository.save(debitTransaction);
        return ResponseEntity.ok().body(results);
    }

    @DeleteMapping("/DebitTransaction/{debitTransId}")
    ResponseEntity<?>deleteDebitTransaction(@PathVariable Long debitTransId){
        debitTransactionRepository.deleteById(debitTransId);
        return ResponseEntity.ok().build();
    }


}
