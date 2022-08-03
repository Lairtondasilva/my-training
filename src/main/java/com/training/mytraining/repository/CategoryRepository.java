package com.training.mytraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.mytraining.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
  
}
