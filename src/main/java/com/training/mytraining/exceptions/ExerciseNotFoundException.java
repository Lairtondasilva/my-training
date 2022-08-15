package com.training.mytraining.exceptions;

import javax.persistence.EntityNotFoundException;

public class ExerciseNotFoundException extends EntityNotFoundException{

  public ExerciseNotFoundException(Long id) {
    super("Exercise with id ["+id+"] not found!");
  }

  public ExerciseNotFoundException(String message) {
    super(message);
  }
    
}
