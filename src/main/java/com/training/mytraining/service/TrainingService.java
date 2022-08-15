package com.training.mytraining.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.mytraining.dtos.training.TrainingRequest;
import com.training.mytraining.dtos.training.TrainingResponse;
import com.training.mytraining.mappers.TrainingMapper;
import com.training.mytraining.repository.TrainingRepository;

@Service
public class TrainingService {

  private final TrainingMapper trainingMapper;
  private final TrainingRepository trainingRepository;

  public TrainingService(TrainingMapper trainingMapper, TrainingRepository trainingRepository){
    this.trainingMapper = trainingMapper;
    this.trainingRepository = trainingRepository;
  }
  
  public ResponseEntity<TrainingResponse> registerTraining(TrainingRequest request){
    var training = trainingMapper.toModel(request);
    var response = trainingMapper.toTrainingResponse(trainingRepository.save(training));
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
