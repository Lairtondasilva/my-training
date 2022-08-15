package com.training.mytraining.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.training.mytraining.dtos.parameters.ParametersRequest;
import com.training.mytraining.dtos.parameters.ParametersResponse;
import com.training.mytraining.model.ParameterModel;

@ExtendWith(MockitoExtension.class)
public class TestParameterMapper {

  @InjectMocks
  private ParameterMapper parameterMapper;

  private ParameterModel parameterModel = new ParameterModel(1L
  , 3, null, LocalTime.of(0, 0, 30), new BigDecimal(5), 30);

  private ParametersRequest request = new ParametersRequest(3,12, null, new BigDecimal(5), 10);
 
  @Test
  public void testToParameterResponse (){
    var response = parameterMapper.toParametersResponse(parameterModel);
    assertEquals(response.getClass(), new ParametersResponse().getClass());
    assertEquals(response.getCharge(), new BigDecimal(5));
  }

  @Test
  public void testToModel(){
    var parameter = parameterMapper.toModel(request);
    assertEquals(ParameterModel.class, parameter.getClass());
  }
}
