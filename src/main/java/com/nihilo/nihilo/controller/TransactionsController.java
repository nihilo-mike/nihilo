package com.nihilo.nihilo.controller;

import java.util.List;
import java.util.Optional;
import java.net.URI;
import java.net.URISyntaxException;
import com.nihilo.nihilo.repository.TransactionRepository;
import com.nihilo.nihilo.service.TransactionService;
import com.nihilo.nihilo.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TransactionsController {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService service;
    


    @GetMapping("/Transaction")
    public List<?> getAllTransactions(
        @RequestParam(defaultValue = "0") Integer pageNo, 
        @RequestParam(defaultValue = "5") Integer pageSize) 
          {
         return  service.getAllTransactions(pageNo, pageSize); 
          }
    @GetMapping("/Transaction/{remark}")
      ResponseEntity<?>searchRemark(@PathVariable String remark){
        Optional<Transactions>transaction=transactionRepository.searchByRemark(remark);
            return transaction.map(response->ResponseEntity.ok().body(response))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
           }
    






    @GetMapping("/Transaction/{transId}")
      ResponseEntity<?>getTransaction(@PathVariable Long transId){
      Optional<Transactions>transaction=transactionRepository.findById(transId);
        return transaction.map(response->ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
       }
    @PostMapping("/Transaction")
       ResponseEntity<Transactions>createTransaction(@RequestBody Transactions transactions)
               throws URISyntaxException {
           Transactions result=transactionRepository.save(transactions);
           return ResponseEntity.created(new URI("/api/Transaction"+result.getTransId())).body(result);
       }
    
       @DeleteMapping("/Transaction/{transId}")
       ResponseEntity<?>deleteTransaction(@PathVariable Long transId){
           transactionRepository.deleteById(transId);
           return ResponseEntity.ok().build();
       }
  
  
  
  
  
  }

