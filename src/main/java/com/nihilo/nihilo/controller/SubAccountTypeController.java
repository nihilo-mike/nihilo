package com.nihilo.nihilo.controller;

import com.nihilo.nihilo.model.SubAccountType;
import com.nihilo.nihilo.repository.SubAccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SubAccountTypeController {

    private SubAccountTypeRepository subAccountTypeRepository;
    public SubAccountTypeController(SubAccountTypeRepository subAccountTypeRepository) {
        this.subAccountTypeRepository=subAccountTypeRepository;
    }

    @GetMapping("/SubAccountType")
    Collection<SubAccountType> subAccountType() {
        return subAccountTypeRepository.findAll();//this is the jpa equivalent of select all
    }
    @GetMapping("/SubAccountType/{subId}")
    ResponseEntity<?> getAccountType(@PathVariable Long subId){
        Optional<SubAccountType> subAccountType=subAccountTypeRepository.findById(subId);
        return subAccountType.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/SubAccountType")
    ResponseEntity<SubAccountType>createSubAccountType(@RequestBody SubAccountType subAccountType)
            throws URISyntaxException {
        SubAccountType result=subAccountTypeRepository.save(subAccountType);
        return ResponseEntity.created(new URI("/api/SubAccountType"+result.getSubId())).body(result);
    }

    @DeleteMapping("/SubAccountType/{subId}")
    ResponseEntity<?>deleteAccountType(@PathVariable Long subId){
        subAccountTypeRepository.deleteById(subId);
        return ResponseEntity.ok().build();
    }






}
