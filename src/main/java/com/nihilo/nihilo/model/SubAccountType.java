package com.nihilo.nihilo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name = "SubAccountType")
public class SubAccountType {
    @Id
    @Column(name="sub_id")
    private Long id;
    private String name;
    private int parent;

}
