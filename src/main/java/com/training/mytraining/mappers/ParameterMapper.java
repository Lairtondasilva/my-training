package com.training.mytraining.mappers;

import com.training.mytraining.dtos.parameters.ParametersResponse;
import com.training.mytraining.model.ParameterModel;

public class ParameterMapper {

  public ParametersResponse toParametersResponse(ParameterModel parameter){
    return ParametersResponse.builder().id(parameter.getId())
    .series(parameter.getSeries())
    .charge(parameter.getCharge())
    .duration(parameter.getDuration())
    .rest(parameter.getRest()).build();
  }
}
