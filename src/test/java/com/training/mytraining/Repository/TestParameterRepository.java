package com.training.mytraining.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

import com.training.mytraining.exceptions.ParameterNotFoundException;
import com.training.mytraining.model.ParameterModel;
import com.training.mytraining.repository.ParameterRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestParameterRepository {
  
  @Autowired
  private ParameterRepository parameterRepository;

  @BeforeAll
  void start(){
    parameterRepository.save( new ParameterModel(0L
    , 3, null, LocalTime.of(0, 0, 30), new BigDecimal(5), 30));

  }

  @Test
  public void testFindByIdOrElseThrow(){
    var parameter = parameterRepository.findByIdOrElseThrow(1L);
    assertEquals(3,parameter.getSeries());
    assertEquals(parameter.getId(), 1L);

    JpaObjectRetrievalFailureException thrown = Assertions.assertThrows(
      JpaObjectRetrievalFailureException.class, ()->{
        parameterRepository.findByIdOrElseThrow(10L); //id 10 not exist
      });

      assertEquals(new JpaObjectRetrievalFailureException(
        new ParameterNotFoundException(10L)).getMessage(), thrown.getMessage());
  }
}
