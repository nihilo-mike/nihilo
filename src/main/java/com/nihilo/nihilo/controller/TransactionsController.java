package com.nihilo.nihilo.controller;

import java.util.List;
import java.util.Optional;
import java.net.URI;
import java.net.URISyntaxException;
import com.nihilo.nihilo.repository.TransactionRepository;
import com.nihilo.nihilo.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransactionsController {
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/Transaction")
    List<Transactions>Transactions(){
        return transactionRepository.findAll();
    }
    @GetMapping("/Transaction/{transId}")
      ResponseEntity<?>getTransaction(@PathVariable Long transId){
      Optional<Transactions>transaction=transactionRepository.findById(id);
        return transaction.map(response->ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
       }
    @PostMapping("/Transaction")
       ResponseEntity<Transactions>createTransaction(@RequestBody Transactions transactions)
               throws URISyntaxException {
           Transactions result=transactionRepository.save(transactions);
           return ResponseEntity.created(new URI("/api/Transaction"+result.getTransId())).body(result);
       }
    
       @DeleteMapping("/Transaction/{debitTransId}")
       ResponseEntity<?>deleteTransaction(@PathVariable Long transId){
           transactionRepository.deleteById(transId);
           return ResponseEntity.ok().build();
       }
  
  
  
  
  
  }

