package com.training.mytraining.dtos.exercises;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.training.mytraining.dtos.category.CategoryResponse;
import com.training.mytraining.dtos.parameters.ParametersResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class ExerciseResponse {

  private Long id;
  private String name;
  private String urlDemonstration;
  private List<CategoryResponse> categories;
  private ParametersResponse parameters;
}
