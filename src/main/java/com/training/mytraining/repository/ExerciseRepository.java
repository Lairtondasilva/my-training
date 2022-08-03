package com.training.mytraining.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.mytraining.exceptions.ExerciseNotFoundException;
import com.training.mytraining.model.ExerciseModel;

public interface ExerciseRepository extends JpaRepository<ExerciseModel, Long>{
  default List<ExerciseModel> findByIdOrElseThrow (List<Long> exerciseIds){
    List<ExerciseModel> exercises = new ArrayList<>();
    exercises.add((ExerciseModel) exerciseIds.stream().map(id->{
      if(findById(id).isPresent()){
        return findById(id).get();
      }
      throw new ExerciseNotFoundException();
    }
    ));
    return exercises;
  }
}
