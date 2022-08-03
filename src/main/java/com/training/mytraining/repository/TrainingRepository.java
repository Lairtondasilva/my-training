package com.training.mytraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.mytraining.model.TrainingModel;

public interface TrainingRepository extends JpaRepository<TrainingModel, Long>{
  
}
