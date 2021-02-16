package com.nihilo.nihilo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Transactions")
public class Transactions {
    @Id
    @GeneratedValue    
private Long transId;
@OneToMany
private List<CreditTransaction> creditTransactions;
@OneToMany
private List<DebitTransaction> debitTransactions;

    
}
