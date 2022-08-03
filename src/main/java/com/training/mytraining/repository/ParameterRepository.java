package com.training.mytraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.mytraining.model.ParameterModel;

public interface ParameterRepository extends JpaRepository<ParameterModel, Long> {
  
}
