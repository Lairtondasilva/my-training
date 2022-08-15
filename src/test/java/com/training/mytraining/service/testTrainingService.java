package com.training.mytraining.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.training.mytraining.dtos.training.TrainingRequest;
import com.training.mytraining.dtos.training.TrainingResponse;
import com.training.mytraining.mappers.TrainingMapper;
import com.training.mytraining.model.TrainingModel;
import com.training.mytraining.repository.TrainingRepository;

@ExtendWith(MockitoExtension.class)
public class testTrainingService {
  
  @Mock
  private TrainingMapper trainingMapper;

  @Mock
  private TrainingRepository trainingRepository;

  @InjectMocks
  private TrainingService trainingService;

  private TrainingRequest request = new TrainingRequest();
  private TrainingModel training = new TrainingModel(0L, "Meu Treino", LocalDate.of(2022, 6, 20), LocalDate.of(2022, 7, 20), null);
  private TrainingResponse response = new TrainingResponse(1L,"Meu Treino", LocalDate.of(2022, 6, 20), LocalDate.of(2022, 7, 20), null);
  @Test
  public void testRegisterTraining(){
    Mockito.when(trainingMapper.toModel(request)).thenReturn(training);
    Mockito.when(trainingRepository.save(training)).thenReturn(training);
    Mockito.when(trainingMapper.toTrainingResponse(training)).thenReturn(response);
    var response = trainingService.registerTraining(request);
    verify(trainingMapper).toModel(request);
    verify(trainingRepository).save(training);
    verify(trainingMapper).toTrainingResponse(training);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals("Meu Treino", response.getBody().getName());
  }
}
