package com.training.mytraining.mappers;

import org.springframework.stereotype.Component;

import com.training.mytraining.dtos.training.TrainingRequest;
import com.training.mytraining.dtos.training.TrainingResponse;
import com.training.mytraining.model.TrainingModel;
import com.training.mytraining.repository.ExerciseRepository;

@Component
public class TrainingMapper {
 
  private final ExerciseRepository exerciseRepository;
  private final ExerciseMapper exerciseMapper;

  public TrainingMapper(ExerciseRepository exerciseRepository, ExerciseMapper exerciseMapper) {
    this.exerciseRepository = exerciseRepository;
    this.exerciseMapper = exerciseMapper;
  }

  public TrainingModel toModel (TrainingRequest request){
    return TrainingModel.builder().trainingName(request.getName())
      .startDate(request.getStartDate())
      .endDate(request.getEndDate())
      .exercises(exerciseRepository.findByIdOrElseThrow(request.getExercisesId())).build();
  }

  public TrainingResponse toTrainingResponse (TrainingModel training){
    return TrainingResponse.builder().id(training.getId())
      .name(training.getTrainingName()).startTraining(training.getStartDate())
      .endTraining(training.getEndDate()).exercises(exerciseMapper.toExerciseResponse(training.getExercises()))
      .build();
  }
}
