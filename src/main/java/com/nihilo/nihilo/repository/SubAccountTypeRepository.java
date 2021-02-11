package com.nihilo.nihilo.repository;

import java.util.List;

import com.nihilo.nihilo.model.SubAccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubAccountTypeRepository extends JpaRepository<SubAccountType,Long> {
   List<SubAccountType> findBySubId(Long subId);
   List<SubAccountType> findByParent(int parent);
  

}
