package com.training.mytraining.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.mytraining.exceptions.CategoryNotFoundException;
import com.training.mytraining.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
  default List<CategoryModel> findAllByIdOrELseThrow(List<Long> ids){

    if (ids ==null ) return null;
    
    List<CategoryModel> categories = new ArrayList<>();
    ids.forEach(id->{
      if(!findById(id).isPresent()){
        throw new CategoryNotFoundException(id);
      }
      else{
        categories.add(findById(id).get());
      }
    });
    return categories;
  }
}
