package com.training.mytraining.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.training.mytraining.dtos.exercises.ExerciseRequest;
import com.training.mytraining.dtos.exercises.ExerciseResponse;
import com.training.mytraining.model.ExerciseModel;
import com.training.mytraining.repository.CategoryRepository;
import com.training.mytraining.repository.ParameterRepository;

@Component
public class ExerciseMapper {

  private final CategoryRepository categoryRepository;
  private final ParameterRepository parameterRepository;
  private final ParameterMapper parameterMapper;
  private final CategoryMapper categoryMapper;

  public ExerciseMapper(ParameterMapper parameterMapper, CategoryMapper categoryMapper,CategoryRepository categoryRepository, ParameterRepository parameterRepository) {
    this.parameterMapper = parameterMapper;
    this.categoryMapper = categoryMapper;
    this.categoryRepository = categoryRepository;
    this.parameterRepository = parameterRepository;
  }

  public ExerciseResponse toExerciseResponse (ExerciseModel exerciseModel){
    return ExerciseResponse.builder().id(exerciseModel.getId())
      .name(exerciseModel.getExeciseName())
      .urlDemonstration(exerciseModel.getImgVideoUrl())
      .observations(exerciseModel.getObservations())
      .parameters(parameterMapper.toParametersResponse(exerciseModel.getParameterModel()))
      .categories(categoryMapper.toCategoryResponse(exerciseModel.getCategories())).build();
  }

  public List<ExerciseResponse> toExerciseResponse (List<ExerciseModel> exercises){
    return exercises.stream().map(ex->toExerciseResponse(ex)).toList();
  }

  public ExerciseModel toExerciseModel (ExerciseRequest exerciseRequest){
    return ExerciseModel.builder().execiseName(exerciseRequest.getName())
      .imgVideoUrl(exerciseRequest.getUlrDemonstration())
      .observations(exerciseRequest.getObservations())
      .categories(categoryRepository.findAllByIdOrELseThrow(exerciseRequest.getCategoriesId()))
      .parameterModel(parameterRepository.findByIdOrElseThrow(exerciseRequest.getParameterId())).build();
    }
  
}
