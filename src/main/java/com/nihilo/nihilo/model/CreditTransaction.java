package com.nihilo.nihilo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="CreditTransaction")
public class CreditTransaction {
    @Id
    @GeneratedValue
    private Long creditTransId;   
private long amount;
private String remark;
private Instant date;
@ManyToOne
private AccountType accountType;
@ManyToOne
private SubAccountType subAccountType;



}
