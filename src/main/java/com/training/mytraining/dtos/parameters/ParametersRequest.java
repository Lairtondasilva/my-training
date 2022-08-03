package com.training.mytraining.dtos.parameters;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParametersRequest {

  @NotNull
  @Positive
  private Integer series;
  @Positive
  private Integer repetitions;
  private LocalTime duration;
  @Positive
  private BigDecimal charge;
  @NotNull
  @Positive
  private Integer rest;
  
}
