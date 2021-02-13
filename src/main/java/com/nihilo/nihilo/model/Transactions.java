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
@OneToMany(cascade=CascadeType.REMOVE,orphanRemoval = true)
private List<CreditTransaction> creditTransactions;
@OneToMany(cascade=CascadeType.REMOVE,orphanRemoval = true)
private List<DebitTransaction> debitTransactions;

    
}
