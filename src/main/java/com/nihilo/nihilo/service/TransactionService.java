package com.nihilo.nihilo.service;

import com.nihilo.nihilo.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

import com.nihilo.nihilo.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class TransactionService 
{
    @Autowired
    TransactionRepository repository;
     
    public List<Page<Transactions>> getAllTransactions(Integer pageNo, Integer pageSize)
      {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Transactions> pagedResult = repository.findAll(paging);
    if(pagedResult.hasContent()) {
        List<Page<Transactions>> result=new ArrayList<>();
        result.add(pagedResult); 
        return result;
        } else {
            return new ArrayList<>();
        }
    }
}