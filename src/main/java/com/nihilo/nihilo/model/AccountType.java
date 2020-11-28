package com.nihilo.nihilo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name = "AccountType")
public class AccountType {
@Id
private Long accTypeId;
private String name;

}
