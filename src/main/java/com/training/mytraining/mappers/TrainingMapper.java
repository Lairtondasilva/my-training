package com.training.mytraining.mappers;

import org.springframework.stereotype.Component;

import com.training.mytraining.dtos.training.TrainingRequest;
import com.training.mytraining.model.TrainingModel;
import com.training.mytraining.repository.ExerciseRepository;

@Component
public class TrainingMapper {
 
  private final ExerciseRepository exerciseRepository;

  public TrainingMapper(ExerciseRepository exerciseRepository){
    this.exerciseRepository = exerciseRepository;
  }

  public TrainingModel toTrainingModel (TrainingRequest training){
    return TrainingModel.builder().trainingName(training.getName())
      .startDate(training.getStartDate())
      .endDate(training.getEndDate())
      .exercises(exerciseRepository.findByIdOrElseThrow(training.getExercisesId())).build();
  }
}
