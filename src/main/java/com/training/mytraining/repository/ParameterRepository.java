package com.training.mytraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.mytraining.exceptions.ParameterNotFoundException;
import com.training.mytraining.model.ParameterModel;

public interface ParameterRepository extends JpaRepository<ParameterModel, Long> {
  default ParameterModel findByIdOrElseThrow(Long id){
    if (id == null) return null;
    if(findById(id).isPresent()){
      return findById(id).get();
    }
    throw new ParameterNotFoundException(id);
  }
}
