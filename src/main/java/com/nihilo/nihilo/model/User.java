package com.nihilo.nihilo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="User")
public class User implements Serializable{
private static final long serialVersionUID = 4078490653480514934L;
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)   
 private Long id;
@Column(name="username")
private String username;
@Column(name="password")
private String password;    

    
}
