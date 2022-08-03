package com.training.mytraining.dtos.training;

import java.time.LocalDate;
import java.util.List;

import com.training.mytraining.dtos.exercises.ExerciseResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingResponse {
  
  private Long id;
  private LocalDate startTraining;
  private LocalDate endTraining;
  private List<ExerciseResponse> exercises;
}
