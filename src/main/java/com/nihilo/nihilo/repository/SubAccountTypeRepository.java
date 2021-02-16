package com.nihilo.nihilo.repository;

import java.util.List;
import java.util.Optional;

import com.nihilo.nihilo.model.SubAccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubAccountTypeRepository extends JpaRepository<SubAccountType, Long> {
   Optional<SubAccountType> findById(Long subId);
   List<SubAccountType> findByParent(int parent);
  

}
