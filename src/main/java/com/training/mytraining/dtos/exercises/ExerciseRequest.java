package com.training.mytraining.dtos.exercises;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class ExerciseRequest {

  @NotNull
  @NotBlank
  private String name;
  @URL
  private String ulrDemonstration;
  private String observations;
  @NotNull
  private List<Long> categoriesId;

  private Long parameterId;
}
