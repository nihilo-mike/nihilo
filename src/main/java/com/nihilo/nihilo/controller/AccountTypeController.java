package com.nihilo.nihilo.controller;

import com.nihilo.nihilo.model.AccountType;
import com.nihilo.nihilo.repository.AccountTypeRepository;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountTypeController {
private final AccountTypeRepository accountTypeRepository;


    public AccountTypeController(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

@GetMapping("/AccountType")
    Collection<AccountType> accountType() {
        return accountTypeRepository.findAll();//this is the jpa equivalent of select all
    }
@GetMapping("/AccountType/{accTypeId}")
    ResponseEntity<?> getAccountType(@PathVariable Long accTypeId){
        Optional<AccountType> accountType=accountTypeRepository.findById(accTypeId);
        return accountType.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

@PostMapping("/AccountType")
      ResponseEntity<AccountType>createAccountType(@Valid @RequestBody AccountType accountType) throws URISyntaxException {
        AccountType result=accountTypeRepository.save(accountType);
        return ResponseEntity.created(new URI("/api/AccountType"+result.getAccTypeId())).body(result);
    }

@DeleteMapping("/AccountType/{accTypeId}")
    ResponseEntity<?>deleteAccountType(@PathVariable Long accTypeId){
        accountTypeRepository.deleteById(accTypeId);
        return ResponseEntity.ok().build();
    }






}
