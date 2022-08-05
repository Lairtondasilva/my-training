package com.training.mytraining.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.training.mytraining.dtos.exercises.ExerciseResponse;
import com.training.mytraining.model.ExerciseModel;

@Component
public class ExerciseMapper {

  private final ParameterMapper parameterMapper;
  private final CategoryMapper categoryMapper;

  public ExerciseMapper(ParameterMapper parameterMapper, CategoryMapper categoryMapper) {
    this.parameterMapper = parameterMapper;
    this.categoryMapper = categoryMapper;
  }

  public ExerciseResponse toExerciseResponse (ExerciseModel exerciseModel){
    return ExerciseResponse.builder().id(exerciseModel.getId())
      .name(exerciseModel.getExeciseName())
      .urlDemonstration(exerciseModel.getImgVideoUrl())
      .observations(exerciseModel.getObservations())
      .parameters(parameterMapper.toParametersResponse(exerciseModel.getParameterModel()))
      .categories(categoryMapper.toCategoryResponse(exerciseModel.getCategorias())).build();
  }

  public List<ExerciseResponse> toExerciseResponse (List<ExerciseModel> exercises){
    return exercises.stream().map(ex->toExerciseResponse(ex)).toList();
  }
}
