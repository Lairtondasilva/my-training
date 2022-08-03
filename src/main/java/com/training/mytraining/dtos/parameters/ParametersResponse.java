package com.training.mytraining.dtos.parameters;

import java.math.BigDecimal;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParametersResponse {

  private Long id;
  private Integer series;
  private Integer repetitions;
  private LocalTime duration;
  private BigDecimal charge;
  private Integer rest;

}
