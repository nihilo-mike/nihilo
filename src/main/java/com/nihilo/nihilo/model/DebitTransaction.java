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
@Table(name="DebitTransaction")
public class DebitTransaction {
    @Id
    @GeneratedValue
    private Long debitTransId;
    private long amount;
    private String remark;
    private Instant date;
    @ManyToOne
    private AccountType accountType;
    @ManyToOne
    private SubAccountType subAccountType;
    @ManyToOne
    private Transactions transactions;

}
