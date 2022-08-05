package com.training.mytraining.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.mytraining.exceptions.ExerciseNotFoundException;
import com.training.mytraining.model.ExerciseModel;

public interface ExerciseRepository extends JpaRepository<ExerciseModel, Long>{
  default List<ExerciseModel> findByIdOrElseThrow (List<Long> exerciseIds){
    List<ExerciseModel> exercises = new ArrayList<>();
    exerciseIds.forEach(id->{
      if(findById(id).isEmpty()){
        throw new ExerciseNotFoundException();
      }
      else{
        exercises.add(findById(id).get());
      }
    }
    );
    return exercises;
  }
}
